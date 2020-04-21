package com.jackrutorial.model;


public class Compra {

	private int idCompra;
	private int id;
	private int idAuto;
	private double paInicial;
	private double rest;
	private String fecha;

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public double getPaInicial() {
		return paInicial;
	}

	public void setPaInicial(double paInicial) {
		this.paInicial = paInicial;
	}

	public double getRest() {
		return rest;
	}

	public void setRest(double rest) {
		this.rest = rest;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Compra() {
		super();
	}

	public Compra(int id) {
		super();
		this.id = id;
	}

	

}
