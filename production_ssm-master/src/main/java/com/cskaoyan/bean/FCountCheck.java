package com.cskaoyan.bean;

/**
 * @auther 芮狼Dan
 * @date 2019-05-19 18:02
 */
public class FCountCheck {

    private String fCountCheckId; //成品计数质检编号
    private String orderId; //订单编号
    private String checkItem; //检验项目
    private int sample; //样本总数
    private int checkNumber; //抽检数
    private int unqualify; //不合格数
    private double qualify; //合格率
    private String cdate; //检验时间
    private String measureData; //实际测量数据
    private String empId; //检验人ID
    private String empName; //检验人姓名
    private String result; //检验结果
    private String note; //备注



    public FCountCheck() {
    }

    public FCountCheck(String fCountCheckId, String orderId, String checkItem, int sample, int checkNumber, int unqualify, double qualify, String cdate, String measureData, String empId, String empName, String result, String note) {
        this.fCountCheckId = fCountCheckId;
        this.orderId = orderId;
        this.checkItem = checkItem;
        this.sample = sample;
        this.checkNumber = checkNumber;
        this.unqualify = unqualify;
        this.qualify = qualify;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empId = empId;
        this.empName = empName;
        this.result = result;
        this.note = note;
    }

    public String getfCountCheckId() {
        return fCountCheckId;
    }

    public void setfCountCheckId(String fCountCheckId) {
        this.fCountCheckId = fCountCheckId;
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

    public int getSample() {
        return sample;
    }

    public void setSample(int sample) {
        this.sample = sample;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public int getUnqualify() {
        return unqualify;
    }

    public void setUnqualify(int unqualify) {
        this.unqualify = unqualify;
    }

    public double getQualify() {
        return qualify;
    }

    public void setQualify(double qualify) {
        this.qualify = qualify;
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
        return "FCountCheck{" +
                "fCountCheckId='" + fCountCheckId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", checkItem='" + checkItem + '\'' +
                ", sample=" + sample +
                ", checkNumber=" + checkNumber +
                ", unqualify=" + unqualify +
                ", qualify=" + qualify +
                ", cdate='" + cdate + '\'' +
                ", measureData='" + measureData + '\'' +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
