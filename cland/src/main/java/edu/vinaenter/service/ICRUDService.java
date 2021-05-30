package edu.vinaenter.service;

import java.util.List;

public interface ICRUDService<T> {
	
	List<T> getAll();
	
	List<T> getAll(int offset, int rowCount);
	
	int update(T t, int id);
	
	int save(T t);
	
	int del(int id);
	
	T findOne(T t);
	
	T findById(int id);
	
	int getRow();
}
