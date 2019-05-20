package com.cskaoyan.bean;

/**
 * @author CZY-Y7000P
 */
public class Task {
    private String taskId;

    private String manufactureSn;

    private Manufacture manufacture;

    private String workId;

    private Work work;

    private Integer taskQuantity;

    private Long workingHours;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getManufactureSn() {
        return manufactureSn;
    }

    public void setManufactureSn(String manufactureSn) {
        this.manufactureSn = manufactureSn == null ? null : manufactureSn.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public Integer getTaskQuantity() {
        return taskQuantity;
    }

    public void setTaskQuantity(Integer taskQuantity) {
        this.taskQuantity = taskQuantity;
    }

    public Long getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Long workingHours) {
        this.workingHours = workingHours;
    }

    public Manufacture getManufacture() {
        return manufacture;
    }

    public void setManufacture(Manufacture manufacture) {
        this.manufacture = manufacture;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}