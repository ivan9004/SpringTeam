package com.jackrutorial.model;

public class Autos {

	private int idAuto;
	private double precio;
	private String nombreAuto;
	private String modelo;
	private int puertas;

	

	public int getIdAuto() {
		return idAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombreAuto() {
		return nombreAuto;
	}

	public void setNombreAuto(String nombreAuto) {
		this.nombreAuto = nombreAuto;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public Autos() {
		super();
	}

	public Autos(int idAuto) {
		super();
		this.idAuto = idAuto;
	}

	

}
