package com.health.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.User;

public interface UserRoleRepositary extends  CrudRepository<UserRole, Long>{
	

		@Query("from UserRole u where u.status=?1 and role=?2")
		List<UserRole> findByStatus(int status,Role rolId);
		
		
		
		@Query("from UserRole u where u.user=?1 and role=?2")
		UserRole findByUserAndRole(User user,Role role);
		
		
		
		@Query("from UserRole u where u.user=?1")
		UserRole findByRoleCheck(Role role);
		
		
	
}
