package com.jackrutorial.service;

import java.util.List;

import com.jackrutorial.model.Autos;

public interface AutosService {

	public List listAllAutos();

	public void addAutos(Autos autos);

	public void updateAuto(Autos autos);

	public void deleteAutos(int id);

	public Autos findAuto(int id);

}
