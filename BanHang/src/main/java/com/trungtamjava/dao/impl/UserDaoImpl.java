package com.trungtamjava.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.trungtamjava.dao.UserDAO;
import com.trungtamjava.model.User;

@Repository
public class UserDaoImpl implements UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void addUser(User user) {
		String sql = "INSERT INTO USER (TEN_KH, SO_DT) VALUES(?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getPhone());
	}

	public void updateUser(User user) {
		String sql = "UPDATE  USER SET TEN_KH = ? and SO_DT = ? where id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getPhone(), user.getId());

	}

	public void deleteUser(int id) {
		String sql = "Delete From USER where id = ?";
		jdbcTemplate.update(sql,id);
	}

	@SuppressWarnings("deprecation")
	public User getUserById(int id) {
		String sql = "SELECT * FROM USER WHERE ID = ? ";
		return jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("TEN_KH"));
				user.setPhone(rs.getString("SO_DT"));
				return user;
			}

		});
	}

	@SuppressWarnings("deprecation")
	public List<User> getAllUser() {
		String sql = "SELECT * FROM USER ";
		return jdbcTemplate.query(sql, new Object[] { }, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("TEN_KH"));
				user.setPhone(rs.getString("SO_DT"));
				return user;
			}

		});
	}

}
