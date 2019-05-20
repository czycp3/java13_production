package com.cskaoyan.bean;

import java.util.Date;

/**
 * 工艺计划表
 * @Author cly
 */
public class TechnologyPlan {
    private String technologyPlanId;
    private String technologyId;
    private Integer batchAmount;
    private String startPlan;
    private String endPlan;
    private String commitPlan;
    private String technologyPlanStart;
    private String technologyPlanEnd;
    private String technologyName;

    public TechnologyPlan() {
    }

    public TechnologyPlan(String technologyPlanId, String technologyId, Integer batchAmount, String startPlan, String endPlan, String commitPlan, String technologyPlanStart, String technologyPlanEnd, String technologyName) {
        this.technologyPlanId = technologyPlanId;
        this.technologyId = technologyId;
        this.batchAmount = batchAmount;
        this.startPlan = startPlan;
        this.endPlan = endPlan;
        this.commitPlan = commitPlan;
        this.technologyPlanStart = technologyPlanStart;
        this.technologyPlanEnd = technologyPlanEnd;
        this.technologyName = technologyName;
    }

    public String getTechnologyPlanId() {
        return technologyPlanId;
    }

    public void setTechnologyPlanId(String technologyPlanId) {
        this.technologyPlanId = technologyPlanId;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public Integer getBatchAmount() {
        return batchAmount;
    }

    public void setBatchAmount(Integer batchAmount) {
        this.batchAmount = batchAmount;
    }

    public String getStartPlan() {
        return startPlan;
    }

    public void setStartPlan(String startPlan) {
        this.startPlan = startPlan;
    }

    public String getEndPlan() {
        return endPlan;
    }

    public void setEndPlan(String endPlan) {
        this.endPlan = endPlan;
    }

    public String getCommitPlan() {
        return commitPlan;
    }

    public void setCommitPlan(String commitPlan) {
        this.commitPlan = commitPlan;
    }

    public String getTechnologyPlanStart() {
        return technologyPlanStart;
    }

    public void setTechnologyPlanStart(String technologyPlanStart) {
        this.technologyPlanStart = technologyPlanStart;
    }

    public String getTechnologyPlanEnd() {
        return technologyPlanEnd;
    }

    public void setTechnologyPlanEnd(String technologyPlanEnd) {
        this.technologyPlanEnd = technologyPlanEnd;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    @Override
    public String toString() {
        return "TechnologyPlan{" +
                "technologyPlanId='" + technologyPlanId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", batchAmount=" + batchAmount +
                ", startPlan='" + startPlan + '\'' +
                ", endPlan='" + endPlan + '\'' +
                ", commitPlan='" + commitPlan + '\'' +
                ", technologyPlanStart='" + technologyPlanStart + '\'' +
                ", technologyPlanEnd='" + technologyPlanEnd + '\'' +
                ", technologyName='" + technologyName + '\'' +
                '}';
    }
}
