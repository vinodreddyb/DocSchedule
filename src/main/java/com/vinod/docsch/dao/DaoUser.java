package com.vinod.docsch.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.vinod.docsch.db.entity.Stock;
import com.vinod.docsch.db.entity.TblRole;
import com.vinod.docsch.db.entity.TblUser;

public interface DaoUser {

	public TblUser createUser(TblUser user);
	public void deleteUser(String userId);
	public TblUser updateUser(TblUser user);
	public List<TblRole> loadAllRoles();
	public TblRole createRole(TblRole role) throws DataAccessException;
	public void createStock(Stock stock);
}
