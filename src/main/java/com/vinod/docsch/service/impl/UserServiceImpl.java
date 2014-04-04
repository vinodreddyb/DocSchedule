package com.vinod.docsch.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.dao.DataAccessException;

import com.vinod.docsch.dao.DaoUser;
import com.vinod.docsch.db.entity.TblRole;
import com.vinod.docsch.db.entity.TblUser;
import com.vinod.docsch.service.UserService;
import com.vinod.docsch.view.bean.UserDataBean;
import com.vinod.docsch.view.bean.vo.Role;

@Named(value="userService")
public class UserServiceImpl implements UserService{

	@Inject
	private DaoUser daoUser;
	
	
	@Override
	public UserDataBean createUser(UserDataBean user) {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		TblUser tbluser = new TblUser();
		tbluser.setName(user.getName());
		tbluser.setAge(user.getAge());
		tbluser.setMobile(user.getMobile());
		tbluser.setSex(user.getSex());
		tbluser.setPhone(user.getPhone());
		tbluser.setUserName(user.getLoginName());
		tbluser.setPassword(user.getLoginPassword());
		tbluser.setAddress(user.getAddress());
		
		
		TblRole role = new TblRole();
		role.setRoleName("ROLE_USER");
		tbluser.setTblUserRole(role);
		tbluser.setIsActive((short) 1);
		daoUser.createUser(tbluser);
		
		return null;
	}
	
	

	@Override
	public String resetPassword(UserDataBean user) {
		
		return null;
	}



	@Override
	public List<Role> loadAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		List<TblRole> list = daoUser.loadAllRoles();
		for(TblRole role : list) {
			roles.add(new Role(role.getRoleId(), role.getRoleName()));
		}
		return roles;
	}



	@Override
	public Role createRole(Role role) throws Exception{
		TblRole tblRole = new TblRole();
		tblRole.setRoleName(role.getRoleName());
		try {
			daoUser.createRole(tblRole);
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	
}
