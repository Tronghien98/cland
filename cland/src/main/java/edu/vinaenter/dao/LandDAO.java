package edu.vinaenter.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import edu.vinaenter.models.Categories;
import edu.vinaenter.models.Lands;

@Repository
public class LandDAO extends AbstractDAO<Lands> {
	
	@Override
	public List<Lands> getAll(int offset, int rowCount) {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate,"
				+ " l.cid, cname, picture, area, address, count_views AS countView "
				+ "FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY lid DESC"
				+ " LIMIT ?,?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> listLand = new ArrayList<Lands>();
			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					
					listLand.add(new Lands(rs.getInt("lid"), rs.getString("lname"), 
							rs.getString("description"), rs.getString("detail"), rs.getTimestamp("dateCreate"), 
							rs.getTimestamp("dateUpdate"), new Categories(rs.getInt("cid"), rs.getString("cname")), 
							rs.getString("picture"), rs.getInt("area"), 
							rs.getString("address"), rs.getInt("countView")));
				}
				return listLand;
			}
		}, offset, rowCount);
	}
	
	@Override
	public int save(Lands t) {
		String sql = "INSERT INTO lands(lname, description, detail, cid, picture, area, address) VALUE(?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, t.getLname(), t.getDescription(), t.getDetail(), t.getCat().getCid(),t.getPicture(), t.getArea(), t.getAddress());
	}
	
	@Override
	public int del(int id) {
		String sql = "DELETE FROM lands WHERE lid = ?";
		return jdbcTemplate.update(sql, id);
	}
	
	@Override
	public Lands findById(int id) {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate,"
				+ " l.cid, cname, picture, area, address, count_views AS countView"
				+ " FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE lid = ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Lands>() {
			Lands land;
			@Override
			public Lands extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					land = new Lands(rs.getInt("lid"), rs.getString("lname"),
							rs.getString("description"), rs.getString("detail"),
							rs.getTimestamp("dateCreate"), rs.getTimestamp("dateUpdate") , 
							new Categories(rs.getInt("cid"), rs.getString("cname")),
							rs.getString("picture"), rs.getInt("area"), rs.getString("address"),
							rs.getInt("countView"));
				}
				return land;
			}
		}, id);
	}
	
	@Override
	public int update(Lands t, int id) {
		String sql = "UPDATE lands SET lname = ?, description = ?, detail=?, date_Update = ?, "
				+ "cid = ?, picture = ?, area = ? WHERE lid = ?";
		return jdbcTemplate.update(sql, t.getLname(), t.getDescription(), t.getDetail(),
				t.getDateUpdate(), t.getCat().getCid(),
				t.getPicture(), t.getArea(), id);
	}
	
	public int getRow() {
		String sql = "SELECT COUNT(*) FROM lands AS l INNER JOIN categories AS c WHERE l.cid = c.cid";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public List<Lands> getMostView(int rowCount) {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate,"
				+ " l.cid, cname, picture, area, address, count_views AS countView"
				+ "	 FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY l.count_views DESC LIMIT ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> listLand = new ArrayList<Lands>();
			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					listLand.add(new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), 
							rs.getString("detail"), rs.getTimestamp("dateCreate"), rs.getTimestamp("dateUpdate"), 
							new Categories(rs.getInt("cid"), rs.getString("cname")), 
							rs.getString("picture"), rs.getInt("area"), 
							rs.getString("address"), rs.getInt("countView")));
				}
				return listLand;
			}
		}, rowCount);
	}

	public List<Lands> findAll(String content, int offset, int adminTotalRow) {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate, "
				+ "l.cid, cname, picture, area, address, count_views AS countView FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.cid = c.cid WHERE l.lname LIKE '%' ? '%' "
				+ "OR l.description LIKE '%' ? '%' OR l.detail LIKE '%' ? '%' ORDER BY l.lid DESC LIMIT ?, ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> listLand = new ArrayList<Lands>();
			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					listLand.add(new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), 
							rs.getString("detail"), rs.getTimestamp("dateCreate"), rs.getTimestamp("dateUpdate"), 
							new Categories(rs.getInt("cid"), rs.getString("cname")), 
							rs.getString("picture"), rs.getInt("area"), 
							rs.getString("address"), rs.getInt("countView")));
				}
				return listLand;
			}
		}, content, content, content, offset, adminTotalRow);
	}

	public int getRowSearch(String content) {
		String sql = "SELECT COUNT(*) FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.cid = c.cid"
				+ " WHERE l.lname LIKE '%' ? '%' OR l.description LIKE '%' ? '%' OR l.detail LIKE '%' ? '%'";
		return jdbcTemplate.queryForObject(sql, Integer.class, content, content, content);
	}

	public List<Lands> findAllByCatId(int cid, int offset, int clandTotalRow) {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate, "
				+ "l.cid, cname, picture, area, address, count_views AS countView FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.cid = c.cid WHERE c.cid = ? ORDER BY l.lid DESC LIMIT ?, ?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> listLand = new ArrayList<Lands>();
			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					listLand.add(new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), 
							rs.getString("detail"), rs.getTimestamp("dateCreate"), rs.getTimestamp("dateUpdate"), 
							new Categories(rs.getInt("cid"), rs.getString("cname")), 
							rs.getString("picture"), rs.getInt("area"), 
							rs.getString("address"), rs.getInt("countView")));
				}
				return listLand;
			}
		}, cid, offset, clandTotalRow);
	}
	
	public int getRowCat(int cid) {
		String sql = "SELECT COUNT(*) FROM lands AS l INNER JOIN categories AS c WHERE l.cid = c.cid AND c.cid = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, cid);
	}
	
	public int getRowHotCat(int cid, String preDate, String posDate) {
		String sql = "SELECT COUNT(*) FROM lands AS l INNER JOIN categories AS c WHERE l.cid = c.cid AND c.cid = ? "
				+ "AND l.date_create BETWEEN ? AND ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, cid, preDate, posDate);
	}
	
	public Lands getNewLand() {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate, "
				+ "l.cid, cname, picture, area, address, count_views AS countView FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.cid = c.cid  ORDER BY l.lid DESC LIMIT 1";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Lands>() {
			Lands land;
			@Override
			public Lands extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					land = new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), 
							rs.getString("detail"), rs.getTimestamp("dateCreate"), rs.getTimestamp("dateUpdate"), 
							new Categories(rs.getInt("cid"), rs.getString("cname")), 
							rs.getString("picture"), rs.getInt("area"), 
							rs.getString("address"), rs.getInt("countView"));
				}
				return land;
			}
		});
	}

	public List<Lands> findAllByHotCatId(int cid, String preDate, String posDate, int offset, int clandTotalRow) {
		String sql = "SELECT lid, lname, description, detail, date_create AS dateCreate, date_update AS dateUpdate, "
				+ "l.cid, cname, picture, area, address, count_views AS countView FROM lands AS l "
				+ "INNER JOIN categories AS c ON l.cid = c.cid WHERE l.cid = ? AND l.date_create BETWEEN ? AND ? "
				+ "ORDER BY l.lid DESC LIMIT ?,?";
		return jdbcTemplate.query(sql, new ResultSetExtractor<List<Lands>>() {
			List<Lands> list = new ArrayList<Lands>();
			@Override
			public List<Lands> extractData(ResultSet rs) throws SQLException, DataAccessException {
				while (rs.next()) {
					list.add(new Lands(rs.getInt("lid"), rs.getString("lname"), rs.getString("description"), 
							rs.getString("detail"), rs.getTimestamp("dateCreate"), rs.getTimestamp("dateUpdate"), 
							new Categories(rs.getInt("cid"), rs.getString("cname")), 
							rs.getString("picture"), rs.getInt("area"), 
							rs.getString("address"), rs.getInt("countView")));
				}
				return list;
			}
		}, cid, preDate, posDate, offset, clandTotalRow);
	}
}
