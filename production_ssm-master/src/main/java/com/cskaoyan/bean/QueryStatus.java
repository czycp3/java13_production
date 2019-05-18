package com.cskaoyan.bean;

/**
 * 封装查询的状态
 * @author CZY
 */
public class QueryStatus {
    private int status;
    private String msg;
    private String data;
    private int error;
    private String url;


    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public QueryStatus() {
    }

    public QueryStatus(int status, String msg, String data, int error, String url) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.error = error;
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QueryStatus{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data='" + data + '\'' +
                ", error=" + error +
                ", url='" + url + '\'' +
                '}';
    }

}
