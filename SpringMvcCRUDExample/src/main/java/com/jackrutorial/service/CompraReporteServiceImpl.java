package com.jackrutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jackrutorial.dao.ReporteCompraDao;

@Service
public class CompraReporteServiceImpl implements ReporteCompraService{

	ReporteCompraDao reporteDao;
	
	@Autowired
	public void setReporteDao(ReporteCompraDao reporteDao) {
		this.reporteDao = reporteDao;
	}

	@Override
	public List listCombinado() {
		
		return reporteDao.listCombinado();
	}
	
	
}
