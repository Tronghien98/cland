package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Categories;
import edu.vinaenter.models.Vnecontact;

@Repository
public class VneContactDAO extends AbstractDAO<Vnecontact> {
	@Override
	public List<Vnecontact> getAll() {
		String sql = "SELECT * FROM vnecontact ORDER BY cid DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vnecontact.class));
	}
	@Override
	public int del(int id) {
			String sql = "DELETE FROM vnecontact WHERE cid = ?";
		return jdbcTemplate.update(sql, id);
	}
	@Override
	public Vnecontact findById(int id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
	@Override
	public Categories findOne(Vnecontact t) {
		// TODO Auto-generated method stub
		return super.findOne(t);
	}
	@Override
	public int save(Vnecontact t) {
		String sql = "INSERT INTO vnecontact(fullname, email, subject, content) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql, t.getFullname(), t.getEmail(), t.getSubject(), t.getContent());
	}
	@Override
	public int update(Vnecontact t, int id) {
		// TODO Auto-generated method stub
		return super.update(t, id);
	}
	@Override
	public List<Vnecontact> getAll(int offset, int rowCount) {
		String sql = "SELECT * FROM vnecontact ORDER BY cid DESC LIMIT ?,?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vnecontact.class), offset, rowCount);
	}
	
	public int getRow() {
		String sql = "SELECT COUNT(*) FROM vnecontact";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	public List<Vnecontact> findAll(String searchContact, int offset, int adminTotalRow) {
		String sql = "SELECT c.* from vnecontact AS c "
				+ "WHERE c.fullname LIKE '%' ? '%' "
				+ "OR c.email LIKE '%' ? '%' "
				+ "OR c.content LIKE '%' ? '%' ORDER BY c.cid LIMIT ? , ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Vnecontact>>() {
			List<Vnecontact> list = new ArrayList<Vnecontact>();
			@Override
			public List<Vnecontact> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					list.add(new Vnecontact(rs.getInt("cid"), rs.getString("fullname"), 
							rs.getString("email"), rs.getString("subject"), rs.getString("content")));
				}
				return list;
			}
		},searchContact, searchContact, searchContact, offset, adminTotalRow);
	}
	public int getRowSearch(String searchContact) {
		String sql = "SELECT count(*) FROM vnecontact AS c WHERE c.fullname LIKE '%' ? '%' "
				+ "OR c.email LIKE '%' ? '%' "
				+ "OR c.content LIKE '%' ? '%' ";
		return jdbcTemplate.queryForObject(sql, Integer.class, searchContact, searchContact, searchContact);
	}
}
