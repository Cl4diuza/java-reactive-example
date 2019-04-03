package com.fun.reactiveweb.service;

import com.fun.reactiveweb.entity.Employee;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IEmploeeService {
	void create(Employee e);

	Mono<Employee> findById(Integer id);

	Flux<Employee> findByName(String name);

	Flux<Employee> findAll();

	Mono<Employee> update(Employee e);

	Mono<Void> delete(Integer id);
}
