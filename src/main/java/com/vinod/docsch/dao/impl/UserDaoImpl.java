package com.vinod.docsch.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vinod.docsch.dao.DaoUser;
import com.vinod.docsch.db.entity.Stock;
import com.vinod.docsch.db.entity.TblRole;
import com.vinod.docsch.db.entity.TblUser;

@Repository("daoUser")
public class UserDaoImpl extends CustomHibernateDaoSupport implements DaoUser{

	/*@Autowired
	private SessionFactory sessionFactory;*/
	
	@Override
	@Transactional
	public TblUser createUser(TblUser user) {
		System.out.println(getHibernateTemplate().getSessionFactory());
		getHibernateTemplate().save(user);
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TblUser updateUser(TblUser user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<TblRole> loadAllRoles() {
		List<TblRole> roles = null;
		roles = getHibernateTemplate().loadAll(TblRole.class);
		return roles;
	}

	@Override
	public void createStock(Stock stock) {
		
		getHibernateTemplate().save(stock);
	}

	@Override
	@Transactional
	public TblRole createRole(TblRole role) throws DataAccessException{
		try {
			getHibernateTemplate().save(role);
		} catch (DataAccessException e) {
			throw e;
		}
		return role;
	}

	
	
}
