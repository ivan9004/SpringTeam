package com.jackrutoria.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;

import com.jackrutorial.dao.AutosDaoImpl;

public class Test {
	
	public static void main(String[] args) {
		
		String jdbcUrl="jdbc:mysql://localhost:3306/usuarios?useSSL=false";
		String usuario="root";
		String contra="";
		
		try {
			System.out.println("Intentando conectar " +  jdbcUrl);
			Connection miConexion = DriverManager.getConnection(jdbcUrl, usuario, contra);
			
			
			System.out.println("Conexion exitosa");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
