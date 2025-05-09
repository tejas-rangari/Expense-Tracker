package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Expense_controller {

	@Autowired
	private Expense_repo expense_repo;
	
	@PostMapping("/saveValuess")
	public List<Expense_Tracker>saveData(@RequestBody List<Expense_Tracker>et){
		return expense_repo.saveAll(et);
	}
	
	@DeleteMapping("/deleteValues")
	public void deletData() {
		expense_repo.deleteAll();
	}
	
	@GetMapping("/displayData")
	public List<Expense_Tracker>getAll(Expense_Tracker ext){
		return expense_repo.findAll();
	}
	
	@PutMapping("/updateData")
	public Expense_Tracker update(@RequestParam Expense_Tracker tra) {
		return expense_repo.save(tra);
	}
	
	@PutMapping("/newUpdate")
	public Expense_Tracker newUpdate(@RequestBody Expense_Tracker xp) {
		return expense_repo.save(xp);
	}
	
	@GetMapping("/sumAmount")
	public ResponseEntity<Double>getTotalExpense(){
		double total=expense_repo.getTotalDouble();
		return ResponseEntity.ok(total);
	}
}
