package com.health.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.health.model.Category;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Language;
import com.health.model.TopicCategoryMapping;
import com.health.model.Tutorial;
import com.health.service.CategoryService;
import com.health.service.ContributorAssignedTutorialService;
import com.health.service.LanguageService;
import com.health.service.TopicCategoryMappingService;
import com.health.service.TutorialService;

@RestController
public class RestApi {
	
	@Autowired
	private CategoryService catService;
	

	@Autowired
	private LanguageService lanService;
	
	@Autowired
	private TopicCategoryMappingService topicCatService;
	
	@Autowired
	private ContributorAssignedTutorialService conRepo;
	
	@Autowired
	private TutorialService tutService;
	
	@GetMapping("/getCatAndLan")
	public ResponseEntity<Object> getcat(){
		
		List<Category> cats = catService.findAll();
		List<Language> lans = lanService.getAllLanguages();
		
		Map<String, Map<String, List<Map<String, String>>>> mapdataReturn = new HashMap<String,Map<String, List<Map<String, String>>>>();
		
		Map<String, List<Map<String, String>>> mapdata = new HashMap<String,List<Map<String, String>>>();
		
		List<Map<String, String>> allCategories = new ArrayList<>();
		List<Map<String, String>> allLanguage = new ArrayList<>();
		
		for(Category x : cats) {
			
			Map<String, String> temp = new HashMap<String, String>();
			temp.put("id", Integer.toString(x.getCategoryId()));
			temp.put("foss", x.getCatName());
			temp.put("description", x.getDescription());
			
			allCategories.add(temp);
			
		}
		
		for(Language x :lans) {
			
			Map<String, String> temp = new HashMap<String, String>();
			temp.put("id",Integer.toString(x.getLanId()));
			temp.put("name", x.getLangName());
			
			allLanguage.add(temp);
			
		}
		
		mapdata.put("foss", allCategories);
		mapdata.put("language", allLanguage);
		
		mapdataReturn.put("healthnutrition", mapdata);
		
		return new ResponseEntity<Object>(mapdataReturn,HttpStatus.OK);
 		
	}
	
	@GetMapping("/getTopicOnCatAndLan/{catId}/{lanId}")
	public ResponseEntity<Object> getTopic(@PathVariable (name = "catId") int catId,
			@PathVariable (name = "lanId") int lanId){
		
		Category cat = catService.findByid(catId);
		Language lan = lanService.getById(lanId);
		
		if(cat == null || lan==null) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		
		Map<String, Map<String, List<Map<String, String>>>> mapdataReturn = new HashMap<String,Map<String, List<Map<String, String>>>>();
		
		Map<String, List<Map<String, String>>> mapdata = new HashMap<String,List<Map<String, String>>>();
		
		List<Map<String, String>> alltutorial = new ArrayList<>();
		
		List<TopicCategoryMapping> localTopicCatList = null;
		List<ContributorAssignedTutorial> conAssigTutorialList =null;
		List<Tutorial> tut = null;
		
		System.out.println(cat.getCatName());
		System.out.println(lan.getLangName());
		
		localTopicCatList = topicCatService.findAllByCategory(cat);
		
		conAssigTutorialList = conRepo.findAllByTopicCatAndLanViewPart(localTopicCatList, lan);
		
		tut =tutService.findAllByContributorAssignedTutorialList(conAssigTutorialList);
		
		
		for(Tutorial x :tut) {
			
			Map<String, String> temp = new HashMap<String, String>();
			temp.put("id", Integer.toString(x.getTutorialId()));
			temp.put("outline", x.getOutline());
			temp.put("tutorial", x.getConAssignedTutorial().getTopicCatId().getTopic().getTopicName());
			
			alltutorial.add(temp);
		}
		
		mapdata.put("tutorials", alltutorial);
		
		mapdataReturn.put("healthnutrition", mapdata);
		
		
		return new ResponseEntity<Object>(mapdataReturn,HttpStatus.OK);
		
	}

}
