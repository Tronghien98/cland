package edu.vinaenter.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Categories;

@Repository
public class CatDAO extends AbstractDAO<Categories> {

	@Override
	public List<Categories> getAll() {
		final String sql ="SELECT * FROM categories ORDER BY cid DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Categories>(Categories.class));
	}
	
	@Override
	public int save(Categories cat) {
		String sql = "INSERT INTO categories(cname) VALUES(?)";
		return jdbcTemplate.update(sql, cat.getCname());
	}
	@Override
	public Categories findById(int id) {
		String sql = "SELECT  * FROM categories WHERE cid = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Categories.class), id);
	}
	@Override
	public int del(int id) {
		String sql = "DELETE FROM categories WHERE cid = ?";
		return jdbcTemplate.update(sql, id);
	}
	@Override
	public int update(Categories cat, int cid) {
		String sql = "UPDATE categories SET cname = ? WHERE cid =?";
		return jdbcTemplate.update(sql, cat.getCname(), cid);
	}
	
	@Override
	public int getRow() {
		String sql = "SELECT COUNT(*) AS number FROM categories";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
