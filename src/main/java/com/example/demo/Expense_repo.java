package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Expense_repo extends JpaRepository<Expense_Tracker, Integer> {

	@Query("SELECT SUM(e.amount) FROM Expense_Tracker e")
	Double getTotalDouble();
}
