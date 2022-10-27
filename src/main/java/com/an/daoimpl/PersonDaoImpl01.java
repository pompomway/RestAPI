package com.an.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.an.utils.Person;
@Component
public class PersonDaoImpl01 extends PersonDaoImpl{

	@Override
	public List<Person> getById(JdbcTemplate jt, String... id) {
		RowMapper<Person> rowMap=new BeanPropertyRowMapper<>(Person.class);
		List<Person> list =new ArrayList<>();
		String sql;
		for (String idd:id) {
			sql="select * from login where id=?;";
			List<Person>getList=jt.query(sql, rowMap,idd);
			getList.forEach(x->list.add(x));
		}
		return list;
	}

	@Override
	public List<Person> getByPass(JdbcTemplate jt, String... pass) {
		RowMapper<Person> rowMap=new BeanPropertyRowMapper<>(Person.class);
		List<Person> list =new ArrayList<>();
		String sql;
		for (String pas:pass) {
			sql="select * from login where pass=?;";
			List<Person>getList=jt.query(sql, rowMap,pas);
			getList.forEach(x->list.add(x));
		}
		return list;
	}

}
