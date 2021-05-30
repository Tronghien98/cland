package edu.vinaenter.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.DTO.CategoryDTO;

@Repository
public class CatDtoDAO{
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public List<CategoryDTO> getTotalPostCat() {
		String sql = "SELECT l.cid, cname, COUNT(*) AS totalPost FROM lands AS l INNER JOIN categories AS c ON c.cid = l.cid GROUP BY l.cid";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CategoryDTO.class));
	}
	
	public List<CategoryDTO> getHotPostCat(String preDate, String posDate) {
		String sql = "SELECT l.cid, cname, COUNT(*) AS totalPost FROM lands AS l "
				+ "INNER JOIN categories AS c ON c.cid = l.cid WHERE l.date_create "
				+ "BETWEEN ? AND ? GROUP BY l.cid";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(CategoryDTO.class), preDate, posDate);
	}
}
