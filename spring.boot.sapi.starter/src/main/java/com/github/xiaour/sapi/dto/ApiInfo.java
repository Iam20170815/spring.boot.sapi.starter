package com.github.xiaour.sapi.dto;

import java.util.List;

/**
 * 接口信息
 */
public class ApiInfo {


    private Integer id;

    private String url;//URL

    private String requestType="";//请求类型

    private List<ApiField> fieldList;//字段

    private String success;//成功返回值

    private String error;//错误返回值

    private String other;//其他返回值

    private String name;//名称

    private String groupTitle;//分组名称

    public String getGroupTitle() {
        return groupTitle;
    }

    public void setGroupTitle(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public List<ApiField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<ApiField> fieldList) {
        this.fieldList = fieldList;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public void setId(){
        this.id=Math.abs(this.getUrl().hashCode());
    }

    public Integer getId(){
        return id;
    }

}
