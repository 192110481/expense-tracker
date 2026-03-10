package com.expensetracker.controller;

import com.expensetracker.dto.SummaryResponse;
import com.expensetracker.dto.TransactionRequest;
import com.expensetracker.dto.TransactionResponse;
import com.expensetracker.entity.Transaction;
import com.expensetracker.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public String addTransaction(@RequestBody TransactionRequest request){
        return transactionService.addTransaction(request);
    }

    @GetMapping
    public List<TransactionResponse> getTransactions(){
        return transactionService.getTransactions();
    }

    @GetMapping("/summary")
    public SummaryResponse getSummary(){
        return transactionService.getSummary();
    }

    @GetMapping("/month")
    public List<Transaction> getTransactionsByMonth(@RequestParam int month,
                                                    @RequestParam int year){

        return transactionService.getTransactionsByMonth(month, year);
    }

    @GetMapping("/page")
    public Page<Transaction> getTransactions(@RequestParam int page,
                                             @RequestParam int size){

        return transactionService.getTransactions(page, size);

    }

}