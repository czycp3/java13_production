package com.cskaoyan.bean;

/**
 * @auther 芮狼Dan
 * @date 2019-05-20 00:28
 */
public class PCountCheck {
    private  String  pCountCheckId;
    private  String  processId;
    private  String  checkItem;
    private  int  sample;
    private  int checkNumber;
    private  int  unqualify;
    private  double  qualify;
    private  String  cdate;
    private  String  measureData;
    private  String  empId;
    private  String  result;
    private  String  note;
    private  String  empName;

    public PCountCheck() {
    }

    public PCountCheck(String pCountCheckId, String processId, String checkItem, int sample, int checkNumber, int unqualify, double qualify, String cdate, String measureData, String empId, String result, String note, String empName) {
        this.pCountCheckId = pCountCheckId;
        this.processId = processId;
        this.checkItem = checkItem;
        this.sample = sample;
        this.checkNumber = checkNumber;
        this.unqualify = unqualify;
        this.qualify = qualify;
        this.cdate = cdate;
        this.measureData = measureData;
        this.empId = empId;
        this.result = result;
        this.note = note;
        this.empName = empName;
    }

    public String getpCountCheckId() {
        return pCountCheckId;
    }

    public void setpCountCheckId(String pCountCheckId) {
        this.pCountCheckId = pCountCheckId;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Override
    public String toString() {
        return "PCountCheck{" +
                "pCountCheckId='" + pCountCheckId + '\'' +
                ", processId='" + processId + '\'' +
                ", checkItem='" + checkItem + '\'' +
                ", sample=" + sample +
                ", checkNumber=" + checkNumber +
                ", unqualify=" + unqualify +
                ", qualify=" + qualify +
                ", cdate='" + cdate + '\'' +
                ", measureData='" + measureData + '\'' +
                ", empId='" + empId + '\'' +
                ", result='" + result + '\'' +
                ", note='" + note + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }
}
