package com.ty.ToDoListApplication.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ToDoListApplication.dto.TodoDto;
import com.ty.ToDoListApplication.model.TodoModel;
import com.ty.ToDoListApplication.repository.TodoRepository;
import com.ty.ToDoListApplication.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	@Override
	public void addTodoTask(TodoDto todo) {
		todoRepository.addTodoTask(todo);
	}

	@Override
	public List<TodoModel> showAll(int id) {
		return todoRepository.showAll(id);
	}

	@Override
	public void updateTask(TodoDto todo) {
		todoRepository.updateTask(null);
	}

	@Override
	public void changeStatus(int id) {
		todoRepository.changeStatus(id);
	}

	@Override
	public void deleteTask(int id) {
		todoRepository.deleteTask(id);
	}

}
