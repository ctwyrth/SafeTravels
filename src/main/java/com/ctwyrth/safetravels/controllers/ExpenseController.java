package com.ctwyrth.safetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ctwyrth.safetravels.models.Expense;
import com.ctwyrth.safetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	// -----------------------variables-----------------------
	@Autowired
	private ExpenseService expenseService;
	
	// show all expenses and create new expense 
    @GetMapping("/expenses")
    public String index(@ModelAttribute("expense") Expense expense, Model model) {
    	List<Expense> expenses = expenseService.allExpenses();
    	model.addAttribute("expenses", expenses);
        return "/expenses/index.jsp";
    }
    @PostMapping("/expenses")
    public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
    	if (result.hasErrors()) {
    		List<Expense> expenses = expenseService.allExpenses();
        	model.addAttribute("expenses", expenses);
    		return "/expenses/index.jsp";
    	} else {
    		expenseService.createExpense(expense);
    		return "redirect:/expenses";
    	}
    }
	
	// display the information of one expense found by id
	@GetMapping("/expense/{id}")
	public String showOneBookById(@PathVariable("id") Long id, Model model) {
		Expense expenseToShow = expenseService.findExpense(id);
		model.addAttribute("expense", expenseToShow);
		return "/expenses/show.jsp";
	}
	
	// update an expense found by id
	
	// delete an expense
	@GetMapping("/expenses/delete/{id}")
	public String deleteOneExpense(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
}