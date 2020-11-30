package com.health.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.domain.security.UserRole;
import com.health.repository.UserRoleRepositary;
import com.health.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	private UserRoleRepositary usrRoleRepo;
	
	@Override
	public void save(UserRole usrRole) {
		// TODO Auto-generated method stub
		usrRoleRepo.save(usrRole);
	}

}
