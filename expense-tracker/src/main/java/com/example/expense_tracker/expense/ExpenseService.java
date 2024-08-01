package com.example.expense_tracker.expense;

import com.example.expense_tracker.exception.ExpenseNotFoundException;
import com.example.expense_tracker.user.User;
import com.example.expense_tracker.user.UserRepository;
import com.example.expense_tracker.user.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private UserRepository userRepository;
    private ExpenseRepository expenseRepository;
    private UserService userService;

    public ExpenseService(UserRepository userRepository, ExpenseRepository expenseRepository, UserService userService) {
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
        this.userService = userService;
    }

    public List<Expense> addExpense(int id, Expense expense) {
        User user = userService.retrieveUserById(id);

        if (user.getExpenseList() == null) {
            user.setExpenseList(new ArrayList<>());
        }

        expense.setId(null);
        expense.setUser(user);
        user.getExpenseList().add(expense);

        expenseRepository.save(expense);

        userRepository.save(user);

        return user.getExpenseList();
    }

    public Expense updateExpense(int id, int expenseId, Expense expense) {
        User user = userService.retrieveUserById(id);

        Expense expenseToUpdate = expenseRepository.findById(expenseId).orElseThrow(
                ExpenseNotFoundException::new);

        expenseToUpdate.setId(expense.getId());
        expenseToUpdate.setUser(user);
        expenseToUpdate.setName(expense.getName());
        expenseToUpdate.setPrice(expense.getPrice());
        expenseToUpdate.setCategory(expense.getCategory());
        expenseToUpdate.setTime(expense.getTime());

        return expenseRepository.save(expenseToUpdate);

    }

    public void deleteExpenseById(int id) {
        Optional<Expense> expenseToDelete = expenseRepository.findById(id);
        if (expenseToDelete.isEmpty()){
            throw new ExpenseNotFoundException();
        }
        expenseRepository.deleteById(id);
    }
}
