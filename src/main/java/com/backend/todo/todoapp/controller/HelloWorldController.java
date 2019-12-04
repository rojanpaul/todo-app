package com.backend.todo.todoapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.todo.todoapp.model.HelloWorldBean;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

	@GetMapping(value = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
//		throw new RuntimeException("Some exeception has occured. "
//				+ "Please contact support");
		return new HelloWorldBean("Hello World Bean");
	}

	@GetMapping(value = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(value = "/hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanWithPath(@PathVariable String name) {
//		throw new RuntimeException("Some exeception has occured. "
//				+ "Please contact support");
		return new HelloWorldBean("Hello " + name);
	}

}
