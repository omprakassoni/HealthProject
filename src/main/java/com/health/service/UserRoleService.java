package com.health.service;

import java.util.List;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Language;
import com.health.model.User;

public interface UserRoleService {

	void save(UserRole usrRole);
	
	List<UserRole> findAllByUser(User usr);
	
	long getNewUsrRoletId();
	
	UserRole findByLanCatUser(Language lan,Category cat,User usr,Role role);
	
	UserRole findByLanUser(Language lan,User usr,Role role);
	
	UserRole findByRoleUser(User usr,Role role);
	
	List<UserRole> findAllByRole(Role role);
}
