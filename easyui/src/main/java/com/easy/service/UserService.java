package com.easy.service;

import java.util.List;

import com.easy.pojos.PagerBean;
import com.easy.vo.User;

public interface UserService {

	
	public User getUser(Long id);
	public User saveUser(User user);
	public PagerBean getpagerUser(PagerBean pager);
	
	public User findByName(String username);
	
	public List<User> getAllUser();
	
	public User login(String name,String pwd);

}
