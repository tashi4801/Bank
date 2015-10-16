package com.example.repository;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
@Transactional
public class UserRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	private final String tabeleName = " member "; 
	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		String name = rs.getString("name");
		String password = rs.getString("password");
		return new User(id, name, password);
	};

	public User findOne(int id) {
		String sql = "select id,name,password from"+tabeleName + "WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return jdbcTemplate.queryForObject(sql, param, userRowMapper);
	}
	public User findById() {
		String sql = 	"select id,name,password from" + tabeleName+"WHERE id = (SELECT MAX(id) FROM"+tabeleName+")";
		SqlParameterSource param = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(sql, param, userRowMapper);
	}

	public List<User> findAll() {
		String sql = "select id,name,password from  "+tabeleName + "  ORDER BY id";
		List<User> userList = jdbcTemplate.query(sql, userRowMapper);
		return userList;
	}
	
	public User save(User user){
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "INSERT INTO"+tabeleName + "(name,password)values(:name,:password)";
		jdbcTemplate.update(sql, param);
		return user;
	}
}