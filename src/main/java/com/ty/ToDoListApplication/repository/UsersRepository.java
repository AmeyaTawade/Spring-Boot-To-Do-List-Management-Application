package com.ty.ToDoListApplication.repository;

import com.ty.ToDoListApplication.dto.UsersDto;
import com.ty.ToDoListApplication.model.UsersModel;

public interface UsersRepository {

	void registerUser(UsersDto user);
	UsersModel findByUsername(String userName);
	void loginUser(String username, String pass);
}
