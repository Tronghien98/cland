package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.VneContactDAO;
import edu.vinaenter.models.Vnecontact;

@Service
public class VnecontactService implements ICRUDService<Vnecontact> {
	@Autowired
	private VneContactDAO vnecontactDAO;
	
	@Override
	public List<Vnecontact> getAll() {
		// TODO Auto-generated method stub
		return vnecontactDAO.getAll();
	}

	@Override
	public int update(Vnecontact t, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Vnecontact t) {
		// TODO Auto-generated method stub
		return vnecontactDAO.save(t);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return vnecontactDAO.del(id);
	}

	@Override
	public Vnecontact findOne(Vnecontact t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vnecontact findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vnecontact> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return vnecontactDAO.getAll(offset, rowCount);
	}
	
	public int getRow() {
		return vnecontactDAO.getRow();
	}

	public List<Vnecontact> findAll(String searchContact, int offset, int adminTotalRow) {
		// TODO Auto-generated method stub
		return vnecontactDAO.findAll(searchContact, offset, adminTotalRow);
	}

	public int getRowSearch(String searchContact) {
		// TODO Auto-generated method stub
		return vnecontactDAO.getRowSearch(searchContact);
	}

}
