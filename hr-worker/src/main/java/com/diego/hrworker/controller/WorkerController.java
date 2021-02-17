package com.diego.hrworker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diego.hrworker.model.Worker;
import com.diego.hrworker.repository.WorkerRepository;

@RestController
@RequestMapping("workers")
public class WorkerController {

	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		var workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		var worker = workerRepository.findById(id).get();
		return ResponseEntity.ok(worker);
	}
}
