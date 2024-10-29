package com.ty.ToDoListApplication.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ty.ToDoListApplication.dto.UsersDto;
import com.ty.ToDoListApplication.model.UsersModel;
import com.ty.ToDoListApplication.model.rowmapper.UsersRowmapper;
import com.ty.ToDoListApplication.repository.UsersRepository;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void registerUser(UsersDto user) {
		String sql =  "INSERT INTO users (id, username, pass, role) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getRole());
	}

	@Override
	public UsersModel findByUsername(String userName) {
		String sql = "SELECT * FROM todo_list.users WHERE username = ?";
		return jdbcTemplate.queryForObject(sql, new UsersRowmapper(), userName);
	}

	@Override
	public void loginUser(String username, String pass) {
		String sql = "";
		
	}
}
