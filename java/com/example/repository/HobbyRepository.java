package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Hobby;

@Repository
public class HobbyRepository {
	@Autowired
	NamedParameterJdbcTemplate JdbcTemplate;

	private final String TABLE_NAME = " hobbys ";

	private static final RowMapper<Hobby> userRowMapper = (rs, i) -> {
		String hob_id = rs.getString("hob_id");
		String hob_name = rs.getString("hob_name");
		return new Hobby(hob_id, hob_name);
	};

	public List<Hobby> findAll() {
		String sql = "select hob_id,hob_name  from" + TABLE_NAME;
		SqlParameterSource param = new MapSqlParameterSource();
		List<Hobby> HobbyList = JdbcTemplate.query(sql, param, userRowMapper);
		return HobbyList;
	}
}
