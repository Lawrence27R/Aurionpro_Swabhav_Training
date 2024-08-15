package com.aurionpro.entity;

import java.util.Date;

public class Transaction {
    private String senderAccNum;
    private String receiversAccNum;
    private String typeOfTrans;
    private double amount;
    private Date date;

    public Transaction(String senderAccNum, String receiversAccNum, String typeOfTrans, double amount, Date date) {
        this.senderAccNum = senderAccNum;
        this.receiversAccNum = receiversAccNum;
        this.typeOfTrans = typeOfTrans;
        this.amount = amount;
        this.date = date;
    }

    // Getters and Setters
    public String getSenderAccNum() { return senderAccNum; }
    public void setSenderAccNum(String senderAccNum) { this.senderAccNum = senderAccNum; }

    public String getReceiversAccNum() { return receiversAccNum; }
    public void setReceiversAccNum(String receiversAccNum) { this.receiversAccNum = receiversAccNum; }

    public String getTypeOfTrans() { return typeOfTrans; }
    public void setTypeOfTrans(String typeOfTrans) { this.typeOfTrans = typeOfTrans; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
