package com.fun.reactiveweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun.reactiveweb.entity.Employee;
import com.fun.reactiveweb.entity.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmploeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public void create(Employee e) {
		employeeRepo.save(e).subscribe();
	}

	@Override
	public Mono<Employee> findById(Integer id) {
		return employeeRepo.findById(id);
	}

	@Override
	public Flux<Employee> findByName(String name) {
		return employeeRepo.findByName(name);
	}

	@Override
	public Flux<Employee> findAll() {
		return employeeRepo.findAll();
	}

	@Override
	public Mono<Employee> update(Employee e) {
		return employeeRepo.save(e);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return employeeRepo.deleteById(id);
	}

}
