package com.github.xiaour.sapi.servlet;

import com.github.xiaour.sapi.logging.Log;
import com.github.xiaour.sapi.logging.LogFactory;
import com.github.xiaour.sapi.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FaqServlet", urlPatterns = {"/faq"})
public class FaqServlet extends HttpServlet {

    private final static Log LOG = LogFactory.getLog(FaqServlet.class);


    protected final String resourcePath;


    public FaqServlet(){
        this.resourcePath = "support/http";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {


        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        String requestURI = request.getRequestURI();

        response.setCharacterEncoding("utf-8");

        if (contextPath == null) { // root context
            contextPath = "";
        }
        String uri = contextPath + servletPath;
        String path = requestURI.substring(contextPath.length() + servletPath.length());

        if ("/".equals(path)||"".equals(path)) {
            path="/faq.html";
        }

        try {
            returnResourceFile(path, uri, response);
        } catch (ServletException e) {
            LOG.error("Sapi init exception:",e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req,resp);
    }

    protected void returnResourceFile(String fileName, String uri, HttpServletResponse response)
            throws ServletException,
            IOException {

        String filePath = getFilePath(fileName);

        if (filePath.endsWith(".html")) {
            response.setContentType("text/html; charset=utf-8");
        }
        if (fileName.endsWith(".jpg")) {
            byte[] bytes = Utils.readByteArrayFromResource(filePath);
            if (bytes != null) {
                response.getOutputStream().write(bytes);
            }

            return;
        }

        String text = Utils.readFromResource(filePath);
        if (text == null) {
            response.sendRedirect(uri + "/index.html");
            return;
        }
        if (fileName.endsWith(".css")) {
            response.setContentType("text/css;charset=utf-8");

        } else if (fileName.endsWith(".js")) {
            response.setContentType("text/javascript;charset=utf-8");
        }
        response.getWriter().write(text);
    }

    protected String getFilePath(String fileName) {
        return resourcePath + fileName;
    }

}
