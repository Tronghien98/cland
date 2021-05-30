package edu.vinaenter.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Role;

@Repository
public class RoleDAO extends AbstractDAO<Role> {
	
	@Override
	public List<Role> getAll() {
		String sql = "SELECT * FROM roles";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Role.class));
	}
	
	
}
