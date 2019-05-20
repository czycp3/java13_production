package com.cskaoyan.bean;

public class MaterialConsume {
    private int consumeAmount;
    private String  consumeDate;
    private String note;
    private String receiver;
    private String sender;
    private MaterialMessage material;
    private Work work;

    @Override
    public String toString() {
        return "MaterialConsume{" +
                "consumeAmount=" + consumeAmount +
                ", consumeDate='" + consumeDate + '\'' +
                ", note='" + note + '\'' +
                ", receiver='" + receiver + '\'' +
                ", sender='" + sender + '\'' +
                ", material=" + material +
                ", work=" + work +
                '}';
    }

    public int getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(int consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public String getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public MaterialMessage getMaterial() {
        return material;
    }

    public void setMaterial(MaterialMessage material) {
        this.material = material;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
