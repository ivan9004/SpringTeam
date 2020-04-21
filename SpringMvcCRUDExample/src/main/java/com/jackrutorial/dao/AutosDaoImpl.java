package com.jackrutorial.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jackrutorial.model.Autos;

@Repository
public class AutosDaoImpl implements AutosDao{
	
	NamedParameterJdbcTemplate jdbc;
	
	
	public Properties loadProperties() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream("requestSql.properties");
		Properties prop = new Properties();
		try {
			prop.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	
	@Autowired
	public void setJdbc(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}



	@Override
	public List listAllAutos() {
		
		AutosDaoImpl autosProp = new AutosDaoImpl();
		
		String sql = autosProp.loadProperties().getProperty("verAutos");
		
		List list = jdbc.query(sql, getSqlParameterByModel(null), new AutosMapper());
		
		return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(Autos autos) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (autos != null) {
			parameterSource.addValue("idAuto", autos.getIdAuto());
			parameterSource.addValue("precio", autos.getPrecio());
			parameterSource.addValue("nombreAuto", autos.getNombreAuto());
			parameterSource.addValue("modelo", autos.getModelo());
			parameterSource.addValue("puertas", autos.getPuertas());
		}
		return parameterSource;
	}
	
	public static final class AutosMapper implements RowMapper<Autos> {
		
		public Autos mapRow(ResultSet rs, int rowNum) throws SQLException {
			Autos autos = new Autos();
			autos.setIdAuto(rs.getInt("idAuto"));
			autos.setPrecio(rs.getDouble("precio"));
			autos.setNombreAuto(rs.getString("nombreAuto"));
			autos.setModelo(rs.getString("modelo"));
			autos.setPuertas(rs.getInt("puertas"));
			
			return autos;
		}
		
	}

	@Override
	public void addAutos(Autos autos) {
		AutosDaoImpl autosProp = new AutosDaoImpl();
		String sql = autosProp.loadProperties().getProperty("insertarAutos");
		jdbc.update(sql, getSqlParameterByModel(autos));
		
	}

	@Override
	public void updateAuto(Autos autos) {
		AutosDaoImpl autosProp = new AutosDaoImpl();
		String sql = autosProp.loadProperties().getProperty("actualizarAutos");
		jdbc.update(sql, getSqlParameterByModel(autos));
		
	}

	@Override
	public void deleteAutos(int id) {
		AutosDaoImpl autosProp = new AutosDaoImpl();
		String sql = autosProp.loadProperties().getProperty("borrarAuto");
		jdbc.update(sql, getSqlParameterByModel(new Autos(id)));
		
	}

	@Override
	public Autos findAuto(int id) {
		AutosDaoImpl autosProp = new AutosDaoImpl();
		String sql = autosProp.loadProperties().getProperty("buscarAuto");
		
		return jdbc.queryForObject(sql, getSqlParameterByModel(new Autos(id)), new AutosMapper());
	}

}
