package com.expensetracker.repository;

import com.expensetracker.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = :type AND t.user.id = :userId")
    Double getTotalByType(@Param("type") String type, @Param("userId") Long userId);

    @Query("SELECT t FROM Transaction t WHERE MONTH(t.date) = :month AND YEAR(t.date) = :year AND t.user.id = :userId")
    List<Transaction> getTransactionsByMonth(@Param("month") int month,
                                             @Param("year") int year,
                                             @Param("userId") Long userId);

    Page<Transaction> findByUserId(Long userId, Pageable pageable);

}