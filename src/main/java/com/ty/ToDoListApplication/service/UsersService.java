package com.ty.ToDoListApplication.service;

import com.ty.ToDoListApplication.dto.UsersDto;
import com.ty.ToDoListApplication.model.UsersModel;

public interface UsersService {

	void registerUser(UsersDto user);
	UsersModel findByUsername(String userName);
}
