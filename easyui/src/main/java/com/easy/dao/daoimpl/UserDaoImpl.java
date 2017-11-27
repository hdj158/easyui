package com.easy.dao.daoimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.easy.dao.UserDao;
import com.easy.pojos.PagerBean;
import com.easy.utils.BaseDao;
import com.easy.vo.User;
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return (User) getSession().get(User.class, id);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		getSession().save(user);
		
	}

	@Override
	public PagerBean getpagerUser(PagerBean pager) {
		// TODO Auto-generated method stub
		
		String hql1="select count(u.id) From User as u where u.name like CONCAT(:name,'%') and u.pwd like CONCAT(:pwd,'%')";
		Query query = getSession().createQuery(hql1);
		query.setProperties(pager.getParams());
		Long l=(Long) query.uniqueResult();
		pager.setTotal(Integer.valueOf(l+""));
		
		String hql = "From User as u where u.name like CONCAT(:name,'%') and u.pwd like CONCAT(:pwd,'%') order by u.id desc";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(pager.getParams());
		query1.setFirstResult(pager.getIndex());
		query1.setMaxResults(pager.getNums());
		
		
		List<?> date=query1.list();
		pager.setRows(date);
		return pager;
		
		
		
		
	}

	@Override
	public User findUniqueResult(String username) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("name", username);
		String hql = "from User u where u.userName = :name";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(params);
		User u=null;

		if(query1.list().size()!=0) {
			u=(User) query1.list().get(0);
		}
		return u;
	}

	@Override
	public List<User> find() {
		// TODO Auto-generated method stub
		String hql = "from User u";
		Query query1 = getSession().createQuery(hql);
		return query1.list();
	}

	@Override
	public User login(String name, String pwd) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		params.put("name", name);
		params.put("pwd", pwd);
		User u=null;
		String hql = "from User u where u.userName =:name and u.passWord=:pwd";
		Query query1 = getSession().createQuery(hql);
		query1.setProperties(params);
		
		
		System.out.println(query1.list()+"++++++++++++++++++++++++++");
		if(query1.list().size()!=0) {
			u=(User) query1.list().get(0);
		}
		return u;
	}

}
