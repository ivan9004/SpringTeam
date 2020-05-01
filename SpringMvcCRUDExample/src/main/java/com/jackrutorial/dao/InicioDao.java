package com.jackrutorial.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jackrutorial.model.UserInfo;

@Repository
@Transactional
public class InicioDao {
	
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

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
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	private SqlParameterSource getSqlParameterByModel(UserInfo user) {
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		if (user != null) {
			parameterSource.addValue("id", user.getId());
			parameterSource.addValue("username", user.getUsername());
			parameterSource.addValue("nombre", user.getNombre());
			parameterSource.addValue("apellidos", user.getApellidos());
			parameterSource.addValue("email", user.getEmail());
			parameterSource.addValue("password", user.getPassword());
			parameterSource.addValue("direccion", user.getDireccion());
			parameterSource.addValue("telefono", user.getTelefono());
			parameterSource.addValue("edad", user.getEdad());
			parameterSource.addValue("role", user.getRole());
		}
		return parameterSource;
	}

	private static final class UserMapper implements RowMapper<UserInfo> {

		public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserInfo user = new UserInfo();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setNombre(rs.getString("Nombre"));
			user.setApellidos(rs.getString("apellidos"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setDireccion(rs.getString("direccion"));
			user.setTelefono(rs.getString("telefono"));
			user.setEdad(rs.getInt("edad"));
			user.setRole(rs.getString("role"));

			return user;
		}

	}
	
	public UserInfo getActiveUser(String username) {
		
		UserDaoImpl usuarioProp = new UserDaoImpl();

		String sql = usuarioProp.loadProperties().getProperty("inicioS");
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new UserInfo(username)), new UserMapper());
	}

}
