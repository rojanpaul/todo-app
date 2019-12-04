package com.backend.todo.todoapp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HardCodedTodoData {
	
	private static List<Todo> todos = new ArrayList<>();
	private static int counterId=0;
	static {
		todos.add(new Todo(counterId++, "rojan", "Core Java 8", new Date(), false));
		todos.add(new Todo(counterId++, "rojan", "Spring Boot", new Date(), false));
		todos.add(new Todo(counterId++, "rojan", "Angular 8", new Date(), false));
		todos.add(new Todo(counterId++, "rojan", "Maven 2", new Date(), true));
		todos.add(new Todo(counterId++, "rojan", "Jenkins", new Date(), true));
	}
	
	public List<Todo> findAll() {
		return todos;
	}

	public Todo deleteById(Long id) {
		Todo todo = findById(id);
		if(todo != null){
			todos.remove(todo);
		}
		return todo;
	}

	public Todo findById(Long id) {
		for(Todo todo :todos) {
			if(id == todo.getId()) {
				return todo;
			}
		}
		return null;
	}

	public Todo updateById(Todo inTodo) {
		for(Todo todo :todos) {
			if(inTodo.getId() == todo.getId()) {
				todo.setDescription(inTodo.getDescription());
				todo.setName(inTodo.getName());
				System.out.println("Details are updating "+inTodo.getId());
				todo.setTargetDate(inTodo.getTargetDate());
				return todo;
			}
		}
		return null;
	}

	public Todo saveTodo(Todo todo) {
		todo.setId(counterId++);
		todos.add(todo);
		return todo;
	}
}
