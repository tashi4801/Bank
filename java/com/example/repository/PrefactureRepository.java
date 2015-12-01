package com.example.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Prefacture;

@Repository
public class PrefactureRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String TABLE_NAME = " prefectures "; 
	
	private static final RowMapper<Prefacture> userRowMapper = (rs, i) -> {
		String pref_id = rs.getString("pref_id");
		String pref_name = rs.getString("pref_name");
		return new Prefacture(pref_id,pref_name);
	};
	public List<Prefacture> findAll() {
		String sql = "select pref_id,pref_name  from"+TABLE_NAME;
		SqlParameterSource param = new MapSqlParameterSource();
		List<Prefacture> Prefactures = jdbcTemplate.query(sql,param,userRowMapper);
		return Prefactures;
	}
}
