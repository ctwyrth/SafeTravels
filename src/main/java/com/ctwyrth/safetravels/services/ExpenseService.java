package com.ctwyrth.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctwyrth.safetravels.models.Expense;
import com.ctwyrth.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
	
    // creates an expense
    public Expense createExpense(Expense e) {
        return expenseRepository.save(e);
    }
    // retrieves a book by id
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // updates an expense
    public Expense updateExpense(Expense e) {
       	return expenseRepository.save(e);
    }
    
    // deletes an expense
    public void deleteExpense(Long id) {
    	expenseRepository.deleteById(id);
    }
}
