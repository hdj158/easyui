package com.easy.dao;

import java.util.List;

import com.easy.pojos.PagerBean;
import com.easy.vo.User;

public interface UserDao {

	
	public User getUser(Long id);
	
	public void saveUser(User user);
	
	public PagerBean getpagerUser(PagerBean pager);
	
	public User findUniqueResult(String username);
	
	public List<User> find();
	
	public User login(String name,String pwd);
}
