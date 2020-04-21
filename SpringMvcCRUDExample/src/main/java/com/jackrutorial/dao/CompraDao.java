package com.jackrutorial.dao;

import java.util.List;

import com.jackrutorial.model.Compra;

public interface CompraDao {

	public List listAllCompras();

	public void addCompra(Compra compra);

	public Compra findCompra(int idCompra);
	

}
