package com.fun.reactiveweb.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fun.reactiveweb.entity.Employee;
import com.fun.reactiveweb.service.EmployeeService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("web")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("test")
	String test() {
		return "Reactive web is UP";
	}

	@GetMapping("/name/{name}")
	Flux<Employee> findEmployeeName(@PathVariable("name") String name) throws Exception {
		try {
			return service.findByName(name);
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("create")
	ResponseEntity<Void> createEmployee(@RequestBody Employee employee) throws Exception {
		try {
			service.create(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Employee> findAll() {
		Flux<Employee> emps = service.findAll();
		return emps.delayElements(Duration.ofMillis(2000));
	}

}
