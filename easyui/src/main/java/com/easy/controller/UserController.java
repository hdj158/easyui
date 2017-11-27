package com.easy.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easy.pojos.PagerBean;
import com.easy.service.UserService;
import com.easy.vo.User;

@Controller
@RequestMapping("/User")
public class UserController {
	@Resource
	private UserService userServiceImpl;
	
	
	
	@RequestMapping(value="/login")
	public String getUserloginMedthod(User user) {
		
		System.out.println(user);
		userServiceImpl.saveUser(user);
		
		return "jsp/userlist";	
	}
	@RequestMapping(value="/page",method=RequestMethod.GET,produces= {"application/json;charset=utf-8"})
	public @ResponseBody PagerBean getUserpageMedthod(String name,String pwd,int page,int rows) {
		
		Map params = new HashMap();
		name=(name==null)?"":name;
		pwd=(pwd==null)?"":pwd;
		params.put("name", name);
		params.put("pwd", pwd);
		PagerBean pager = new PagerBean(page, rows, params);
		try {
			pager=userServiceImpl.getpagerUser(pager);
			System.out.println(pager);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pager;	
	}
}
