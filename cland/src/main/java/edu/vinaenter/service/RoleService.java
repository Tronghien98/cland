package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.RoleDAO;
import edu.vinaenter.models.Role;
@Service
public class RoleService implements ICRUDService<Role> {
	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public List<Role> getAll() {
		
		return roleDAO.getAll();
	}

	@Override
	public int update(Role t, int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Role t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Role findOne(Role t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return 0;
	}

}
