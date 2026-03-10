package com.expensetracker.service;

import com.expensetracker.dto.SummaryResponse;
import com.expensetracker.dto.TransactionRequest;
import com.expensetracker.entity.Category;
import com.expensetracker.entity.Transaction;
import com.expensetracker.entity.User;
import com.expensetracker.repository.CategoryRepository;
import com.expensetracker.repository.TransactionRepository;
import com.expensetracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import com.expensetracker.dto.TransactionResponse;
import java.util.ArrayList;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              CategoryRepository categoryRepository,
                              UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public String addTransaction(TransactionRequest request) {

        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Transaction transaction = new Transaction();

        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());
        transaction.setNote(request.getNote());
        transaction.setDate(LocalDate.now());
        transaction.setUser(user);
        transaction.setCategory(category);

        transactionRepository.save(transaction);

        return "Transaction added successfully";
    }

    public List<TransactionResponse> getTransactions() {

        List<Transaction> transactions =
                transactionRepository.findByUserId(1L);

        List<TransactionResponse> response = new ArrayList<>();

        for (Transaction t : transactions) {

            response.add(new TransactionResponse(
                    t.getId(),
                    t.getAmount(),
                    t.getType(),
                    t.getCategory().getName(),
                    t.getNote(),
                    t.getDate()
            ));

        }

        return response;
    }

    public SummaryResponse getSummary(){

        Double income = transactionRepository.getTotalByType("INCOME", 1L);
        Double expense = transactionRepository.getTotalByType("EXPENSE", 1L);

        if(income == null) income = 0.0;
        if(expense == null) expense = 0.0;

        Double balance = income - expense;

        return new SummaryResponse(income, expense, balance);
    }

    public List<Transaction> getTransactionsByMonth(int month, int year){

        return transactionRepository.getTransactionsByMonth(month, year, 1L);

    }

    public Page<Transaction> getTransactions(int page, int size){

        Pageable pageable = PageRequest.of(page, size);

        return transactionRepository.findByUserId(1L, pageable);

    }


}