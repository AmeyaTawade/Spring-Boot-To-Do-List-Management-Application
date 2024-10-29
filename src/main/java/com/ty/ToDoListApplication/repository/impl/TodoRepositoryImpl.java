package com.ty.ToDoListApplication.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.ToDoListApplication.dto.TodoDto;
import com.ty.ToDoListApplication.model.TodoModel;
import com.ty.ToDoListApplication.model.rowmapper.TodoRowmapper;
import com.ty.ToDoListApplication.repository.TodoRepository;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void addTodoTask(TodoDto todo) {
		String sql = "INSERT INTO todo (title, description, user_id) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, todo.getTitle(), todo.getDescription(), todo.getUserId());
	}

	@Override
	public List<TodoModel> showAll(int id) {
		String sql = "SELECT * FROM todo WHERE user_id = ?";
		return jdbcTemplate.query(sql, new TodoRowmapper(), id);
	}

	@Override
	public void updateTask(TodoModel todo) {
		String sql = "UPDATE todo SET title = ?, description = ? WHERE id = ?";
		jdbcTemplate.update(sql, todo.getTitle(), todo.getDescription(), todo.getId());
	}

	@Override
	public void changeStatus(int id) {
		String sql ="UPDATE todo SET status = completed WHERE id =?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public void deleteTask(int id) {
		String sql = "DELETE FROM todo WHERE id =?";
		jdbcTemplate.update(sql, id);
	}

	
	
}
