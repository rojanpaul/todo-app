package com.backend.todo.todoapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.todo.todoapp.model.HardCodedTodoData;
import com.backend.todo.todoapp.model.Todo;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {
	
	@Autowired
	private HardCodedTodoData hardCodedTodoData;
	
	@GetMapping(path="/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		return hardCodedTodoData.findAll();
		
	}

	@GetMapping(path="/users/{username}/todos/{id}")
	public Todo getAllTodos(@PathVariable String username,@PathVariable long id){
		return hardCodedTodoData.findById(id);
	}
	
	@DeleteMapping(path="/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable long id){
		Todo todo = hardCodedTodoData.deleteById(id);
		if(todo != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();

	}

	@PutMapping(path="/users/{username}/todos")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username,@RequestBody Todo todo){
		Todo todoUpdated = hardCodedTodoData.updateById(todo);
		return new ResponseEntity<>(todoUpdated,HttpStatus.CREATED);
	}

	@PostMapping(path="/users/{username}/todos")
	public ResponseEntity<Void> saveTodo(@PathVariable String username,@RequestBody Todo todo){
		Todo createdTodo = hardCodedTodoData.saveTodo(todo);
		//Location
		//Get current resource url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
