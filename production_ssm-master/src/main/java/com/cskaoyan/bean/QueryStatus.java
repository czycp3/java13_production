package com.cskaoyan.bean;

public class QueryStatus {
    private int status;
    private String msg;
    private String data;

    public QueryStatus() {
    }

    public QueryStatus(int status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
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
                '}';
    }
}
