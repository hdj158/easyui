package com.easy.service.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.easy.dao.UserDao;
import com.easy.pojos.PagerBean;
import com.easy.service.UserService;
import com.easy.vo.User;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDaoImpl;
	
	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUser(id);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		userDaoImpl.saveUser(user);
		return user;
	}

	@Override
	public PagerBean getpagerUser(PagerBean pager) {
		// TODO Auto-generated method stub
		return userDaoImpl.getpagerUser(pager);
	}

	@Override
	public User findByName(String username) {
		// TODO Auto-generated method stub
		return userDaoImpl.findUniqueResult(username);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDaoImpl.find();
	}

	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		return userDaoImpl.login(name,pwd);
	}

}
