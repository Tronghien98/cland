package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Role;
import edu.vinaenter.models.Users;

@Repository
public class UserDAO extends AbstractDAO<Users> {
	@Override
	public List<Users> getAll() {
		String sql = "SELECT u.*, r.name FROM users AS u INNER JOIN roles AS r ON u.rid = r.id ORDER BY u.id DESC";
		return jdbcTemplate.query(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int arg1) throws SQLException {
				Users users = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						 rs.getString("password"), rs.getBoolean("enable"), new Role(rs.getInt("rid"), rs.getString("name")));
				return users;
			}
		});
	}
	@Override
	public int save(Users t) {
		String sql = "INSERT INTO users(username,fullname, password, rid) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, t.getUsername(), t.getFullname(), t.getPassword() , t.getRole().getId());
	}
	@Override
	public Users findById(int id) {
		String sql = "SELECT u.*, r.name FROM users AS u INNER JOIN roles AS r ON u.rid = r.id WHERE u.id = ?";
		return  jdbcTemplate.queryForObject(sql, new RowMapper<Users>() {
			@Override
			public Users mapRow(ResultSet rs, int args) throws SQLException {
				Users users = new Users(rs.getInt("id"), rs.getString("username"), 
						rs.getString("fullname"),
						 rs.getString("password"), rs.getBoolean("enable"),
						new Role(rs.getInt("rid"), rs.getString("name")));
				return users;
			}
		}, id);
	}
	@Override
	public int update(Users t, int id) {
		String sql = "UPDATE users SET username = ? , fullname = ?, password = ?, rid = ? WHERE id = ?";
		return jdbcTemplate.update(sql, t.getUsername(), t.getFullname(),
				t.getPassword(), t.getRole().getId(), id);
	}
	@Override
	public int del(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public int getRow() {
		String sql = "SELECT COUNT(*) FROM users";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	public Users findByUsername(String username) {
		String sql = "SELECT u.*, r.name FROM users AS u INNER JOIN roles AS r ON u.rid = r.id WHERE u.username = ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Users>() {
			Users user = new Users();
			@Override
			public Users extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					user = new Users(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"), 
							rs.getString("password"), rs.getBoolean("enable"), new Role(rs.getInt("rid"), rs.getString("name")));
				}
				return user;
			}
		}, username);
	}
	
}
