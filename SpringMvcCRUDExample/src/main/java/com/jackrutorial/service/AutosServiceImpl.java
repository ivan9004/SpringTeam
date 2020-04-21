package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.AutosDao;
import com.jackrutorial.model.Autos;

@Service
public class AutosServiceImpl implements AutosService{
	
	AutosDao autosDao;
	
	
	@Autowired
	public void setAutosDao(AutosDao autosDao) {
		this.autosDao = autosDao;
	}

	@Override
	public List listAllAutos() {
		return autosDao.listAllAutos();
	}

	@Override
	public void addAutos(Autos autos) {
		autosDao.addAutos(autos);
	}

	@Override
	public void updateAuto(Autos autos) {
		autosDao.updateAuto(autos);
		
	}

	@Override
	public void deleteAutos(int id) {
		autosDao.deleteAutos(id);
		
	}

	@Override
	public Autos findAuto(int id) {
		return autosDao.findAuto(id);
	}

}
