package com.health.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.User;
import com.health.repository.RoleRepository;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.service.UserService;
import com.health.service.roleService;

@Controller
public class userController 
{

	@Autowired
	roleService roleservice;

	@Autowired
	RoleRepository rolerespositary;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepositary userRoleRepositary;

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDeny() {

		return "accessDeny";

	}

	@RequestMapping(value = "/adminDeatail", method = RequestMethod.GET)
	public String adminDeatail(Model model, Authentication authentication) {

		return "roleAdminDetail";
	}

	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public String userDetail(Model model, Authentication authentication) {

		return "roleUserDetail";
	}

	/* Admin Deatil information */
	/*
	 * @RequestMapping(value = "/addMeAsAdmin", method = RequestMethod.GET) public
	 * String addMeAsAdmin( Authentication authentication){
	 * 
	 * //find informaton based on username User user =
	 * userService.findByClassname(authentication.getName()); Role
	 * role=roleservice.findByIdRoles(id);
	 * 
	 * System.err.println("Hi"+user.getUserRoles());
	 * 
	 * String name= "ROLE_ADMIN";
	 * 
	 * Role role=rolerespositary.findByname(name);
	 * 
	 * Authentication authentication2 =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * Set<String> roles = authentication.getAuthorities().stream() .map(r ->
	 * r.getAuthority()).collect(Collectors.toSet());
	 * 
	 * System.err.println(roles.toString());
	 * 
	 * 
	 * Authentication authentication1 =
	 * SecurityContextHolder.getContext().getAuthentication();
	 * 
	 * boolean hasUserRole = authentication1.getAuthorities().stream()
	 * 
	 * .anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"));
	 * 
	 * 
	 * 
	 * if(hasUserRole== false){
	 * 
	 * UserRole userRoles=new UserRole(user,role); userRoles.setStatus(0);
	 * 
	 * userRoleRepositary.save(userRoles);
	 * 
	 * return "index";
	 * 
	 * }else {
	 * 
	 * return "error"; }
	 * 
	 * }
	 * 
	 */ 
	
	@RequestMapping(value = "/addMeAsDomainRevieweer", method = RequestMethod.GET)
	public String addMeAsDomainRevieweer(Authentication authentication) {
	

		
		/*
		 * String domain = "DomainReviweer";
		 * 
		 * Role checkvalue = rolerespositary.findByname(domain);
		 * 
		 * 
		 * UserRole userRole = userRoleRepositary.findAll();
		 * 
		 * UserRole userRole=
		 */
		
		
	
		/*
		 * if(userRole.getRole().getRoleId()==3) {
		 * 
		 * 
		 * return ""
		 * 
		 * }
		 */
		
		//System.err.println("Hi"+userRole.getRole().getRoleId());
	
		

		User user = userService.findByClassname(authentication.getName());

		String name = "DomainReviweer";

		Role role = rolerespositary.findByname(name);

		int status = 0;
		UserRole userRoles = new UserRole(user, role);
		userRoles.setStatus(status);
		userRoleRepositary.save(userRoles);

		return "roleAdminDetail";

	}

	@RequestMapping(value = "/addMeAsQualityRevieweer", method = RequestMethod.GET)
	public String addMeAsQualityRevieweer(Authentication authentication) {

		User user = userService.findByClassname(authentication.getName());

		String name = "QualityReviweer";

		Role role = rolerespositary.findByname(name);

		int status = 0;
		UserRole userRoles = new UserRole(user, role);
		userRoles.setStatus(status);
		userRoleRepositary.save(userRoles);

		return "roleAdminDetail";

	}

	@RequestMapping(value = "/addMeAsMasterTrainer", method = RequestMethod.GET)
	public String addMeAsMasterTrainer(Authentication authentication) {

		User user = userService.findByClassname(authentication.getName());

		String name = "MasterTrainer";

		Role role = rolerespositary.findByname(name);

		int status = 0;

		UserRole userRoles = new UserRole(user, role);
		userRoles.setStatus(status);
		userRoleRepositary.save(userRoles);

		return "roleAdminDetail";

	}

	/* approve the domain Revieweer */

	@RequestMapping(value = "/approveMeAsDomainRevieweer", method = RequestMethod.GET)
	public String approveMeAsDomainRevieweer(Model model, Authentication autheticate) {

		int rolId = 3;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);
	
		List<User> userAddInformation = new ArrayList<>();
	
		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		return "showDomainReviweer";

	}

	@RequestMapping("/addDomainRoleById/add/{id}")
	public String addDomainRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "DomainReviweer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "showDomainReviweer";

	}

	@RequestMapping("/addRejectRoleById/add/{id}")
	public String addRejectRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// Disable

		return "showDomainReviweer";

	}


	/* add the Quality Revieweer */
	
	
	@RequestMapping(value = "/approveMeAsQualityRevieweer", method = RequestMethod.GET)
	public String approveMeAsQualityRevieweer(Model model, Authentication autheticate) {

		int rolId = 1;
		Role role = rolerespositary.findByIdRoles(rolId);

		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		return "showQualityReviweer";

	}
	
	
	/* fetching information by Id */

	@RequestMapping("/addQualityRoleById/add/{id}")
	public String addQualityRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {

		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "QualityReviweer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "showQualityReviweer";

	}

	@RequestMapping("/addQualityRoleRejectById/add/{id}")
	public String addQualityRoleRejectById(@PathVariable Long id, Model model, HttpServletRequest req) {

		
		return "showQualityReviweer";
	}
	

	/* approve the master Trainer */
	
	@RequestMapping(value = "/approveMeAsMasterTrainer", method = RequestMethod.GET)
	public String approveMeAsMasterTrainer(Model model, Authentication autheticate) {

		int rolId = 4;
		
		Role role = rolerespositary.findByIdRoles(rolId);
		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("statusByApprov", userAddInformation);

		
		return "showMasterTrainer";

	}

	
	/* fetching information by Id */

	@RequestMapping("/addMasterTrainerRoleById/add/{id}")
	public String addMasterTrainerRoleById(@PathVariable Long id, Model model, HttpServletRequest req) {


		// User user=-userRepository.findByUserId(id);

		User user = userRepository.findOne(id);

		String name = "MasterTrainer";

		Role role = rolerespositary.findByname(name);

		int status = 1;

		UserRole userRole = userRoleRepositary.findByUserAndRole(user, role);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		return "showMasterTrainer";

	}
	
	@RequestMapping("/addmasterRoleRejectById/add/{id}")
	public String addMasterRoleRejectById(@PathVariable Long id, Model model, HttpServletRequest req) {


		return "showQualityReviweer";
	}
	
	
	
	
	

}
