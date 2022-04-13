package com.ctwyrth.safetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ctwyrth.safetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
	// this method retrieves all from the database
    List<Expense> findAll();
    // this method finds books with descriptions containing the search string
    List<Expense> findByDescriptionContaining(String search);

}
