package com.example.expense_tracker.expense;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    List<Expense> findByNameIgnoreCase(String name);
    List<Expense> findByCategoryIgnoreCase(String name);
}
