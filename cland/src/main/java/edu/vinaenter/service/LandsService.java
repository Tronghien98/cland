package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.LandDAO;
import edu.vinaenter.models.Lands;

@Service
public class LandsService implements ICRUDService<Lands> {

	@Autowired
	private LandDAO landDAO;
	
	@Override
	public List<Lands> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Lands t, int id) {
		// TODO Auto-generated method stub
		return landDAO.update(t, id);
	}

	@Override
	public int save(Lands t) {
		return landDAO.save(t);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return landDAO.del(id);
	}

	@Override
	public Lands findOne(Lands t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lands findById(int id) {
		// TODO Auto-generated method stub
		return landDAO.findById(id);
	}

	@Override
	public List<Lands> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return landDAO.getAll(offset, rowCount);
	}
	
	public int getRow() {
		return landDAO.getRow();
	}
	
	public List<Lands> getMostView(int rowCount) {
		return landDAO.getMostView(rowCount);
	}

	public List<Lands> findAll(String searchLand, int offset, int adminTotalRow) {
		
		return landDAO.findAll(searchLand, offset, adminTotalRow);
	}

	public int getRowSearch(String content) {
		
		return landDAO.getRowSearch(content);
	}

	public List<Lands> findAllByCatId(int cid, int offset, int clandTotalRow) {
		
		return landDAO.findAllByCatId(cid, offset, clandTotalRow);
	}

	public int getRowCat(int cid) {
		return landDAO.getRowCat(cid);
	}
	
	public int getRowHotCat(int cid, String preDate, String posDate) {
		return landDAO.getRowHotCat(cid, preDate, posDate);
	}
	
	public Lands getNewLand() {
		return landDAO.getNewLand();
	}

	public List<Lands> findAllByHotCatId(int cid, String preDate, String posDate, int offset, int clandTotalRow) {
		// TODO Auto-generated method stub
		return landDAO.findAllByHotCatId(cid, preDate, posDate, offset, clandTotalRow);
	}
	
}
