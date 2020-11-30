package com.health.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.domain.security.Role;
import com.health.repository.RoleRepository;
import com.health.service.RoleService;



@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	
	@Override
	public List<Role> findAll() {

		List<Role> local = (List<Role>) roleRepository.findAll();
		
		return local;

	}


	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		
		roleRepository.save(role);
	}


	@Override
	public Role findByname(String roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByname(roleName);
	}

	 

	
	
	
	

	
	
	
	
	

}
