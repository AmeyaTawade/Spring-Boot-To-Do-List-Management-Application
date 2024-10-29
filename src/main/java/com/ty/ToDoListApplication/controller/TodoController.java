package com.ty.ToDoListApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ToDoListApplication.dto.TodoDto;
import com.ty.ToDoListApplication.model.TodoModel;
import com.ty.ToDoListApplication.service.TodoService;
import com.ty.ToDoListApplication.utils.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/save")
	public ResponseEntity<String> addTodoTask (@RequestBody TodoDto todo, HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authorization header missing or invalid");
		}
		
		String token = authHeader.substring(7);
		try {
			String username = jwtUtil.extractUsername(token);
			if(username == null || !jwtUtil.validateToken(token, username)) {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid JWT Token");
			}
			
			todoService.addTodoTask(todo);
			return ResponseEntity.ok("Your Task has been added to the list");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/alltasks")
	public List<TodoModel> showAll(@RequestParam int id) {
		try {
			return todoService.showAll(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updateTask(@RequestBody TodoDto todo) {
		try {
			todoService.updateTask(todo);
			return ResponseEntity.ok("your task has been updated");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	@PostMapping("/status")
	public ResponseEntity<String> changeStatus(@RequestParam int id) {
		try {
			todoService.changeStatus(id);
			return ResponseEntity.ok("Task status is updated");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@PostMapping("/delete")
	public ResponseEntity<String> deleteTask(@RequestParam int id) {
		try {
			todoService.deleteTask(id);
			return ResponseEntity.ok("Task deleted");
		} catch (Exception e) {
			throw  new RuntimeException(e);
		}
	}
}
