package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.models.Users;

@Service
public class UserService implements ICRUDService<Users> {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public List<Users> getAll() {
		return userDAO.getAll();
	}

	@Override
	public int update(Users user, int id) {
		// TODO Auto-generated method stub
		return userDAO.update(user, id);
	}

	@Override
	public int save(Users t) {
		// TODO Auto-generated method stub
		return userDAO.save(t);
	}

	@Override
	public int del(int id) {
		// TODO Auto-generated method stub
		return userDAO.del(id);
	}

	@Override
	public Users findOne(Users t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users findById(int id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public List<Users> getAll(int offset, int rowCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return userDAO.getRow();
	}

	public Users findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.findByUsername(username);
	}

	
	
}
