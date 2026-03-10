package com.expensetracker.dto;

public class TransactionRequest {

    private double amount;
    private String type;
    private Long categoryId;
    private String note;

    public TransactionRequest(){}

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public Long getCategoryId() { return categoryId; }

    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }
}