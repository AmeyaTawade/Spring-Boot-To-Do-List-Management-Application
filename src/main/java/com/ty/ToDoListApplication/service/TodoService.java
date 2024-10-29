package com.ty.ToDoListApplication.service;

import java.util.List;

import com.ty.ToDoListApplication.dto.TodoDto;
import com.ty.ToDoListApplication.model.TodoModel;

public interface TodoService {

	void addTodoTask(TodoDto todo);
	List<TodoModel> showAll(int id);
	void updateTask(TodoDto todo);
	void changeStatus(int id);
	void deleteTask(int id);
}
