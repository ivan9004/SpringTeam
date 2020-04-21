package com.jackrutorial.service;

import java.util.List;

import com.jackrutorial.model.Compra;

public interface CompraService {
	public List listAllCompras();

	public void addCompra(Compra compra);

	public Compra findCompra(int idCompra);

}
