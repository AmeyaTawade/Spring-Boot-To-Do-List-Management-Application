package com.ty.ToDoListApplication.repository;

import java.util.List;

import com.ty.ToDoListApplication.dto.TodoDto;
import com.ty.ToDoListApplication.model.TodoModel;

public interface TodoRepository {

	void addTodoTask(TodoDto todo);
	List<TodoModel> showAll(int id);
	void updateTask(TodoModel todo);
	void changeStatus(int id);
	void deleteTask(int id);	
}
