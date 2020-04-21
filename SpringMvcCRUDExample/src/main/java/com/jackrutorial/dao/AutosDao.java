package com.jackrutorial.dao;

import java.util.List;

import com.jackrutorial.model.Autos;

public interface AutosDao {
	
	public List listAllAutos();
	
	public void addAutos(Autos autos);
	
	public void updateAuto(Autos autos);
	
	public void deleteAutos(int id);
	
	public Autos findAuto(int id);
	

}
