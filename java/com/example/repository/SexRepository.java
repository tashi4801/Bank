package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Sex;
@Repository
public class SexRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String TABLE_NAME = " sex "; 
	
	private static final RowMapper<Sex> userRowMapper = (rs, i) -> {
		String sex_id = rs.getString("sex_id");
		String sex = rs.getString("sex");
		return new Sex(sex_id,sex);
	};
	public List<Sex> findAll() {
		String sql = "select sex_id,sex  from"+TABLE_NAME;
		SqlParameterSource param = new MapSqlParameterSource();
		List<Sex> Sex = jdbcTemplate.query(sql,param,userRowMapper);
		return Sex;
	}
}
