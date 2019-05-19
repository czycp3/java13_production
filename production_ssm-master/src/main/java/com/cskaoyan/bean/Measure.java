package com.cskaoyan.bean;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 11:25
 */
public class Measure {
    private String fMeasureCheckId; //成品计量质检编号
    private String orderId; //订单编号
    private String checkItem; //检验项目
    private String cdate; //检验时间
    private String measureData; //实际测量数据
    private String empId; //检验人ID
    private String empName; //检验人姓名
    private String result; //检验结果
    private String note; //备注

    public Measure() {
    }

    public Measure(String fMeasureCheckId, String orderId, String checkItem, String cdate, String measureData, String empId, String empName, String result, String note) {
        this.fMeasureCheckId = fMeasureCheckId;
        this.orderId = orderId;
        this.checkItem = checkItem;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empId = empId;
        this.empName = empName;
        this.result = result;
        this.note = note;
    }

    public String getfMeasureCheckId() {
        return fMeasureCheckId;
    }

    public void setfMeasureCheckId(String fMeasureCheckId) {
        this.fMeasureCheckId = fMeasureCheckId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }

    public String getMeasureData() {
        return measureData;
    }

    public void setMeasureData(String measureData) {
        this.measureData = measureData;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "fMeasureCheckId='" + fMeasureCheckId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", checkItem='" + checkItem + '\'' +
                ", cdate='" + cdate + '\'' +
                ", measureData='" + measureData + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
