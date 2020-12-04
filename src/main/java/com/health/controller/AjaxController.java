package com.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.TopicCategoryMapping;
import com.health.model.User;
import com.health.service.CategoryService;
import com.health.service.RoleService;
import com.health.service.TopicCategoryMappingService;
import com.health.service.TopicService;
import com.health.service.UserRoleService;
import com.health.service.UserService;
import com.health.utility.CommonData;

@Controller
public class AjaxController{
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private TopicCategoryMappingService topicCatService;
	
	@Autowired
	private UserService usrservice;
	
	@Autowired
	private UserRoleService usrRoleService;
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/loadTopicByCategory")
	public @ResponseBody HashMap<Integer, String> getTopicByCategory(@RequestParam(value = "id") int id) {

		HashMap<Integer,String> topicName=new HashMap<>();

		Category cat = catService.findByid(id);

		List<TopicCategoryMapping> local = topicCatService.findAllByCategory(cat) ;

		for(TopicCategoryMapping temp : local) {

			topicName.put(temp.getTopic().getTopicId(), temp.getTopic().getTopicName());
		}
		return topicName;

	}
	
	@RequestMapping("/enableRoleById")
	public @ResponseBody String enableRoleById(@RequestParam(value = "id") long id) {
		
		UserRole usrRole=usrRoleService.findById(id);
		
		if(usrRole != null) {
			try {
				int val=usrRoleService.enableRole(usrRole);
				if(val == 0) {
					// return error
				}
			}catch (Exception e) {
				// TODO: handle exception
				
				// return error
			}
			
			
		}else {
			
			// return error
		}
		
		
		return CommonData.ROLE_APPROVED_SUCCESS_MSG;
	}
	
	
	@RequestMapping("/loadLanguageByUser")
	public @ResponseBody List<String> getLanguageByContributor(@RequestParam(value = "id") String username) {

		List<String> langauges=new ArrayList<String>();
		
		User usr=usrservice.findByUsername(username);
		Role role=roleService.findByname(CommonData.contributorRole);
		
		List<UserRole> userRoles=usrRoleService.findAllByRoleUserStatus(role, usr, true);
		for(UserRole temp:userRoles) {
			if(temp.getLanguage()!=null) {
				langauges.add(temp.getLanguage().getLangName());
			}
		}
		
		return langauges;
	}
	
	@RequestMapping("/loadCategory")
	public @ResponseBody HashMap<Integer, String> getCategory() {

		HashMap<Integer,String> categories=new HashMap<>();
		
		List<Category> categoriesTemp=catService.findAll();
		
		for(Category x:categoriesTemp) {
			categories.put(x.getCategoryId(), x.getCatName());
		}
		
		return categories;
	}
	
}
