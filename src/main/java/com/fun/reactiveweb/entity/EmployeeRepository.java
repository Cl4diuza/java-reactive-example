package com.fun.reactiveweb.entity;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, Integer> {
	@Tailable
	@Query("{ 'name': ?0 }")
	Flux<Employee> findByName(final String name);
}
