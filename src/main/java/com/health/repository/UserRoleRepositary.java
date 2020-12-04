package com.health.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Language;
import com.health.model.User;


public interface UserRoleRepositary extends  CrudRepository<UserRole, Long>{
	
	@Query("select max(userRoleId) from UserRole")
	long getNewId();
	
	List<UserRole> findAllByuser(User usr);
	
	@Query("from UserRole where lan=?1 and cat=?2 and user=?3 and role=?4")
	UserRole findByLanCatUser(Language lan,Category cat,User usr,Role role);
	
	@Query("from UserRole where lan=?1 and user=?2 and role=?3")
	UserRole findByLanUser(Language lan,User usr,Role role);
	
	@Query("from UserRole where user=?1 and role=?2")
	UserRole findByRoleUser(User usr,Role role);
	
	@Query("from UserRole where user=?1 and role=?2 and status=?3")
	List<UserRole> findByRoleUserStatus(User usr,Role role,boolean status);
	
	List<UserRole> findAllByrole(Role role);
	
	@Modifying
	@Query("update UserRole set status=?1 where userRoleId=?2")
	int enableRole(boolean status, long usrRoleId);
	
//		@Query("from UserRole u where u.status=?1 and role=?2")
//		List<UserRole> findByStatus(int status,Role rolId);
//		
//		List<UserRole> findByuser_id(Long long1);
//		
//		
//		@Query("from UserRole u where u.user=?1 and role=?2")
//		UserRole findByUserAndRole(User user,Role role);
//		
//		@Query("from UserRole u where u.user=?1 and role=?2")
//		List<UserRole> findByUserAndRoles(User user,Role role);
//		
//		
//		
//		@Query("from UserRole u where u.status=?1 and role=?2")
//		UserRole findByAlreadyUser(int status,User userA);
//		
//		@Query("from UserRole u where u.status=?1 and u.user=?2")
//		List<UserRole> findByUserAndStatuslan(int status,User userA);
//		
//		
//		@Query("from UserRole u where u.user=?1")
//		UserRole findByRoleCheck(Role role);
//		
//		@Query(" delete from UserRole u where u.user=?1")
//		UserRole findByAndDelete(User role);
//	
//		@Query(" from UserRole u where u.user=?1")
//		UserRole findByRejectElement(User role);
//	
//		
//		@Query(" from UserRole u where u.user=?1")
//		UserRole findByUserInfo(User role);
//		
//		@Query(" from UserRole u where u.user=?1 and u.role=?2")
//		UserRole findByUserRole(Role role);
//		
//		
//		@Query(" from UserRole u where u.user=?1")
//		List<UserRole> findByUser(User role);
//		
//
//		/* accesing value according contributor */
//	 
//		@Query("from UserRole u where u.status=?1 and user_id=?2")
//		List<UserRole> findByStatusAndUser(int status,User user);
//	
//		/* revoke on the basis of language */
//		
//		@Query("from UserRole u where u.user=?1 and lan_id=?2")
//		UserRole findByLanguageAnduser(User user,Language role);
//		
//		
//		@Query("from UserRole u where u.user=?1 and role=?2")
//		List<UserRole> findByuserAndRole(User user,Role role);
//		
//
//		@Query("from UserRole u where u.user=?1 and role=?2")
//		UserRole findByuserAndRoles(User user,Role role);
//	
//	   /* access the user contribution */	
//		@Query(" from UserRole u where u.status=?1 and u.role=?2") 	
//		List<UserRole> finbyRoleUser(int status,Role role);
//		
//		@Query(" from UserRole u where u.user=?1 and u.role=?2 and u.lan=?3 and u.cat=?4") 	
//		UserRole findBycategorynameAndLanguageNameandRoleandLan(User user,Role role,Language lan,Category cat);
//		
//		@Query(" from UserRole u where u.user=?1")
//		List<UserRole> findBylanguage(User user);
//		
//	
//		@Query("from UserRole u where u.userRoleId=?1 and role=?2")
//		UserRole findByContributorId(Long user,Role role);
//		
//		
//		@Query("from UserRole u where  u.role=?1")
//		List<UserRole> findByRole(Role role);
		
		
	}
