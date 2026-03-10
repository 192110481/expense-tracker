package com.expensetracker.dto;

import java.time.LocalDate;

public class TransactionResponse {

    private Long id;
    private double amount;
    private String type;
    private String category;
    private String note;
    private LocalDate date;

    public TransactionResponse(Long id, double amount, String type,
                               String category, String note, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.note = note;
        this.date = date;
    }

    public Long getId() { return id; }
    public double getAmount() { return amount; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public String getNote() { return note; }
    public LocalDate getDate() { return date; }
}