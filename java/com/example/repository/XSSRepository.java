package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.example.domain.XSS;

@Repository
public class XSSRepository {
	@Autowired
	NamedParameterJdbcTemplate jdbcTemplate;
	
	private final String tabeleName = " xss "; 

	private static final RowMapper<XSS> userRowMapper = (rs, i) -> {
		Integer id = rs.getInt("xs_id");
		Integer userid = rs.getInt("userid");
		String name = rs.getString("name");
		String xs_text = rs.getString("xs_text");
		return new XSS(id,userid,name, xs_text);
	};
//	public Bank findByALL() {
//		String sql ="select x.xs_id,x.userid,m.name,x.xs_text from xss as x left join member as m on :x.userid=m.id;";
//		SqlParameterSource param = new MapSqlParameterSource();
//		return jdbcTemplate.queryForObject(sql, param, userRowMapper);
//	}
	public List<XSS> findAll() {
		String sql ="select x.xs_id,x.userid,m.name,x.xs_text from xss as x left join member as m on x.userid=m.id;";
		SqlParameterSource param = new MapSqlParameterSource();
		List<XSS> xssList = jdbcTemplate.query(sql,param,userRowMapper);
		System.out.println("xssList="+xssList);
		return xssList;
	}
	public XSS created(XSS xss){
		SqlParameterSource param = new BeanPropertySqlParameterSource(xss);
		String sql = "INSERT INTO"+tabeleName + "(userid,xs_text)values(:userid,:xs_text)";
		jdbcTemplate.update(sql, param);
		return xss;
	}
}
