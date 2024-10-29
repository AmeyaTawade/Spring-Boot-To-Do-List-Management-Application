package com.ty.ToDoListApplication.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.ToDoListApplication.dto.UsersDto;
import com.ty.ToDoListApplication.model.UsersModel;
import com.ty.ToDoListApplication.repository.UsersRepository;
import com.ty.ToDoListApplication.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	public void registerUser(UsersDto user) {
		usersRepository.registerUser(user);
	}

	@Override
	public UsersModel findByUsername(String userName) {
		return usersRepository.findByUsername(userName);
	}
}
