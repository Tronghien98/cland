package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CatDAO;
import edu.vinaenter.models.Categories;

@Service
public class CatService implements ICRUDService<Categories> {
	@Autowired
	private CatDAO catDAO;
	
	
	@Override
	public List<Categories> getAll() {
		return catDAO.getAll();
	}

	@Override
	public int update(Categories cat, int cid) {
		return catDAO.update(cat, cid);
	}

	@Override
	public int save(Categories cat) {
		return catDAO.save(cat);
	}

	@Override
	public int del(int id) {
		return catDAO.del(id);
	}

	@Override
	public Categories findOne(Categories cat) {
		return catDAO.findOne(cat);
	}

	@Override
	public Categories findById(int id) {
		return catDAO.findById(id);
	}

	@Override
	public List<Categories> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return catDAO.getRow();
	}
	

}
