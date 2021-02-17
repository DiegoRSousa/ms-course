package com.diego.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diego.hrworker.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
