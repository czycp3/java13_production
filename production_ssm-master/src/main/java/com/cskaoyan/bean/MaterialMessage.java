package com.cskaoyan.bean;

/**
 * @author q4work
 */
public class MaterialMessage {
    private String materialId;
    private String materialType;
    private String status;
    private int remaining;
    private String note;
    private String workId;

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRemaining() {
        return remaining;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MaterialMessage{" +
                "materialId='" + materialId + '\'' +
                ", materialType='" + materialType + '\'' +
                ", status='" + status + '\'' +
                ", remaining='" + remaining + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
