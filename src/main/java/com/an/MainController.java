package com.an;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.an.dao.PersonDao;

import com.an.utils.Person;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController 
@RequestMapping("/rest")
public class MainController {
	
	@Autowired
	Person pn;
	@Autowired
	JdbcTemplate jt;
	@Autowired
	PersonDao dao;
	
	
	@GetMapping("/test/{pk}")
	public String getTest(@PathVariable("pk") Long pk) {
		System.out.println(pk);
		log.info(null);
		return "index";
	}
	@GetMapping("/login/{pk}")
	public AjaxResponse getPerson(@PathVariable("pk") int pk) {
		try {
			pn=dao.getByPk(jt, pk);
			pn.setPk(pk);
		} catch (Exception e) {
			return AjaxResponse.Notsuccess();
		}
		
		return AjaxResponse.success(pn);
	}
	@PostMapping("/setLogin")
	public AjaxResponse setPerson(@RequestBody Person pn) {
		String message="Save NG";
		try {
			if (dao.save(jt, pn)==1) {
				message="Save OK";
			}
		} catch (Exception e) {
			return AjaxResponse.Notsuccess();
		}
		
		return AjaxResponse.SaveSuccess(message);
	}
	@PutMapping("/upLogin")
	public AjaxResponse upPerson(@RequestBody Person pn) {
		String message="Update NG";
		try {
			if(dao.update(jt, pn)==1) {
				message="Update OK";
			}
		} catch (Exception e) {
			return AjaxResponse.Notsuccess();
		}
		return AjaxResponse.SaveSuccess(message);
	}
	
	@DeleteMapping("/deLogin/{pk}")
	public AjaxResponse dePerson(@PathVariable("pk") int pk) {
		String message="Delete NG";
		try {
			if(dao.delete(jt, pk)==1) {
				message="Delete Ok";
			}
		} catch (Exception e) {
			return AjaxResponse.Notsuccess();
		}
		return AjaxResponse.SaveSuccess(message);
	}
	
}
