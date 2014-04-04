package com.vinod.docsch.service;

import java.util.List;

import com.vinod.docsch.view.bean.UserDataBean;
import com.vinod.docsch.view.bean.vo.Role;

public interface UserService {
	public UserDataBean createUser(UserDataBean user);
	public String resetPassword(UserDataBean user);
	public Role createRole(Role role) throws Exception;
	public List<Role> loadAllRoles();
}
