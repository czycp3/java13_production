package com.cskaoyan.bean;

public class MaterialReceive {
    private String receiveId;
    private int amount;
    private MaterialMessage material;
    private String receiveDate;
    private String receiver;
    private String sender;
    private String note;

    @Override
    public String toString() {
        return "MaterialReceive{" +
                "receiveId='" + receiveId + '\'' +
                ", amount=" + amount +
                ", material=" + material +
                ", receiveDate='" + receiveDate + '\'' +
                ", receiver='" + receiver + '\'' +
                ", sender='" + sender + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public MaterialMessage getMaterial() {
        return material;
    }

    public void setMaterial(MaterialMessage material) {
        this.material = material;
    }


    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
