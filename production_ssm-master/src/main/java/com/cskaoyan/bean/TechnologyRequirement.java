package com.cskaoyan.bean;

/**
 * @author cly
 */
public class TechnologyRequirement {
    private String technologyRequirementId;
    private String technologyId;
    private String requirement;
    private String addTime;
    private String reviseTime;
    private String technologyName;

    public TechnologyRequirement() {
    }

    public TechnologyRequirement(String technologyRequirementId, String technologyId, String requirement, String addTime, String reviseTime, String technologyName) {
        this.technologyRequirementId = technologyRequirementId;
        this.technologyId = technologyId;
        this.requirement = requirement;
        this.addTime = addTime;
        this.reviseTime = reviseTime;
        this.technologyName = technologyName;
    }

    public String getTechnologyRequirementId() {
        return technologyRequirementId;
    }

    public void setTechnologyRequirementId(String technologyRequirementId) {
        this.technologyRequirementId = technologyRequirementId;
    }

    public String getTechnologyId() {
        return technologyId;
    }

    public void setTechnologyId(String technologyId) {
        this.technologyId = technologyId;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getReviseTime() {
        return reviseTime;
    }

    public void setReviseTime(String reviseTime) {
        this.reviseTime = reviseTime;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    @Override
    public String toString() {
        return "TechnologyRequirement{" +
                "technologyRequirementId='" + technologyRequirementId + '\'' +
                ", technologyId='" + technologyId + '\'' +
                ", requirement='" + requirement + '\'' +
                ", addTime='" + addTime + '\'' +
                ", reviseTime='" + reviseTime + '\'' +
                ", technologyName='" + technologyName + '\'' +
                '}';
    }
}
