package com.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easy.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class testShiro {
	@Resource
	private UserService userServiceImpl;
	
	@Test  
	public void test() {  
	       
		  System.out.println(userServiceImpl.getAllUser());
	}
}
