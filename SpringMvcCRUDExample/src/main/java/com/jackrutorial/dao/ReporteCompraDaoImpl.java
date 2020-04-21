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

import com.jackrutorial.model.ReportCompra;

@Repository
public class ReporteCompraDaoImpl implements ReporteCompraDao{

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

	private SqlParameterSource getSqlParameterByModel(ReportCompra report) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (report != null) {

			parameterSource.addValue("nombre", report.getNombre());
			parameterSource.addValue("apellidos", report.getApellidos());
			parameterSource.addValue("direccion", report.getDireccion());
			parameterSource.addValue("email", report.getEmail());
			parameterSource.addValue("paInicial", report.getPaInicial());
			parameterSource.addValue("rest", report.getRest());
		}
		return parameterSource;
	}

	public static final class CompraMapper implements RowMapper<ReportCompra> {
		@Override
		public ReportCompra mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReportCompra report = new ReportCompra();
			report.setNombre(rs.getString("nombre"));
			report.setApellidos(rs.getString("apellidos"));
			report.setDireccion(rs.getString("direccion"));
			report.setEmail(rs.getString("email"));
			report.setPaInicial(rs.getDouble("paInicial"));
			report.setRest(rs.getDouble("rest"));
			return report;

		}
	}

	@Override
	public List listCombinado() {
		ReporteCompraDaoImpl reporteProp = new ReporteCompraDaoImpl();

		String sql = reporteProp.loadProperties().getProperty("buscaCombinada");
		List list = jdbc.query(sql, getSqlParameterByModel(null), new CompraMapper());
		return list;

	}

}
