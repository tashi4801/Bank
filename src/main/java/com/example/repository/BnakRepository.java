package com.example.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.Bank;

@Repository
public class BnakRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String tabeleName = " bank "; 

	private static final RowMapper<Bank> userRowMapper = (rs, i) -> {
		Integer id = rs.getInt("id");
		Date date =rs.getDate("date");
		Integer userid = rs.getInt("userid");
		Integer revenue = rs.getInt("revenue");
		Integer spending = rs.getInt("spending");
		Integer stock = rs.getInt("stock");
		String memo = rs.getString("memo");
		return new Bank(id,date ,userid, revenue,spending,stock,memo);
	};
	public Bank findById() {
		String sql = 	"select id,name,password from" + tabeleName+"WHERE id = (SELECT MAX(id) FROM"+tabeleName+")";
		SqlParameterSource param = new MapSqlParameterSource();
		return jdbcTemplate.queryForObject(sql, param, userRowMapper);
	}
	public List<Bank> findAll(Integer userid) {
		String sql = "select id,date,userid,revenue,spending,stock,memo from"+tabeleName + "where userid = :userid";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userid", userid);
		List<Bank> bankList = jdbcTemplate.query(sql,param,userRowMapper);
		return bankList;
	}
	public Bank created(Bank bank){
		System.out.println("bankrepositoryには入ったよね");
		SqlParameterSource param = new BeanPropertySqlParameterSource(bank);
		String sql = "INSERT INTO"+tabeleName + "(date,userid,revenue,spending,stock,memo)values(:date,:userid,:revenue,:spending,:stock,:memo)";
		jdbcTemplate.update(sql, param);
		return bank;
	}
}
