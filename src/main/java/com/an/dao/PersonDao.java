package com.an.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.an.utils.Person;

public interface PersonDao {
	
	int save(JdbcTemplate jt,Person person);
	int update(JdbcTemplate jt,Person person);
	int delete(JdbcTemplate jt,int pk);
	Person getByPk(JdbcTemplate jt,int pk);
	
	List<Person>getById(JdbcTemplate jt,String...id);
	List<Person>getByPass(JdbcTemplate jt,String...pass);
	

}
