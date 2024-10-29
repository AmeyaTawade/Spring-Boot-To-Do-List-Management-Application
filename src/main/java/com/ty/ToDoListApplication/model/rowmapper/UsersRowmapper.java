package com.ty.ToDoListApplication.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ty.ToDoListApplication.model.UsersModel;

public class UsersRowmapper implements RowMapper<UsersModel> {

	@Override
	public UsersModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UsersModel usersModel = new UsersModel();
		usersModel.setId(rs.getInt("id"));
		usersModel.setUsername(rs.getString("username"));
		usersModel.setPassword(rs.getString("pass"));
		usersModel.setRole(rs.getString("role"));
		return usersModel;
	}

}
