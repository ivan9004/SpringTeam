package com.jackrutorial.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.jackrutorial.model.Compra;

@Repository
public class CompraDaoImpl implements CompraDao{
	
	NamedParameterJdbcTemplate jdbc;
	
	
	
	@Autowired
	public void setJdbc(NamedParameterJdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

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

	@Override
	public List listAllCompras() {
		CompraDaoImpl compraProp = new CompraDaoImpl();
		String sql = compraProp.loadProperties().getProperty("verCompra");
		List list = jdbc.query(sql, getSqlParameterByModel(null), new CompraMapper());
		
		return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(Compra compra) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (compra != null) {
			parameterSource.addValue("idCompra", compra.getIdCompra());
			parameterSource.addValue("id", compra.getId());
			parameterSource.addValue("idAuto", compra.getIdAuto());
			parameterSource.addValue("paInicial", compra.getPaInicial());
			parameterSource.addValue("rest", compra.getRest());
			parameterSource.addValue("fecha", compra.getFecha());
		}
		return parameterSource;
	}
	
	public static final class CompraMapper implements RowMapper<Compra>{

		@Override
		public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
			Compra compra = new Compra();
			compra.setIdCompra(rs.getInt("idCompra"));
			compra.setId(rs.getInt("id"));
			compra.setIdAuto(rs.getInt("idAuto"));
			compra.setPaInicial(rs.getDouble("paInicial"));
			compra.setRest(rs.getDouble("rest"));
			compra.setFecha(rs.getString("fecha"));
			return compra;
		}
		
	}

	@Override
	public void addCompra(Compra compra) {
		CompraDaoImpl compraProp = new CompraDaoImpl();
		String sql = compraProp.loadProperties().getProperty("insertarCompra");
		jdbc.update(sql, getSqlParameterByModel(compra));
	}

	@Override
	public Compra findCompra(int id) {
		CompraDaoImpl compraProp = new CompraDaoImpl();
		String sql = compraProp.loadProperties().getProperty("buscarCompra");		
		return jdbc.queryForObject(sql, getSqlParameterByModel(new Compra(id)), new CompraMapper());
	}

	

}
