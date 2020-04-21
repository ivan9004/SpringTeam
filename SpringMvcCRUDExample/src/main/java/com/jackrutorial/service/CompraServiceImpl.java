package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.CompraDao;
import com.jackrutorial.model.Compra;

@Service
public class CompraServiceImpl implements CompraService{
	
	CompraDao compraDao;
	
	
	@Autowired
	public void setCompraDao(CompraDao compraDao) {
		this.compraDao = compraDao;
	}

	@Override
	public List listAllCompras() {
		return compraDao.listAllCompras();
	}

	@Override
	public void addCompra(Compra compra) {
		compraDao.addCompra(compra);
	}

	@Override
	public Compra findCompra(int idCompra) {
		return compraDao.findCompra(idCompra);
	}

}
