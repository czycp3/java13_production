package com.cskaoyan.bean;

/**
 * 工序表
 * @Author cly
 */
public class Process {
    private String processId;
    private String technologyPlanId;
    private Integer quota;
    private Integer sequence;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    @Override
    public String toString() {
        return "Process{" +
                "processId='" + processId + '\'' +
                ", technologyPlanId='" + technologyPlanId + '\'' +
                ", sequence=" + sequence +
                ", quota=" + quota +
                '}';
    }
}
