package com.jackrutorial.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReportCompra {
	
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private double paInicial;
	private double rest;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public ReportCompra() {
		super();
	}
	
}
