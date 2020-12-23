package com.health.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.City;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.District;
import com.health.model.Language;
import com.health.model.Question;
import com.health.model.State;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.model.TrainingInformation;
import com.health.model.TrainingTopic;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.service.CategoryService;
import com.health.service.CityService;
import com.health.service.ContributorAssignedTutorialService;
import com.health.service.DistrictService;
import com.health.service.LanguageService;
import com.health.service.RoleService;
import com.health.service.StateService;
import com.health.service.TopicCategoryMappingService;
import com.health.service.TopicService;
import com.health.service.TrainingInformationService;
import com.health.service.TutorialService;
import com.health.service.UserRoleService;
import com.health.service.UserService;
import com.health.utility.CommonData;
import com.health.utility.ServiceUtility;

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
	
	@Autowired
	private ContributorAssignedTutorialService conService;
	
	@Autowired
	private TutorialService tutService;
	
	@Autowired
	private LanguageService lanService;
	
	@Autowired
	private Environment env;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private DistrictService disService;
	
	@Autowired
	private CityService cityServie;
	
	@Autowired
	private TrainingInformationService trainingInforService;
	
	
	@RequestMapping("/loadTitleNameInMasterTraining")
	public @ResponseBody HashMap<Integer, String> getTopicNameFromMasterTrainer() {

		HashMap<Integer,String> topicName=new HashMap<>();

		List<TrainingInformation> trainig = trainingInforService.findAll();

		for(TrainingInformation x : trainig) {
			topicName.put(x.getTrainingId(), x.getTitleName());
		}
		return topicName;

	}
	
	@RequestMapping("/loadDistrictByState")
	public @ResponseBody HashMap<Integer, String> getDistrictByState(@RequestParam(value = "id") int id) {

		HashMap<Integer,String> disName=new HashMap<>();

		State state=stateService.findById(id);

		List<District> districts= disService.findAllByState(state);

		for(District temp : districts) {

			disName.put(temp.getId(), temp.getDistrictName());
		}
		return disName;

	}
	
	@RequestMapping("/loadCityByDistrict")
	public @ResponseBody HashMap<Integer, String> getCityByDistrict(@RequestParam(value = "id") int id) {

		HashMap<Integer,String> cityName=new HashMap<>();

		District district=disService.findById(id);

		List<City> cities= cityServie.findAllByDistrict(district);

		for(City temp : cities) {

			cityName.put(temp.getId(), temp.getCityName());
		}
		return cityName;

	}
	
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
	
	@RequestMapping("/loadTopicByCategoryOnContributorRole")
	public @ResponseBody HashMap<Integer, String> getTopicByCategoryOnContributorRole(@RequestParam(value = "id") String catName,Principal principal) {

		HashMap<Integer,String> topicName=new HashMap<>();

		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		Category cat = catService.findBycategoryname(catName);
		
		List<TopicCategoryMapping> localTopicCat = topicCatService.findAllByCategory(cat) ;
		
		List<ContributorAssignedTutorial> conTutorialByUser=conService.findAllByUser(usr);
		
		for(ContributorAssignedTutorial localCon:conTutorialByUser) {
			
			for(TopicCategoryMapping topicTemp:localTopicCat) {
				
				if(localCon.getTopicCatId().getTopicCategoryId() == topicTemp.getTopicCategoryId()) {
					
					topicName.put(topicTemp.getTopic().getTopicId(), topicTemp.getTopic().getTopicName());
				}
			}
		}

		
		return topicName;

	}
	
	@RequestMapping("/loadLanguageForContributorRoleTutorial")
	public @ResponseBody List<String> getLanguageByContributorRole(@RequestParam(value = "id") String catName,
															@RequestParam(value = "topicId") int topicId,Principal principal) {

		List<String> languages=new ArrayList<String>();
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		Category cat = catService.findBycategoryname(catName);
		Topic topic=topicService.findById(topicId);
		TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
		
		List<ContributorAssignedTutorial> conTutorialByUser=conService.findAllByUser(usr);
		
		for(ContributorAssignedTutorial temp:conTutorialByUser) {
			
			if(temp.getTopicCatId().getTopicCategoryId() == localTopicCat.getTopicCategoryId()) {
				languages.add(temp.getLan().getLangName());
			}
		}
		
		return languages;
	}
	
	/*********************************** CONTRIBUTOR SIDE *********************************************/
	@RequestMapping("/viewOutline")
	public @ResponseBody String viewOutline(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tut=tutService.getById(tutorialId);
		if(tut.getOutline()!=null) {
			return tut.getOutline();
		}
		return null;
		
	}
	
	@RequestMapping("/addOutline")
	public @ResponseBody String addOutline(@RequestParam(value = "id") int tutorialId,
											@RequestParam(value = "saveOutline") String outlineData,
											@RequestParam(value = "categoryname") String catName,
											@RequestParam(value = "topicid") int topicId,
											@RequestParam(value = "lanId") String lanId,
											Principal principal) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		if(tutorialId != 0) {
			Tutorial tut=tutService.getById(tutorialId);
			tut.setOutline(outlineData);
			tut.setOutlineStatus(CommonData.DOMAIN_STATUS);
			tutService.save(tut);
			return CommonData.Outline_SAVE_SUCCESS_MSG;
			
		}else {
			
			Category cat = catService.findBycategoryname(catName);
			Topic topic=topicService.findById(topicId);
			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
			Language lan=lanService.getByLanName(lanId);
			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
			Tutorial local=new Tutorial();
			local.setDateAdded(ServiceUtility.getCurrentTime());
			local.setConAssignedTutorial(conLocal);
			local.setOutline(outlineData);
			local.setOutlineStatus(CommonData.DOMAIN_STATUS);
			local.setTutorialId(tutService.getNewId());
			
			try {
				tutService.save(local);
				
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}
			
			
		}
		
		return CommonData.Outline_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/viewKeyword")
	public @ResponseBody String viewkeyword(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tut=tutService.getById(tutorialId);
		if(tut.getKeyword()!=null) {
			return tut.getKeyword();
		}
		return null;
		
	}
	
	@RequestMapping("/addKeyword")
	public @ResponseBody String addKeyword(@RequestParam(value = "id") int tutorialId,
											@RequestParam(value = "savekeyword") String keywordData,
											@RequestParam(value = "categoryname") String catName,
											@RequestParam(value = "topicid") int topicId,
											@RequestParam(value = "lanId") String lanId,
											Principal principal) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		if(tutorialId != 0) {
			Tutorial tut=tutService.getById(tutorialId);
			tut.setKeyword(keywordData);
			tut.setKeywordStatus(CommonData.DOMAIN_STATUS);
			tutService.save(tut);
			return CommonData.Keyword_SAVE_SUCCESS_MSG;
			
		}else {
			
			Category cat = catService.findBycategoryname(catName);
			Topic topic=topicService.findById(topicId);
			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
			Language lan=lanService.getByLanName(lanId);
			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
			Tutorial local=new Tutorial();
			local.setDateAdded(ServiceUtility.getCurrentTime());
			local.setConAssignedTutorial(conLocal);
			local.setKeyword(keywordData);
			local.setKeywordStatus(CommonData.DOMAIN_STATUS);
			local.setTutorialId(tutService.getNewId());
			
			try {
				tutService.save(local);
				
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}
			
			
		}
		
		return CommonData.Keyword_SAVE_SUCCESS_MSG;
		
	}
	
	
	@RequestMapping("/addVideo")
	public @ResponseBody String addKeyword(@RequestParam(value = "id") int tutorialId,
											@RequestParam(value = "videoFileName") MultipartFile videoFile,
											@RequestParam(value = "categoryname") String catName,
											@RequestParam(value = "topicid") int topicId,
											@RequestParam(value = "lanId") String lanId,
											Principal principal) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		if(tutorialId != 0) {
			Tutorial tut=tutService.getById(tutorialId);
			
			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Video");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Video");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					
					tut.setVideo(document);
					tut.setVideoStatus(CommonData.ADMIN_STATUS);
					tutService.save(tut);
					
					return CommonData.Video_SAVE_SUCCESS_MSG;
					
			}catch (Exception e) {
				// TODO: handle exception
				
				// throw error
			}
			
		}else {
			
			Category cat = catService.findBycategoryname(catName);
			Topic topic=topicService.findById(topicId);
			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
			Language lan=lanService.getByLanName(lanId);
			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
			int newTutorialid=tutService.getNewId();
			
			Tutorial local=new Tutorial();
			local.setDateAdded(ServiceUtility.getCurrentTime());
			local.setConAssignedTutorial(conLocal);
			local.setTutorialId(newTutorialid);
			
			try {
				tutService.save(local);
				
				if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Video")) {
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Video");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					Tutorial tut1=tutService.getById(newTutorialid);
					tut1.setVideo(document);
					tut1.setVideoStatus(CommonData.ADMIN_STATUS);
					tutService.save(tut1);
					
					return CommonData.Video_SAVE_SUCCESS_MSG;
					
				}else {
					
					return "error" ; /////////////////  throw error
				}
				
				
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}
			
			
		}
		
		return CommonData.Video_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/addGraphics")
	public @ResponseBody String addGraphics(@RequestParam(value = "id") int tutorialId,
											@RequestParam(value = "uploadGraphicUpload") MultipartFile videoFile,
											@RequestParam(value = "categoryname") String catName,
											@RequestParam(value = "topicid") int topicId,
											@RequestParam(value = "lanId") String lanId,
											Principal principal) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		if(tutorialId != 0) {
			Tutorial tut=tutService.getById(tutorialId);
			
			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Graphics");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Graphics");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					
					tut.setGraphics(document);
					tut.setGraphicsStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut);
					
					return CommonData.Graphics_SAVE_SUCCESS_MSG;
					
			}catch (Exception e) {
				// TODO: handle exception
				
				// throw error
			}
			
		}else {
			
			Category cat = catService.findBycategoryname(catName);
			Topic topic=topicService.findById(topicId);
			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
			Language lan=lanService.getByLanName(lanId);
			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
			int newTutorialid=tutService.getNewId();
			
			Tutorial local=new Tutorial();
			local.setDateAdded(ServiceUtility.getCurrentTime());
			local.setConAssignedTutorial(conLocal);
			local.setTutorialId(newTutorialid);
			
			try {
				tutService.save(local);
				
				if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Graphics")) {
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Graphics");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					Tutorial tut1=tutService.getById(newTutorialid);
					tut1.setGraphics(document);
					tut1.setGraphicsStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut1);
					
					return CommonData.Graphics_SAVE_SUCCESS_MSG;
					
				}else {
					
					return "error" ; /////////////////  throw error
				}
				
				
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}
			
			
		}
		
		return CommonData.Graphics_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/addSlide")
	public @ResponseBody String addSlide(@RequestParam(value = "id") int tutorialId,
											@RequestParam(value = "uploadsSlideFile") MultipartFile videoFile,
											@RequestParam(value = "categoryname") String catName,
											@RequestParam(value = "topicid") int topicId,
											@RequestParam(value = "lanId") String lanId,
											Principal principal) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		if(tutorialId != 0) {
			Tutorial tut=tutService.getById(tutorialId);
			
			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Slide");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Slide");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					
					tut.setSlide(document);
					tut.setSlideStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut);
					
					return CommonData.Slide_SAVE_SUCCESS_MSG;
					
			}catch (Exception e) {
				// TODO: handle exception
				
				// throw error
			}
			
		}else {
			
			Category cat = catService.findBycategoryname(catName);
			Topic topic=topicService.findById(topicId);
			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
			Language lan=lanService.getByLanName(lanId);
			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
			int newTutorialid=tutService.getNewId();
			
			Tutorial local=new Tutorial();
			local.setDateAdded(ServiceUtility.getCurrentTime());
			local.setConAssignedTutorial(conLocal);
			local.setTutorialId(newTutorialid);
			
			try {
				tutService.save(local);
				
				if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Slide")) {
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Slide");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					Tutorial tut1=tutService.getById(newTutorialid);
					tut1.setSlide(document);
					tut1.setSlideStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut1);
					
					return CommonData.Slide_SAVE_SUCCESS_MSG;
					
				}else {
					
					return "error" ; /////////////////  throw error
				}
				
				
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}
			
			
		}
		
		return CommonData.Slide_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/addScript")
	public @ResponseBody String addScript(@RequestParam(value = "id") int tutorialId,
											@RequestParam(value = "uploadsScriptFile") MultipartFile videoFile,
											@RequestParam(value = "categoryname") String catName,
											@RequestParam(value = "topicid") int topicId,
											@RequestParam(value = "lanId") String lanId,
											Principal principal) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=usrservice.findByUsername(principal.getName());
		}
		
		if(tutorialId != 0) {
			Tutorial tut=tutService.getById(tutorialId);
			
			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Script");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Script");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					
					tut.setScript(document);
					tut.setScriptStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut);
					
					return CommonData.Script_SAVE_SUCCESS_MSG;
					
			}catch (Exception e) {
				// TODO: handle exception
				
				// throw error
			}
			
		}else {
			
			Category cat = catService.findBycategoryname(catName);
			Topic topic=topicService.findById(topicId);
			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
			Language lan=lanService.getByLanName(lanId);
			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
			int newTutorialid=tutService.getNewId();
			
			Tutorial local=new Tutorial();
			local.setDateAdded(ServiceUtility.getCurrentTime());
			local.setConAssignedTutorial(conLocal);
			local.setTutorialId(newTutorialid);
			
			try {
				tutService.save(local);
				
				if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Script")) {
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+newTutorialid+"/Script");
					int indexToStart=pathtoUploadPoster.indexOf("Media");
					
					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
					Tutorial tut1=tutService.getById(newTutorialid);
					tut1.setScript(document);
					tut1.setScriptStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut1);
					
					return CommonData.Script_SAVE_SUCCESS_MSG;
					
				}else {
					
					return "error" ; /////////////////  throw error
				}
				
				
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}
			
			
		}
		
		return CommonData.Script_SAVE_SUCCESS_MSG;
		
	}
	
	
	
	/*************************************** END ******************************************************/
	
	
	/********************************** operation at Admin End *****************************************/
	@RequestMapping("/acceptAdminVideo")
	public @ResponseBody String addAdminVideo(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setVideoStatus(CommonData.DOMAIN_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Video_STATUS_SUCCESS_MSG;
		
	}
	
	
	
	/***********************************END ***************************************************************/
	
	/********************************** operation at DOMAIN USER *****************************************/
	@RequestMapping("/acceptDomainOutline")
	public @ResponseBody String acceptDomainOutline(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setOutlineStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Outline_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptDomainScript")
	public @ResponseBody String acceptDomainScript(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setScriptStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Script_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptDomainVideo")
	public @ResponseBody String acceptDomainVideo(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setVideoStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Video_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptDomainSlide")
	public @ResponseBody String acceptDomainSlide(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setSlideStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Slide_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptDomainKeywords")
	public @ResponseBody String acceptDomainKeywords(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setKeywordStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Keyword_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptDomainPreRequistic")
	public @ResponseBody String acceptDomainPreRequistic(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setPreRequisticStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.PRE_REQUISTIC_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptDomainGraphics")
	public @ResponseBody String acceptDomainGraphics(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setGraphicsStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Graphics_SAVE_SUCCESS_MSG;
		
	}
	
	
	
	/***********************************END ***************************************************************/
	
	/********************************** operation at Quality USER *****************************************/
	@RequestMapping("/acceptQualityOutline")
	public @ResponseBody String acceptQualityOutline(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setOutlineStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Outline_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptQualityScript")
	public @ResponseBody String acceptQualityScript(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setScriptStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Script_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptQualityVideo")
	public @ResponseBody String acceptQualityVideo(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setVideoStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Video_STATUS_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptQualitySlide")
	public @ResponseBody String acceptQualitySlide(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setSlideStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Slide_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptQualityKeywords")
	public @ResponseBody String acceptQualityKeywords(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setKeywordStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Keyword_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptQualityPreRequistic")
	public @ResponseBody String acceptQualityPreRequistic(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setPreRequisticStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.PRE_REQUISTIC_SAVE_SUCCESS_MSG;
		
	}
	
	@RequestMapping("/acceptQualityGraphics")
	public @ResponseBody String acceptQualityGraphics(@RequestParam(value = "id") int tutorialId) {
		
		Tutorial tutorial=tutService.getById(tutorialId);
		tutorial.setGraphicsStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		
		return CommonData.Graphics_SAVE_SUCCESS_MSG;
		
	}
	
	
	
	/***********************************END ***************************************************************/
}
