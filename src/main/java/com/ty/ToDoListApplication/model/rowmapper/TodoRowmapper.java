package com.ty.ToDoListApplication.model.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ty.ToDoListApplication.model.TodoModel;

public class TodoRowmapper implements RowMapper<TodoModel> {

	@Override
	public TodoModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		TodoModel todoModel = new TodoModel();
		todoModel.setId(rs.getInt("id"));
		todoModel.setTitle(rs.getString("title"));
		todoModel.setDescription(rs.getString("description"));
		todoModel.setStatus(rs.getString("status"));
		todoModel.setUserId(rs.getInt("user_id"));
		return todoModel;
	}

}
