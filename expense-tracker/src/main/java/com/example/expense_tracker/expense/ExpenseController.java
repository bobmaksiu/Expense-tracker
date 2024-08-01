package com.example.expense_tracker.expense;

import com.example.expense_tracker.user.User;
import com.example.expense_tracker.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    private UserService userService;
    private ExpenseService expenseService;

    public ExpenseController(UserService userService, ExpenseService expenseService) {
        this.userService = userService;
        this.expenseService = expenseService;
    }

    @GetMapping("/users/{id}/expenses")
    public ResponseEntity<List> retrieveUserExpenses(@PathVariable int id) {
        User user = userService.retrieveUserById(id);
        return new ResponseEntity<List>(user.getExpenseList(), HttpStatus.OK);
    }

    @PostMapping("/users/{id}/expenses")
    public ResponseEntity<List<Expense>> addExpense(@PathVariable int id, @Valid Expense expense) {
        List<Expense> createdExpense = expenseService.addExpense(id, expense);
        return new ResponseEntity<List<Expense>>(createdExpense, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}/expenses/{expenseId}")
    public ResponseEntity<Expense> updateExpense(@PathVariable int id, @PathVariable int expenseId,
                                                 @Valid Expense expense) throws Exception {
        Expense updatedExpense = expenseService.updateExpense(id, expenseId, expense);
        return new ResponseEntity<Expense>(updatedExpense, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/expenses/{expenseId}")
    public ResponseEntity<String> deleteExpense(@PathVariable int expenseId) {
        expenseService.deleteExpenseById(expenseId);
        return ResponseEntity.ok("Expense deleted successfully.");
    }
}
