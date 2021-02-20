package com.health.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.model.OrganizationRole;
import com.health.repository.OrganizationRoleRepository;
import com.health.service.OrganizationRoleService;

@Service
public class OrganizationRoleServiceImpl implements OrganizationRoleService {

	@Autowired
	OrganizationRoleRepository repo;
	@Override
	public List<OrganizationRole> findAll() {

		return (List<OrganizationRole>) (repo.findAll());
	}
	@Override
	public void save(OrganizationRole role) {

		repo.save(role);
	}
	@Override
	public OrganizationRole getByRole(String role) {

		return (OrganizationRole) repo.findByRole(role);
	}
	@Override
	public int getnewRoleId() {
		try {
			return repo.getNewId()+1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}

	}

	@Override
	public OrganizationRole getById(int roleId) {

		try {
			Optional<OrganizationRole> local=repo.findById(roleId);
			return local.get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
