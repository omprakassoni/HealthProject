package com.health.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Language;
import com.health.model.User;
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

	@Override
	public List<UserRole> findAllByUser(User usr) {
		// TODO Auto-generated method stub
		return usrRoleRepo.findAllByuser(usr);
	}

	@Override
	public long getNewUsrRoletId() {
		// TODO Auto-generated method stub
		try {
			return usrRoleRepo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	public UserRole findByLanCatUser(Language lan, Category cat, User usr,Role role) {
		// TODO Auto-generated method stub
		return usrRoleRepo.findByLanCatUser(lan, cat, usr,role);
	}

	@Override
	public List<UserRole> findByLanUser(Language lan, User usr,Role role) {
		// TODO Auto-generated method stub
		return usrRoleRepo.findByLanUser(lan, usr,role);
	}

	@Override
	public List<UserRole> findByRoleUser(User usr, Role role) {
		// TODO Auto-generated method stub
		return usrRoleRepo.findByRoleUser(usr, role);
	}

	@Override
	public List<UserRole> findAllByRoleAndStatusAndRevoked(Role role,boolean status,boolean revokeStatus) {
		// TODO Auto-generated method stub
		List<UserRole> data=new ArrayList<UserRole>();
		
		List<UserRole> temp=usrRoleRepo.findAllByrole(role);
		for(UserRole local:temp) {
			if(local.getStatus()== status && local.isRevoked() == revokeStatus) {
				data.add(local);
			}
		}
		
		return data;
	}

	@Transactional
	@Override
	public int enableRole(UserRole usrRole) {
		// TODO Auto-generated method stub
		return usrRoleRepo.enableRole(true, usrRole.getUserRoleId());
	}

	@Override
	public UserRole findById(long id) {
		// TODO Auto-generated method stub
		Optional<UserRole> local=usrRoleRepo.findById(id);
		return local.get();
	}

	@Override
	public List<UserRole> findAllByRole(Role role) {
		// TODO Auto-generated method stub
		return usrRoleRepo.findAllByrole(role);
	}

	@Override
	public List<UserRole> findAllByRoleUserStatus(Role role, User usr, boolean status) {
		// TODO Auto-generated method stub
		return usrRoleRepo.findByRoleUserStatus(usr, role, status);
	}

}
