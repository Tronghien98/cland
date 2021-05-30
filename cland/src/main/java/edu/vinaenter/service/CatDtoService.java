package edu.vinaenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.vinaenter.dao.CatDtoDAO;
import edu.vinaenter.models.DTO.CategoryDTO;

@Service
public class CatDtoService {
	
	@Autowired
	private CatDtoDAO catDtoDAO;
	
	public List<CategoryDTO> getTotalPostCat() {
		return catDtoDAO.getTotalPostCat();
	}
	
	public List<CategoryDTO> getHotPostCat(String preDate, String posDate) {
		return catDtoDAO.getHotPostCat(preDate, posDate);
	}
}
