package com.health.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.health.model.Comment;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.District;
import com.health.model.Language;
import com.health.model.LogManegement;
import com.health.model.State;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.model.TrainingInformation;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.service.CategoryService;
import com.health.service.CityService;
import com.health.service.CommentService;
import com.health.service.ContributorAssignedTutorialService;
import com.health.service.DistrictService;
import com.health.service.LanguageService;
import com.health.service.LogMangementService;
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

	@Autowired
	private CommentService comService;

	@Autowired
	private LogMangementService logService;

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


	@RequestMapping("/loadTopicByCategoryPreRequistic")
	public @ResponseBody HashMap<Integer, String> getTopicByCategoryPreRequistic(@RequestParam(value = "id") String id,
																			@RequestParam(value = "tutorialId") int tutorialId,
																			@RequestParam(value = "langName") String langName) {
		System.out.println("*********************L");

		HashMap<Integer,String> topicName=new HashMap<>();

		Language lan=lanService.getByLanName(langName);
		Tutorial tut =tutService.getById(tutorialId);
		Category cat = catService.findBycategoryname(id);

		List<TopicCategoryMapping> local = topicCatService.findAllByCategory(cat) ;

		List<ContributorAssignedTutorial> cons=conService.findAllByTopicCat(local);

		List<ContributorAssignedTutorial> tempCon= new ArrayList<ContributorAssignedTutorial>();

		for(ContributorAssignedTutorial x : cons) {

			if(x.getLan().getLangName().equalsIgnoreCase(lan.getLangName())) {
				tempCon.add(x);
			}
		}

		List<Tutorial> tuts = tutService.findAllByContributorAssignedTutorialList(tempCon);

		for(Tutorial temp : tuts) {

			System.out.println("*********************");
			System.out.println(temp.getTutorialId());
			System.out.println("*********************");
			if(temp.getTutorialId() != tut.getTutorialId()) {

				topicName.put(temp.getTutorialId(), temp.getConAssignedTutorial().getTopicCatId().getTopic().getTopicName());
			}

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

			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.OUTLINE, CommonData.DOMAIN_STATUS, tut.getOutlineStatus(), CommonData.contributorRole, usr, tut);
			tut.setOutline(outlineData);
			tut.setOutlineStatus(CommonData.DOMAIN_STATUS);

			tutService.save(tut);
			logService.save(log);
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
				LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.OUTLINE, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
				logService.save(log);
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
			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.KEYWORD, CommonData.DOMAIN_STATUS, tut.getKeywordStatus(), CommonData.contributorRole, usr, tut);
			tut.setKeyword(keywordData);
			tut.setKeywordStatus(CommonData.DOMAIN_STATUS);

			tutService.save(tut);

			logService.save(log);
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

				LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.KEYWORD, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
				logService.save(log);
			}catch (Exception e) {
				// TODO: handle exception
				return "error";       // throw error
			}


		}

		return CommonData.Keyword_SAVE_SUCCESS_MSG;

	}


	@RequestMapping("/addPreRequistic")
	public @ResponseBody String addPreRequistic(@RequestParam(value = "id") int tutorialId,
			@RequestParam(value = "categoryname") String catName,
			@RequestParam(value = "topicid") int topicId,
			@RequestParam(value = "lanId") String lanId,Principal principal) {
		System.out.println("******************************************Here");
		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}
		Tutorial tut = null;

		if(tutorialId != 0) {
			tut=tutService.getById(tutorialId);
		}
		Tutorial tutorial_temp = tutService.getById(topicId);
		System.out.println(topicId);
		if(tutorialId != 0) {

			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.PRE_REQUISTIC, CommonData.DOMAIN_STATUS, tut.getKeywordStatus(), CommonData.contributorRole, usr, tut);

			tut.setPreRequistic(tutorial_temp);
			System.out.println("******************************************"+tut);
			System.out.println("******************************************"+tutorial_temp);
			tut.setPreRequisticStatus(CommonData.DOMAIN_STATUS);

			tutService.save(tut);

			logService.save(log);
			return CommonData.PRE_REQUISTIC_SAVE_SUCCESS_MSG;

		}
//		else {
//
//			Category cat = catService.findBycategoryname(catName);
//			Topic topic=topicService.findById(topicId);
//			TopicCategoryMapping localTopicCat = topicCatService.findAllByCategoryAndTopic(cat, topic);
//			Language lan=lanService.getByLanName(lanId);
//			ContributorAssignedTutorial conLocal=conService.findByUserTopicCatLan(usr, localTopicCat, lan);
//			Tutorial local=new Tutorial();
//			local.setDateAdded(ServiceUtility.getCurrentTime());
//			local.setConAssignedTutorial(conLocal);
//			local.setPreRequistic(tut);
//			local.setPreRequisticStatus(CommonData.DOMAIN_STATUS);
//			local.setTutorialId(tutService.getNewId());
//
//			try {
//				tutService.save(local);
//
//				LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.PRE_REQUISTIC, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
//				logService.save(log);
//
//			}catch (Exception e) {
//				// TODO: handle exception
//				return "error";       // throw error
//			}
//
//
//		}

		return CommonData.PRE_REQUISTIC_SAVE_SUCCESS_MSG;

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
			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.VIDEO, CommonData.ADMIN_STATUS, tut.getVideoStatus(), CommonData.contributorRole, usr, tut);

			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Video");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Video");
					int indexToStart=pathtoUploadPoster.indexOf("Media");

					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

					tut.setVideo(document);
					tut.setVideoStatus(CommonData.ADMIN_STATUS);


					logService.save(log);
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

					LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.KEYWORD, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
					logService.save(log);

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
			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.GRAPHICS, CommonData.DOMAIN_STATUS, tut.getGraphicsStatus(), CommonData.contributorRole, usr, tut);

			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Graphics");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Graphics");
					int indexToStart=pathtoUploadPoster.indexOf("Media");

					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

					tut.setGraphics(document);
					tut.setGraphicsStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut);
					logService.save(log);

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
					LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.GRAPHICS, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
					logService.save(log);
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
			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SLIDE, CommonData.DOMAIN_STATUS, tut.getSlideStatus(), CommonData.contributorRole, usr, tut);

			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Slide");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Slide");
					int indexToStart=pathtoUploadPoster.indexOf("Media");

					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

					tut.setSlide(document);
					tut.setSlideStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut);
					logService.save(log);
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

					LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SLIDE, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
					logService.save(log);
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
			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SCRIPT, CommonData.DOMAIN_STATUS, tut.getScriptStatus(), CommonData.contributorRole, usr, tut);
			try {
				ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Script");
					String pathtoUploadPoster=ServiceUtility.uploadVideoFile(videoFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTutorial+tut.getTutorialId()+"/Script");
					int indexToStart=pathtoUploadPoster.indexOf("Media");

					String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

					tut.setScript(document);
					tut.setScriptStatus(CommonData.DOMAIN_STATUS);
					tutService.save(tut);

					logService.save(log);
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

					LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SCRIPT, CommonData.DOMAIN_STATUS, 0, CommonData.contributorRole, usr, local);
					logService.save(log);
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
	public @ResponseBody String addAdminVideo(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.VIDEO, CommonData.DOMAIN_STATUS, tutorial.getVideoStatus(), CommonData.adminReviewerRole, usr, tutorial);

		tutorial.setVideoStatus(CommonData.DOMAIN_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Video_STATUS_SUCCESS_MSG;

	}



	/***********************************END ***************************************************************/

	/********************************** operation at DOMAIN USER *****************************************/
	@RequestMapping("/acceptDomainOutline")
	public @ResponseBody String acceptDomainOutline(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.OUTLINE, CommonData.QUALITY_STATUS, tutorial.getOutlineStatus(), CommonData.domainReviewerRole, usr, tutorial);
		tutorial.setOutlineStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Outline_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptDomainScript")
	public @ResponseBody String acceptDomainScript(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SCRIPT, CommonData.QUALITY_STATUS, tutorial.getScriptStatus(), CommonData.domainReviewerRole, usr, tutorial);

		tutorial.setScriptStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);

		return CommonData.Script_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptDomainVideo")
	public @ResponseBody String acceptDomainVideo(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.VIDEO, CommonData.QUALITY_STATUS, tutorial.getVideoStatus(), CommonData.domainReviewerRole, usr, tutorial);

		tutorial.setVideoStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Video_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptDomainSlide")
	public @ResponseBody String acceptDomainSlide(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SLIDE, CommonData.QUALITY_STATUS, tutorial.getSlideStatus(), CommonData.domainReviewerRole, usr, tutorial);
		tutorial.setSlideStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Slide_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptDomainKeywords")
	public @ResponseBody String acceptDomainKeywords(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.KEYWORD, CommonData.QUALITY_STATUS, tutorial.getKeywordStatus(), CommonData.domainReviewerRole, usr, tutorial);
		tutorial.setKeywordStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Keyword_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptDomainPreRequistic")
	public @ResponseBody String acceptDomainPreRequistic(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}
		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.PRE_REQUISTIC, CommonData.QUALITY_STATUS, tutorial.getPreRequisticStatus(), CommonData.domainReviewerRole, usr, tutorial);
		tutorial.setPreRequisticStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.PRE_REQUISTIC_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptDomainGraphics")
	public @ResponseBody String acceptDomainGraphics(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.GRAPHICS, CommonData.QUALITY_STATUS, tutorial.getGraphicsStatus(), CommonData.domainReviewerRole, usr, tutorial);
		tutorial.setGraphicsStatus(CommonData.QUALITY_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Graphics_SAVE_SUCCESS_MSG;

	}



	/***********************************END ***************************************************************/

	/********************************** operation at Quality USER *****************************************/
	@RequestMapping("/acceptQualityOutline")
	public @ResponseBody String acceptQualityOutline(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.OUTLINE, CommonData.WAITING_PUBLISH_STATUS, tutorial.getOutlineStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setOutlineStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Outline_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptQualityScript")
	public @ResponseBody String acceptQualityScript(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SCRIPT, CommonData.WAITING_PUBLISH_STATUS, tutorial.getScriptStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setScriptStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Script_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptQualityVideo")
	public @ResponseBody String acceptQualityVideo(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.VIDEO, CommonData.WAITING_PUBLISH_STATUS, tutorial.getVideoStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setVideoStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Video_STATUS_SUCCESS_MSG;

	}

	@RequestMapping("/acceptQualitySlide")
	public @ResponseBody String acceptQualitySlide(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.SLIDE, CommonData.WAITING_PUBLISH_STATUS, tutorial.getSlideStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setSlideStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Slide_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptQualityKeywords")
	public @ResponseBody String acceptQualityKeywords(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.KEYWORD, CommonData.WAITING_PUBLISH_STATUS, tutorial.getKeywordStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setKeywordStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Keyword_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptQualityPreRequistic")
	public @ResponseBody String acceptQualityPreRequistic(@RequestParam(value = "id") int tutorialId, Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.PRE_REQUISTIC, CommonData.WAITING_PUBLISH_STATUS, tutorial.getPreRequisticStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setPreRequisticStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.PRE_REQUISTIC_SAVE_SUCCESS_MSG;

	}

	@RequestMapping("/acceptQualityGraphics")
	public @ResponseBody String acceptQualityGraphics(@RequestParam(value = "id") int tutorialId,Principal principal) {

		User usr=new User();
		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tutorial=tutService.getById(tutorialId);
		LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.GRAPHICS, CommonData.WAITING_PUBLISH_STATUS, tutorial.getGraphicsStatus(), CommonData.qualityReviewerRole, usr, tutorial);
		tutorial.setGraphicsStatus(CommonData.WAITING_PUBLISH_STATUS);
		tutService.save(tutorial);
		logService.save(log);
		return CommonData.Graphics_SAVE_SUCCESS_MSG;

	}



	/***********************************END ***************************************************************/
/******************************* COMMENT MODULE UNDER CREATION PART ********************************/

	@RequestMapping("/commentByAdminReviewer")
	public @ResponseBody String commentByAdminReviewer(@RequestParam(value = "id") int tutorialId,
													@RequestParam(value = "msg") String msg, Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		Tutorial tut = tutService.getById(tutorialId);

		Comment com = new Comment();
		com.setComment(msg);
		com.setCommentId(comService.getNewCommendId());
		com.setDateAdded(ServiceUtility.getCurrentTime());
		com.setType(CommonData.VIDEO);
		com.setUser(usr);
		com.setTutorialInfos(tut);
		com.setRoleName(CommonData.adminReviewerRole);

		try {
			comService.save(com);

			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), CommonData.VIDEO, CommonData.IMPROVEMENT_STATUS, tut.getVideoStatus(), CommonData.adminReviewerRole, usr, tut);
			tut.setVideoStatus(CommonData.IMPROVEMENT_STATUS);
			tutService.save(tut);
			logService.save(log);
			return CommonData.COMMENT_SUCCESS;

		}catch (Exception e) {
			// TODO: handle exception
			return CommonData.FAILURE;
		}



	}

	@RequestMapping("/commentByReviewer")
	public @ResponseBody String commentByReviewer(@RequestParam(value = "id") int tutorialId,
													@RequestParam(value = "msg") String msg,
													@RequestParam(value = "type") String type,
													@RequestParam(value = "role") String role,
													Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=usrservice.findByUsername(principal.getName());
		}

		String roleName = null;
		int statusvalue=0;
		String typeValue=null;

		if(role.equalsIgnoreCase("Quality")) {
			roleName=CommonData.qualityReviewerRole;
		}else if(role.equalsIgnoreCase("Domain")) {
			roleName=CommonData.domainReviewerRole;
		}
		Tutorial tut = tutService.getById(tutorialId);

		Comment com = new Comment();
		com.setComment(msg);
		com.setCommentId(comService.getNewCommendId());
		com.setDateAdded(ServiceUtility.getCurrentTime());
		com.setRoleName(roleName);
		if(type.equalsIgnoreCase(CommonData.SCRIPT)) {
			com.setType(CommonData.SCRIPT);
			statusvalue = tut.getScriptStatus();
			typeValue = CommonData.SCRIPT;

		}else if(type.equalsIgnoreCase(CommonData.KEYWORD)) {
			com.setType(CommonData.KEYWORD);
			statusvalue = tut.getKeywordStatus();
			typeValue = CommonData.KEYWORD;

		}else if(type.equalsIgnoreCase(CommonData.SLIDE)) {
			com.setType(CommonData.SLIDE);
			statusvalue = tut.getSlideStatus();
			typeValue = CommonData.SLIDE;

		}else if(type.equalsIgnoreCase(CommonData.VIDEO)) {
			com.setType(CommonData.VIDEO);
			statusvalue = tut.getVideoStatus();
			typeValue = CommonData.VIDEO;

		}else if(type.equalsIgnoreCase(CommonData.GRAPHICS)) {
			com.setType(CommonData.GRAPHICS);
			statusvalue = tut.getGraphicsStatus();
			typeValue = CommonData.GRAPHICS;

		}else if(type.equalsIgnoreCase(CommonData.PRE_REQUISTIC)) {
			com.setType(CommonData.PRE_REQUISTIC);
			statusvalue = tut.getPreRequisticStatus();
			typeValue = CommonData.PRE_REQUISTIC;

		}else if(type.equalsIgnoreCase(CommonData.OUTLINE)) {
			com.setType(CommonData.OUTLINE);
			statusvalue = tut.getOutlineStatus();
			typeValue = CommonData.OUTLINE;

		}else {

			return CommonData.FAILURE;
		}

		com.setUser(usr);
		com.setTutorialInfos(tut);



		try {
			comService.save(com);

			LogManegement log = new LogManegement(logService.getNewId(), ServiceUtility.getCurrentTime(), typeValue, CommonData.IMPROVEMENT_STATUS, statusvalue, roleName, usr, tut);

			if(type.equalsIgnoreCase(CommonData.SCRIPT)) {
				tut.setScriptStatus(CommonData.IMPROVEMENT_STATUS);
			}else if(type.equalsIgnoreCase(CommonData.KEYWORD)) {
				tut.setKeywordStatus(CommonData.IMPROVEMENT_STATUS);
			}else if(type.equalsIgnoreCase(CommonData.SLIDE)) {
				tut.setSlideStatus(CommonData.IMPROVEMENT_STATUS);
			}else if(type.equalsIgnoreCase(CommonData.VIDEO)) {
				tut.setVideoStatus(CommonData.IMPROVEMENT_STATUS);
			}else if(type.equalsIgnoreCase(CommonData.GRAPHICS)) {
				tut.setGraphicsStatus(CommonData.IMPROVEMENT_STATUS);
			}else if(type.equalsIgnoreCase(CommonData.PRE_REQUISTIC)) {
				tut.setPreRequisticStatus(CommonData.IMPROVEMENT_STATUS);
			}else if(type.equalsIgnoreCase(CommonData.OUTLINE)) {
				tut.setOutlineStatus(CommonData.IMPROVEMENT_STATUS);
			}

			tutService.save(tut);
			logService.save(log);

			return CommonData.COMMENT_SUCCESS;

		}catch (Exception e) {
			// TODO: handle exception
			return CommonData.FAILURE;
		}



	}


	/************************************ END ********************************************************/
}