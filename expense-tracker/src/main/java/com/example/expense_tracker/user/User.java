package com.example.expense_tracker.user;

import com.example.expense_tracker.expense.Expense;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @OneToMany(mappedBy = "user")
    private List<Expense> expenseList;

    public User() {
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
        this.expenseList = new ArrayList<Expense>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) { this.expenseList = expenseList; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", expenseList=" + expenseList +
                '}';
    }
}
