package com.an.daoimpl;


import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.an.dao.PersonDao;
import com.an.utils.Person;

public abstract class PersonDaoImpl implements PersonDao{

	@Override
	public int save(JdbcTemplate jt, Person person) {
		String sql="insert into login (id,pass)value(?,?);";
		return jt.update(sql,person.getId(),person.getPass());
	}

	@Override
	public int update(JdbcTemplate jt, Person person) {
		String sql="update login set pass=? where pk=?;";
		return jt.update(sql,person.getPass(),person.getPk());
	}

	@Override
	public int delete(JdbcTemplate jt, int pk) {
		String sql="delete from login where pk=?;";
		return jt.update(sql,pk);
	}

	@Override
	public Person getByPk(JdbcTemplate jt, int pk) {
		String sql="select id,pass from login where pk=?";
		RowMapper<Person> rowMap=new BeanPropertyRowMapper<>(Person.class);
		Person pn;
		try {
			pn=jt.queryForObject(sql, rowMap,pk);
		} catch (Exception e) {
			return null;
		}	
		return pn;
	}


}
