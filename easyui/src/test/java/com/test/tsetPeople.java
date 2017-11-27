package com.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.easy.pojos.PagerBean;
import com.easy.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class tsetPeople {

	@Resource
	private UserService userServiceImpl;
	@Test
	public void testpager() {
		// TODO Auto-generated method stub
		PagerBean pager=new PagerBean();
		pager.setPage(1);
		pager.setNums(3);
		Map m=new HashMap();
		m.put("name", "8");
		m.put("pwd", "");
		pager.setParams(m);
		PagerBean b=userServiceImpl.getpagerUser(pager);
		System.out.println(b);
		
	}
}
