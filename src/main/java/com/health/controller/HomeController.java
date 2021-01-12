package com.health.controller;

import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.City;
import com.health.model.Comment;
import com.health.model.Consultant;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.District;
import com.health.model.Event;
import com.health.model.FeedbackMasterTrainer;
import com.health.model.Language;
import com.health.model.Question;
import com.health.model.State;
import com.health.model.Testimonial;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.model.TraineeInformation;
import com.health.model.TrainingInformation;
import com.health.model.TrainingTopic;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.service.CategoryService;
import com.health.service.CityService;
import com.health.service.CommentService;
import com.health.service.ConsultantService;
import com.health.service.ContributorAssignedTutorialService;
import com.health.service.DistrictService;
import com.health.service.EventService;
import com.health.service.FeedBackMasterTrainerService;
import com.health.service.LanguageService;
import com.health.service.QuestionService;
import com.health.service.RoleService;
import com.health.service.StateService;
import com.health.service.TestimonialService;
import com.health.service.TopicCategoryMappingService;
import com.health.service.TopicService;
import com.health.service.TraineeInformationService;
import com.health.service.TrainingInformationService;
import com.health.service.TrainingTopicService;
import com.health.service.TutorialService;
import com.health.service.UserRoleService;
import com.health.service.UserService;
import com.health.utility.CommonData;
import com.health.utility.MailConstructor;
import com.health.utility.SecurityUtility;
import com.health.utility.ServiceUtility;

@Controller
public class HomeController {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailConstructor mailConstructor;

	@Autowired
	private UserService userService;  // in use

	@Autowired
	private LanguageService lanService;

	@Autowired
	private CategoryService catService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private TopicService topicService;

	@Autowired
	private TopicCategoryMappingService topicCatService;

	@Autowired
	private QuestionService questService;

	@Autowired
	private EventService eventservice;

	@Autowired
	private TestimonialService testService;

	@Autowired
	private ConsultantService consultService;

	@Autowired
	private Environment env;

	@Autowired
	private UserRoleService usrRoleService;

	@Autowired
	private ContributorAssignedTutorialService conRepo;

	@Autowired
	private TutorialService tutService;

	@Autowired
	private StateService stateService;

	@Autowired
	private TrainingInformationService trainingInfoService;

	@Autowired
	private DistrictService districtService;

	@Autowired
	private CityService cityService;

	@Autowired
	private TraineeInformationService traineeService;

	@Autowired
	private TrainingTopicService trainingTopicServ;

	@Autowired
	private FeedBackMasterTrainerService feedServ;

	@Autowired
	private CommentService comService;


//	@RequestMapping("/viewVideo/view/{id}")
//	public String viewVideo(Model model, @PathVariable Integer id) {
//		// Tutorial tutorials = tutorialDao.findOne(id);
//
//		// code for version 2.1.7
//		Optional<Tutorial> temp1= tutorialDao.findById(id);
//		Tutorial tutorials=temp1.get();
//
//		int status = 1;
//		List<Tutorial> tutorialRes = tutorialDao.findByLanAndCat(tutorials.getCategory(), tutorials.getLan(), status);
//
//		model.addAttribute("list", tutorials);
//		model.addAttribute("listOfTutorial", tutorialRes);
//
//		List<Tutorial> category = tutorialDao.finBystatus();
//		ArrayList<String> tutorialRes1 = new ArrayList<String>();
//		for (Tutorial tutorial : category) {
//			tutorialRes1.add(tutorial.getCategory().getCategoryname());
//		}
//		Set<String> categoryList=new LinkedHashSet<String>(tutorialRes1);
//		model.addAttribute("categorys",categoryList);
//
//		return "showVideo";
//	}
//
//	@RequestMapping("/viewVideoList/view/{id}")
//	public String viewVideoList(Model model, @PathVariable Integer id) {
//
//		// Tutorial tutorials = tutorialDao.findOne(id);
//
//		// code for version 2.1.7
//				Optional<Tutorial> temp1= tutorialDao.findById(id);
//				Tutorial tutorials=temp1.get();
//
//		tutorials.getTopic().getTopicname();
//		int status = 1;
//		List<Tutorial> tutorialRes = tutorialDao.findByLanAndCat(tutorials.getCategory(), tutorials.getLan(), status);
//		model.addAttribute("list", tutorials);
//		model.addAttribute("listOfTutorial", tutorialRes);
//
//		return "showVideo";
//	}


	@RequestMapping("/")
	public String index(Model model) {

		List<Event> events=eventservice.findAll();
		List<Testimonial> testi=testService.findAll();
		List<Consultant> consults= consultService.findAll();
		List<Language> languages= lanService.getAllLanguages();
		List<Category> categories= catService.findAll();
		List<Topic> topics =topicService.findAll();


		List<Event> evnHome = new ArrayList<>();
		List<Testimonial> testHome = new ArrayList<>();
		List<Consultant> consulHome = new ArrayList<>();
		List<Category> categoryHome = new ArrayList<>();

		int upperlimit = 0;

		for(Event local : events) {
			evnHome.add(local);
			if(++upperlimit > 3) {
				break;
			}
		}

		upperlimit = 0;

		for(Testimonial local : testi) {
			testHome.add(local);
			if(++upperlimit > 3) {
				break;
			}
		}

		upperlimit = 0;

		for(Consultant local : consults) {
			if(local.isOnHome()) {
				consulHome.add(local);
			}
			if(++upperlimit > 4) {
				break;
			}
		}
//		set upper limit for categories count
		upperlimit = 4 ;
		categoryHome=(categories.size()>upperlimit) ? categories.subList(0, upperlimit):categories;

		model.addAttribute("listOfConsultant", consulHome);
		model.addAttribute("listofTestimonial", testHome);
		model.addAttribute("listofCategories", categoryHome);
		model.addAttribute("languageCount", languages.size());
		model.addAttribute("videoCount", tutService.findAll().size());
		model.addAttribute("consultantCount", consults.size());
		model.addAttribute("events", evnHome);

		model.addAttribute("categories", categories);
		model.addAttribute("languages", languages);
		model.addAttribute("topics", topics);



//		List<Tutorial> category = tutorialDao.finBystatus();
//		ArrayList<String> tutorialRes = new ArrayList<String>();
//		for (Tutorial tutorial : category) {
//			tutorialRes.add(tutorial.getCategory().getCategoryname());
//		}
//		Set<String> categoryList=new LinkedHashSet<String>(tutorialRes);
//		model.addAttribute("categorys",categoryList);
//
//		List<Event> event=eventDao.getAllEvent();
//
//		model.addAttribute("events",event);
//
//		List<Consaltantant> consalatant=consalatantDao.findByConsultantShowonHomepage(true);
//
//		for (Consaltantant consaltantant : consalatant)
//		{
//			System.err.println(consaltantant.getNameConsaltant());
//		}
//
//		List<Testimonial> testimonial = testimonialdao.findBydate();
//		for (Testimonial videotestimonial : testimonial) {
//			System.err.println(videotestimonial.getUploadTestiminial());
//		}
//
//		List<Tutorial> tutorials = tutorialDao.finBystatus();
//
//		long languageCount = languageDao.count();
//		java.util.List<Tutorial> videos = tutorialDao.finBystatus();
//
//		List<Category> categories = categoryDao.findBystatus(1);
//		List<Category> categoriesDisplay = new ArrayList<>();
//		int size = 4;
//		if(categories.size()>=size) {
//			for(int i = 0; i< size; i++) {
//				categoriesDisplay.add(categories.get(i));
//			}
//			categories = categoriesDisplay;
//		}
//		List<Consaltantant> consultantDisplay = new ArrayList<>();
//		size = 3;
//		if(consalatant.size()>=size) {
//			for(int i = 0; i< size; i++) {
//				consultantDisplay.add(consalatant.get(i));
//			}
//			consalatant = consultantDisplay;
//		}
//		List<Testimonial> testimonialDisplay = new ArrayList<>();
//		if(testimonial.size()>=size) {
//			for(int i = 0; i< size; i++) {
//				testimonialDisplay.add(testimonial.get(i));
//			}
//			testimonial = testimonialDisplay;
//		}
//		List<Event> eventDisplay = new ArrayList<>();
//		size = 3;
//		if(event.size()>=size) {
//			for(int i = 0; i< size; i++) {
//				eventDisplay.add(event.get(i));
//			}
//			event = eventDisplay;
//		}
//		int videoCount = videos.size();
//		long consultantCount = consultantDao.count();
//
//		model.addAttribute("tutorials", tutorials);
//		model.addAttribute("listofConsalatatnt", consalatant);
//		model.addAttribute("listofTestimonial", testimonial);
//		model.addAttribute("languageCount", languageCount);
//		model.addAttribute("videoCount", videoCount);
//		model.addAttribute("consultantCount", consultantCount);
//		model.addAttribute("categories", categories);
//		model.addAttribute("event", event);

		return "index";
	}

	@RequestMapping(value = "/tutorials", method = RequestMethod.GET)
	public String viewCoursesAvailable(HttpServletRequest req,
			@RequestParam(name = "categoryName") String cat,
			@RequestParam(name = "topic") String topic,
			@RequestParam(name = "lan") String lan,Principal principal,Model model) {

		Category localCat = null;
		Language localLan = null;
		Topic localTopic = null;
		TopicCategoryMapping localTopicCat = null;
		List<TopicCategoryMapping> localTopicCatList = null;
		List<ContributorAssignedTutorial> conAssigTutorialList =null;
		ContributorAssignedTutorial conAssigTutorial = null;

		List<Tutorial> tut = null;
		List<Tutorial> tutToView = new ArrayList<Tutorial>();

		User usr=new User();
		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		System.out.println(lan);
		if(!cat.contentEquals("Select Category")) {
			localCat = catService.findBycategoryname(cat);
		}

		if(!topic.contentEquals("Select Topic")) {
			localTopic = topicService.findBytopicName(topic);
		}

		if(!lan.contentEquals("Select Language")) {
			localLan= lanService.getByLanName(lan);
		}

		if(localCat != null && localTopic != null) {
			localTopicCat = topicCatService.findAllByCategoryAndTopic(localCat, localTopic);
		}else if (localCat != null) {
			localTopicCatList = topicCatService.findAllByCategory(localCat);
		}else if (localTopic != null) {
			localTopicCatList = topicCatService.findAllByTopic(localTopic);
		}

		if(localTopicCat != null) {

			if(localLan != null) {
				conAssigTutorial = conRepo.findByTopicCatAndLanViewPart(localTopicCat, localLan);
			}else {
				conAssigTutorialList = conRepo.findByTopicCat(localTopicCat);
			}
		}else if(localTopicCatList != null) {

			if(localLan != null) {
				conAssigTutorialList = conRepo.findAllByTopicCatAndLanViewPart(localTopicCatList, localLan);
			}else {
				conAssigTutorialList = conRepo.findAllByTopicCat(localTopicCatList);
			}
		}else {
			if(localLan != null) {
				conAssigTutorialList = conRepo.findAllByLan(localLan);
			}
		}



		if(conAssigTutorial != null) {
			tut = tutService.findAllByContributorAssignedTutorial(conAssigTutorial);
		} else if(conAssigTutorialList != null) {
			tut =tutService.findAllByContributorAssignedTutorialList(conAssigTutorialList);
		}else {
			tut = tutService.findAll();
		}

		for(Tutorial temp :tut) {
			System.out.println(temp.getTutorialId());
			if(temp.isStatus()) {
				tutToView.add(temp);
			}
		}

		for(Tutorial temp :tutToView) {
			System.out.println(temp.getTutorialId() +"***********");
		}
		model.addAttribute("tutorials", tutToView);

		return "tutorialList";   // add view name (filename)
	}

	@RequestMapping(value = "/tutorialView/{id}", method = RequestMethod.GET)
	public String viewTutorial(HttpServletRequest req,
			@PathVariable int id,
			Principal principal,Model model) {
			 Tutorial tutorial = tutService.getById(id);
			 model.addAttribute("tutorial", tutorial);

			 Category category = catService.findByid(tutorial.getConAssignedTutorial().getTopicCatId().getCat().getCategoryId());
			 List<TopicCategoryMapping> topicCatMapping = topicCatService.findAllByCategory(category);
			 List<ContributorAssignedTutorial> contriAssignedTut = conRepo.findAllByTopicCat(topicCatMapping);
			 List<Tutorial> tutorials = tutService.findAllByContributorAssignedTutorialList(contriAssignedTut);
			 model.addAttribute("tutorials", tutorials);
			 System.out.println("*******************");
			 System.out.println(tutorials);
			 System.out.println("*******************");
			return "tutorial";
	}

	@RequestMapping("/login")									// in use
	public String loginGet(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "signup";
	}

	@RequestMapping(value = "/showEvent",method = RequestMethod.GET)
	public String showEventGet(Model model) {

		List<Event> events=eventservice.findAll();
		model.addAttribute("Events", events);
		return "events";
	}

	@RequestMapping(value = "/showConsultant",method = RequestMethod.GET)
	public String showConsultantGet(Model model) {

		List<Consultant> consults = consultService.findAll();
		System.out.println("******************************"+consults);
		model.addAttribute("listConsultant", consults);
		return "Consultants";
	}

	@RequestMapping(value = "/showTestimonial",method = RequestMethod.GET)
	public String showTestimonialGet(Model model) {

		List<Testimonial> testi = testService.findAll();
		model.addAttribute("Testimonials", testi);
		return "signup";
	}

	@RequestMapping(value = "/forgetPassword",method = RequestMethod.POST)
	public String forgetPasswordPost(HttpServletRequest request, @ModelAttribute("email") String email, Model model) {

		model.addAttribute("classActiveForgetPassword", true);
		return "signup";
	}

	@RequestMapping("/forgetPassword")									// in use
	public String forgetPasswordGet(Model model) {

		model.addAttribute("classActiveForgetPassword", true);
		return "signup";
	}

	@RequestMapping(value = "/categories",method = RequestMethod.GET)
	public String showCategoriesGet(Model model) {

		List<Category> categories=catService.findAll();
		model.addAttribute("categories", categories);
		return "categories";
	}


	/**************************** USER REGISTRATION *************************************************/

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)    // in use
	public String newUserPost(
			HttpServletRequest request,
			@ModelAttribute("username") String username, @ModelAttribute("firstName") String firstName,
			@ModelAttribute("lastName") String lastName, @ModelAttribute("email") String userEmail,
			@ModelAttribute("password") String password, @ModelAttribute("address") String address,
			@ModelAttribute("phone") String phone,
			Model model) throws Exception {

		long phoneLongValue;
		model.addAttribute("classActiveNewAccount", true);
		model.addAttribute("email", userEmail);
		model.addAttribute("username", username);

		if (userService.findByUsername(username) != null) {
			model.addAttribute("usernameExists", true);
			return "signup";
		}

		if (userService.findByEmail(userEmail) != null) {
			model.addAttribute("emailExists", true);
			return "signup";
		}

		if(!ServiceUtility.checkEmailValidity(userEmail)) {   // need to accommodate

			model.addAttribute("emailWrong", true);
			return "signup";
		}

		if(phone.length()>10) {								// need to accommodate

			model.addAttribute("phoneWrong", true);
			return "signup";

		}else {
			phoneLongValue=Long.parseLong(phone);

		}
		User user = new User();
		user.setId(userService.getNewId());
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setPhone(phoneLongValue);
		user.setPassword(SecurityUtility.passwordEncoder().encode(password));
		user.setDateAdded(ServiceUtility.getCurrentTime());

		userService.save(user);
		model.addAttribute("emailSent", "true");

		return "signup";

	}

	@RequestMapping("/newUser")										// in use
	public String newUserGet (Model model) {

		model.addAttribute("classActiveNewAccount", true);
		return "signup";


	}

	/************************** END ****************************************************/

	/**************************** DASHBAORD PAGE FOR ALL USER *****************************************/

	@RequestMapping(value = "/dashBoard",method = RequestMethod.GET)
	public String dashBoardGet (Model model,Principal principal) {

		User usr=new User();
		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		return "roleAdminDetail";
	}

	/****************************************** ADD CATEGORY *************************************************/
	@RequestMapping(value = "/addCategory",method = RequestMethod.GET)
	public String addCategoryGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Category> categories = catService.findAll();
		model.addAttribute("categories", categories);

		return "addCategory";

	}

	@RequestMapping(value = "/addCategory",method = RequestMethod.POST)
	public String addCategoryPost(Model model,Principal principal,HttpServletRequest req,
								  @RequestParam("categoryImage") MultipartFile[] files) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Category> categoriesTemp = catService.findAll();
		model.addAttribute("categories", categoriesTemp);

		String categoryName = req.getParameter("categoryname");
		String categoryDesc = req.getParameter("categoryDesc");

		if(catService.findBycategoryname(categoryName)!=null) {
			model.addAttribute("error_msg", CommonData.RECORD_EXISTS);
			return "addCategory";
		}

		if(!ServiceUtility.checkFileExtensionImage(files)) {
			model.addAttribute("error_msg", CommonData.JPG_PNG_EXT);
			return "addCategory";
		}

		int newCatId=catService.getNewCatId();
		Category cat=new Category();
		cat.setCategoryId(newCatId);
		cat.setCatName(categoryName);
		cat.setDateAdded(ServiceUtility.getCurrentTime());
		cat.setPosterPath("null");
		cat.setDescription(categoryDesc);
		cat.setUser(usr);

		Set<Category> categories=new HashSet<Category>();
		categories.add(cat);

		try {
			userService.addUserToCategory(usr, categories);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error_msg", CommonData.RECORD_ERROR);
			return "addCategory";
		}

		try {
			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryCategory+newCatId)) {
				String pathtoUploadPoster=ServiceUtility.uploadFile(files, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryCategory+newCatId);
				int indexToStart=pathtoUploadPoster.indexOf("Media");

				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

				Category local=catService.findBycategoryname(categoryName);
				local.setPosterPath(document);

				catService.save(local);
			}else {

			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error_msg", CommonData.RECORD_ERROR);
			return "addCategory";
		}

		model.addAttribute("success_msg", CommonData.RECORD_SAVE_SUCCESS_MSG);
		return "addCategory";

	}

	/************************************END**********************************************/

	/************************************ADD LANGUAGE**********************************************/

	@RequestMapping(value = "/addLanguage",method = RequestMethod.GET)
	public String addLanguageGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Language> languages=lanService.getAllLanguages();

		model.addAttribute("languages", languages);

		return "addlanguage";

	}

	@RequestMapping(value = "/addLanguage",method = RequestMethod.POST)
	public String addLanguagePost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Language> languagesTemp=lanService.getAllLanguages();

		model.addAttribute("languages", languagesTemp);

		String languagename=req.getParameter("languageName");

		if(languagename==null) {

			model.addAttribute("error_msg", CommonData.RECORD_ERROR);
			return "addlanguage";
		}

		if(lanService.getByLanName(languagename)!=null) {

			model.addAttribute("error_msg", CommonData.RECORD_EXISTS);
			return "addlanguage";
		}

		String language_formatted = languagename.substring(0, 1).toUpperCase() + languagename.substring(1).toLowerCase();
		Language newLan=new Language();
		newLan.setLanId(lanService.getnewLanId());
		newLan.setLangName(language_formatted);
		newLan.setDateAdded(ServiceUtility.getCurrentTime());
		newLan.setUser(usr);

		Set<Language> languages=new HashSet<Language>();
		languages.add(newLan);

		try {
			userService.addUserToLanguage(usr, languages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "addlanguage";
		}


		model.addAttribute("success_msg", CommonData.RECORD_SAVE_SUCCESS_MSG);

		return "addlanguage";

	}

	/************************************END**********************************************/

	/************************************ADD TOPIC**********************************************/

	@RequestMapping(value = "/addTopic",method = RequestMethod.GET)
	public String addTopicGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Category> category = catService.findAll();

		model.addAttribute("categories", category);

		List<Topic> topics = topicService.findAll();

		model.addAttribute("topics", topics);

		return "addTopic";

	}

	@RequestMapping(value = "/addTopic",method = RequestMethod.POST)
	public String addTopicPost(Model model,Principal principal,
							   @RequestParam(name = "categoryName") int categoryId,
							   @RequestParam(name = "topicName") String topicName ) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Topic> topicsTemp = topicService.findAll();

		model.addAttribute("topics", topicsTemp);

		List<Category> category = catService.findAll();

		model.addAttribute("categories", category);

		Category cat =catService.findByid(categoryId);
		System.out.println(cat.getCatName());

		Topic topicTemp = topicService.findBytopicName(topicName);

		if(topicTemp!=null) {

			if(topicCatService.findAllByCategoryAndTopic(cat, topicTemp)==null) {

				TopicCategoryMapping localTopicMap=new TopicCategoryMapping(topicCatService.getNewId(), true, cat, topicTemp);
				topicCatService.save(localTopicMap);
				model.addAttribute("success_msg", CommonData.RECORD_SAVE_SUCCESS_MSG);
				return "addTopic";

			}else {

				model.addAttribute("error_msg", CommonData.RECORD_ERROR);
				return "addTopic";
			}
		}

		Topic local=new Topic();
		local.setTopicId(topicService.getNewTopicId());
		local.setTopicName(topicName);
		local.setDateAdded(ServiceUtility.getCurrentTime());
		local.setUser(usr);

		Set<Topic> topics=new HashSet<Topic>();
		topics.add(local);

		try {
			userService.addUserToTopic(usr, topics);
			TopicCategoryMapping localTopicMap=new TopicCategoryMapping(topicCatService.getNewId(), true, cat, local);
			topicCatService.save(localTopicMap);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "addTopic";
		}

		model.addAttribute("success_msg", CommonData.RECORD_SAVE_SUCCESS_MSG);
		return "addTopic";

	}

	/************************************END**********************************************/

	/************************************ADD ROLE**********************************************/

	@RequestMapping(value = "/addRole",method = RequestMethod.GET)
	public String addRoleGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Role> roles = roleService.findAll();

		model.addAttribute("roles", roles);

		return "addNewRole";

	}

	@RequestMapping(value = "/addRole",method = RequestMethod.POST)
	public String addRolePost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Role> roles = roleService.findAll();

		model.addAttribute("roles", roles);

		String roleName = req.getParameter("roleName");

		if(roleService.findByname(roleName)!=null) {

//			model.addAttribute("msg1", true);
			model.addAttribute("error_msg", CommonData.RECORD_EXISTS);
			return "addNewRole";
		}

		Role newRole=new Role();
		newRole.setRoleId(roleService.getNewRoleId());
		newRole.setName(roleName);

		try {
			roleService.save(newRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "addNewRole";
		}

		model.addAttribute("success_msg", CommonData.RECORD_SAVE_SUCCESS_MSG);
		return "addNewRole";

	}


	/************************************END**********************************************/

	/************************************ADD QUESTION**********************************************/

	@RequestMapping(value = "/uploadQuestion",method = RequestMethod.GET)
	public String addQuestionGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Question> questions = questService.findAll();
		model.addAttribute("questions", questions);

		List<Language> languages=lanService.getAllLanguages();

		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);

		model.addAttribute("languages", languages);

		return "uploadQuestion";


	}

	@RequestMapping(value = "/uploadQuestion",method = RequestMethod.POST)
	public String addQuestionPost(Model model,Principal principal,
								  @RequestParam("questionName") MultipartFile[] quesPdf,
								  @RequestParam(value = "categoryName") int categoryId,
								  @RequestParam(name = "inputTopicName") int topicId,
								  @RequestParam(name = "languageyName") int languageId) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Question> questionsTemp = questService.findAll();
		model.addAttribute("questions", questionsTemp);

		List<Language> languages=lanService.getAllLanguages();

		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);

		model.addAttribute("languages", languages);

		if(!ServiceUtility.checkFileExtensionPDF(quesPdf)) {  // throw error

			model.addAttribute("error_msg",CommonData.RECORD_ERROR);
			return "uploadQuestion";
		}

		Category cat=catService.findByid(categoryId);
		Topic topic=topicService.findById(topicId);
		TopicCategoryMapping topicCat=topicCatService.findAllByCategoryAndTopic(cat, topic);
		Language lan=lanService.getById(languageId);

		Question quesTemp = questService.getQuestionBasedOnTopicCatAndLan(topicCat, lan);

		if(quesTemp != null) {

			model.addAttribute("error_msg",CommonData.QUESTION_EXIST);
			return "uploadQuestion";
		}
		int newQuestionId=questService.getNewId();
		Question question=new Question();
		question.setQuestionId(newQuestionId);
		question.setDateAdded(ServiceUtility.getCurrentTime());
		question.setLan(lan);
		question.setQuestionPath("null");
		question.setTopicCatId(topicCat);
		question.setUser(usr);

		Set<Question> questions=new HashSet<Question>();
		questions.add(question);

		try {
			userService.addUserToQuestion(usr, questions);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error_msg",CommonData.RECORD_ERROR);
			return "uploadQuestion";
		}

		try {
			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryQuestion+newQuestionId)) {
				String pathtoUploadPoster=ServiceUtility.uploadFile(quesPdf, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryQuestion+newQuestionId);
				int indexToStart=pathtoUploadPoster.indexOf("Media");

				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

				Question temp=questService.findById(newQuestionId);

				temp.setQuestionPath(document);

				questService.save(temp);



			}else {

			}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("error_msg",CommonData.RECORD_ERROR);
			return "uploadQuestion";
		}

		model.addAttribute("success_msg",CommonData.RECORD_SAVE_SUCCESS_MSG);

		return "uploadQuestion";


	}


	/************************************END**********************************************/

	/************************************ADD CONSULTANT**********************************************/

	@RequestMapping(value = "/addConsultant",method = RequestMethod.GET)
	public String addConsultantGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Consultant> consultants = consultService.findAll();
		model.addAttribute("consultants", consultants);

		return "addConsultant";

	}

	@RequestMapping(value = "/addConsultant",method = RequestMethod.POST)
	public String addConsultantPost(Model model,Principal principal,
									@RequestParam("uploadConsaltantImage") MultipartFile[] file,
									@RequestParam("nameConsaltant") String name,
									@RequestParam("email") String email,
									@RequestParam(defaultValue = "false") String showOnHomePage) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Consultant> consultants = consultService.findAll();
		model.addAttribute("consultants", consultants);

		boolean show=false;

		if(showOnHomePage!=null) {
			show=showOnHomePage.equals("showOnHomePage");
		}

//		if(!ServiceUtility.checkFileExtensionImage(file)) {   // throw error extension file.
//
//			return "addConsultant";
//		}
		
		if(!ServiceUtility.checkEmailValidity(email)) {  // throw email wromng error
			
			return "addConsultant";
		}
		
		if (userService.findByUsername(email) != null) {
			model.addAttribute("emailExists", true);
			return "addConsultant";
		}

		if (userService.findByEmail(email) != null) {
			model.addAttribute("emailExists", true);
			return "addConsultant";
		}
		
		User userTemp = new User();
		userTemp.setId(userService.getNewId());
		userTemp.setEmail(email);
		userTemp.setUsername(email);
		userTemp.setDateAdded(ServiceUtility.getCurrentTime());
		
		userService.save(userTemp);
		

		int newConsultid=consultService.getNewConsultantId();
		Consultant local=new Consultant();
		local.setConsultantId(newConsultid);
		local.setDescription("null");
		local.setDateAdded(ServiceUtility.getCurrentTime());
		local.setName(name);
		local.setPosterPath("null");
		local.setUser(userTemp);
		local.setOnHome(show);

		Set<Consultant> consults=new HashSet<Consultant>();
		consults.add(local);

		try {
			userService.addUserToConsultant(usr, consults);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return "addConsultant";    // throw a error
		}

//		try {
//			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryConsultant+newConsultid)) {
//				String pathtoUploadPoster=ServiceUtility.uploadFile(file, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryConsultant+newConsultid);
//				int indexToStart=pathtoUploadPoster.indexOf("Media");
//
//				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
//
//				Consultant temp=consultService.findById(newConsultid);
//
//				temp.setPosterPath(document);
//
//				consultService.save(temp);
//
//			}else {      // throw a error
//
//			}
//
//		}catch (Exception e) {
//			// TODO: handle exception
//
//			e.printStackTrace();
//
//			return "addConsultant";    // throw a error
//		}

		model.addAttribute("msg",CommonData.RECORD_SAVE_SUCCESS_MSG);
		return "addConsultant";

	}

	/************************************END**********************************************/

	/************************************ADD EVENT**********************************************/
	@RequestMapping(value = "/addEvent",method = RequestMethod.GET)
	public String addEventGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Event> events = eventservice.findAll();
		model.addAttribute("events", events);

		return "addEvent";

	}

	@RequestMapping(value = "/addEvent",method = RequestMethod.POST)
	public String addEventPost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Event> eventsTemp = eventservice.findAll();
		model.addAttribute("events", eventsTemp);

		String eventName = req.getParameter("eventname");
		String desc = req.getParameter("description");
		String venueName = req.getParameter("venuename");
		String contactPerson = req.getParameter("contactperson");
		String contactNumber = req.getParameter("contactnumber");
		String email = req.getParameter("email");
		String startDateTemp=req.getParameter("date");
		String endDateTemp=req.getParameter("endDate");
		Date startDate;
		Date endDate;
		int newEventid;

		try {
			startDate=ServiceUtility.convertStringToDate(startDateTemp);
			endDate=ServiceUtility.convertStringToDate(endDateTemp);

			if(endDate.before(startDate)) {      // throws error if end date is previous to start date
				model.addAttribute("error_msg",CommonData.EVENT_CHECK_DATE);
				return "addEvent";
			}

			if(!ServiceUtility.checkEmailValidity(email)) { // throw error on wrong email
				model.addAttribute("error_msg",CommonData.EVENT_CHECK_EMAIL);
				return "addEvent";
			}

			if(contactNumber.length() != 10) {        // throw error on wrong phone number
				model.addAttribute("error_msg",CommonData.EVENT_CHECK_CONTACT);
				return "addEvent";
			}

			long contact=Long.parseLong(contactNumber);

			newEventid=eventservice.getNewEventId();
			Event event=new Event();
			event.setEventId(newEventid);
			event.setContactPerson(contactPerson);
			event.setDateAdded(ServiceUtility.getCurrentTime());
			event.setEmail(email);
			event.setDescription(desc);
			event.setEndDate(endDate);
			event.setStartDate(startDate);
			event.setUser(usr);
			event.setContactNumber(contact);
			event.setEventName(eventName);
			event.setLocation(venueName);

			Set<Event> events=new HashSet<Event>();
			events.add(event);

			userService.addUserToEvent(usr, events);


		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("error_msg",CommonData.RECORD_ERROR);
			e.printStackTrace();
			return "addEvent";
		}

		model.addAttribute("success_msg",CommonData.RECORD_SAVE_SUCCESS_MSG);
		return "addEvent";

	}


	/************************************END**********************************************/

	/************************************ADD TESTIMONIAL**********************************************/

	@RequestMapping(value = "/addTestimonial",method = RequestMethod.GET)
	public String addTestimonialGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Testimonial> testimonials = testService.findAll();
		model.addAttribute("testimonials", testimonials);

		return "addTestimonial";


	}

	@RequestMapping(value = "/addTestimonial",method = RequestMethod.POST)
	public String addTestimonialPost(Model model,Principal principal,
									@RequestParam("uploadTestimonial") MultipartFile file,
									@RequestParam("testimonialName") String name,
									@RequestParam("description") String desc) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Testimonial> testimonials = testService.findAll();
		model.addAttribute("testimonials", testimonials);

		if(!file.isEmpty()) {
		if(!ServiceUtility.checkFileExtensionVideo(file)) { // throw error on extension

			return "addTestimonial";
		}

		int newTestiId=testService.getNewTestimonialId();
		Testimonial test=new Testimonial();
		test.setDateAdded(ServiceUtility.getCurrentTime());
		test.setDescription(desc);
		test.setName(name);
		test.setUser(usr);
		test.setTestimonialId(newTestiId);
		test.setFilePath("null");

		Set<Testimonial> testi=new HashSet<Testimonial>();
		testi.add(test);

		try {
			userService.addUserToTestimonial(usr, testi);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "addTestimonial";
		}

		try {
			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTestimonial+newTestiId)) {
				String pathtoUploadPoster=ServiceUtility.uploadVideoFile(file, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTestimonial+newTestiId);
				int indexToStart=pathtoUploadPoster.indexOf("Media");

				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

				Testimonial temp=testService.findById(newTestiId);

				temp.setFilePath(document);

				testService.save(temp);

			}else {      // throw a error

			}

		}catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			return "addTestimonial";    // throw a error
		}
		}else {

			Testimonial test=new Testimonial();
			test.setDateAdded(ServiceUtility.getCurrentTime());
			test.setDescription(desc);
			test.setName(name);
			test.setUser(usr);
			test.setTestimonialId(testService.getNewTestimonialId());
			test.setFilePath("null");
			Set<Testimonial> testi=new HashSet<Testimonial>();
			testi.add(test);

			userService.addUserToTestimonial(usr, testi);
		}

		model.addAttribute("success_msg",CommonData.RECORD_SAVE_SUCCESS_MSG);
		return "addTestimonial";


	}

	/************************************END**********************************************/

	/************************************UPDATE SECTION AND VIEW OF CATEGORY**********************************************/

	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String viewCategoryGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Category> cat=catService.findAll();

		model.addAttribute("categories", cat);

		return "category";
	}

	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public String editCategoryGet(@PathVariable int id,Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Category cat=catService.findByid(id);

		model.addAttribute("category",cat);

		return "updateCategory";
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategoryGet(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		String catId=req.getParameter("id");
		String catName=req.getParameter("categoryname");

		Category cat=catService.findByid(Integer.parseInt(catId));

		if(cat==null) {
			 // accommodate  error message
			return "updateCategory";
		}

		List<Category> cats=catService.findAll();
		for(Category x : cats) {
			if(x.getCategoryId()!=cat.getCategoryId()) {
				if(catName.equalsIgnoreCase(x.getCatName())) {
					// accommodate  error message
					return "updateCategory";
				}
				}
		}

		cat.setCatName(catName);
		try {
			catService.save(cat);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// need to return some error message

			return "updateCategory";
		}

		model.addAttribute("msg",CommonData.RECORD_UPDATE_SUCCESS_MSG);   // need to accommodate

		return "updateCategory";
	}


	/************************************END**********************************************/

	/************************************UPDATE AND VIEW SECTION OF EVENT**********************************************/
	@RequestMapping(value = "/eventDetails/{id}", method = RequestMethod.GET)
	public String eventGet(@PathVariable int id,Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Event event= eventservice.findById(id);
		model.addAttribute("events", event);

		return "event";
	}

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String viewEventGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Event> event=eventservice.findAll();
		model.addAttribute("events", event);

		return "event";
	}

	@RequestMapping(value = "/event/edit/{id}", method = RequestMethod.GET)
	public String editEventGet(@PathVariable int id,Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Event event= eventservice.findById(id);
		model.addAttribute("events", event);

		return "updateEvent";
	}

	@RequestMapping(value = "/updateEvent", method = RequestMethod.POST)
	public String updateEventGet(HttpServletRequest req,Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		String eventId=req.getParameter("eventId");
		String eventName = req.getParameter("eventname");
		String desc = req.getParameter("description");
		String venueName = req.getParameter("venuename");
		String contactPerson = req.getParameter("contactperson");
		String contactNumber = req.getParameter("contactnumber");
		String email = req.getParameter("email");
		String startDateTemp=req.getParameter("date");
		String endDateTemp=req.getParameter("endDate");
		Date startDate;
		Date endDate;

		Event event= eventservice.findById(Integer.parseInt(eventId));

		if(event==null) {
			 // accommodate  error message
			return "updateEvent";
		}

		try {
			startDate=ServiceUtility.convertStringToDate(startDateTemp);
			endDate=ServiceUtility.convertStringToDate(endDateTemp);

			if(endDate.before(startDate)) {      // throws error if end date is previous to start date

				return "updateEvent";
			}

			if(!ServiceUtility.checkEmailValidity(email)) { // throw error on wrong email

				return "updateEvent";
			}

			if(contactNumber.length() != 10) {        // throw error on wrong phone number

				return "updateEvent";
			}

			if(!ServiceUtility.checkEmailValidity(email)) {    // throw error on wrong email

				return "updateEvent";
			}

			long contact=Long.parseLong(contactNumber);

			event.setContactPerson(contactPerson);
			event.setEmail(email);
			event.setDescription(desc);
			event.setEndDate(endDate);
			event.setStartDate(startDate);
			event.setContactNumber(contact);
			event.setEventName(eventName);
			event.setLocation(venueName);

			eventservice.save(event);

		}catch (Exception e) {
			// TODO: handle exception

			return "updateEvent";        // need to add some error message
		}


		model.addAttribute("msg",CommonData.RECORD_UPDATE_SUCCESS_MSG);

		return "updateEvent";
	}


	/************************************END**********************************************/

	/************************************VIEW SECTION OF LANGAUAGE**********************************************/

	@RequestMapping(value = "/language", method = RequestMethod.GET)
	public String viewLanguageGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Language> lan=lanService.getAllLanguages();
		model.addAttribute("lan", lan);

		return "language";
	}

	/************************************END**********************************************/

	/*********************************** VIEW SECTION OF DOMAIN REVIEWER ************************************/

	@RequestMapping(value = "/domainReviewer", method = RequestMethod.GET)
	public String viewDomaineGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Role domain=roleService.findByname(CommonData.domainReviewerRole);

		List<UserRole> domains = usrRoleService.findAllByRole(domain);

		model.addAttribute("domains", domains);

		return "viewDomainReviewer";
	}

	/************************************END**********************************************/

	/*********************************** VIEW SECTION OF QUALITY REVIEWER ************************************/

	@RequestMapping(value = "/qualityReviewer", method = RequestMethod.GET)
	public String viewQualityeGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		Role quality=roleService.findByname(CommonData.qualityReviewerRole);

		List<UserRole> qualities = usrRoleService.findAllByRole(quality);

		model.addAttribute("qualities", qualities);

		return "viewQualityReviewer";
	}

	/************************************END**********************************************/

	/*********************************** VIEW SECTION OF MASTER TRAINER ************************************/

	@RequestMapping(value = "/masterTrainer", method = RequestMethod.GET)
	public String viewMasterTrainerGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		Role master=roleService.findByname(CommonData.masterTrainerRole);

		List<UserRole> masters = usrRoleService.findAllByRole(master);
		model.addAttribute("masters", masters);

		return "viewMasterTrainer";
	}

	/************************************END**********************************************/

	/************************************UPDATE AND VIEW SECTION OF TESTIMONIAL**********************************************/

	@RequestMapping(value = "/testimonialList", method = RequestMethod.GET)
	public String viewtestimonialListGet(Model model,Principal principal) {

//		User usr=new User();
//
//		if(principal!=null) {
//
//			usr=userService.findByUsername(principal.getName());
//		}
//
//		model.addAttribute("userInfo", usr);
		List<Testimonial> test=testService.findAll();
		model.addAttribute("testimonials", test);

		return "testimonialList";
	}


	@RequestMapping(value = "/testimonial", method = RequestMethod.GET)
	public String viewtestimonialGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Testimonial> test=testService.findAll();
		model.addAttribute("testimonials", test);

		return "testimonial";
	}

	@RequestMapping(value = "/testimonial/edit/{id}", method = RequestMethod.GET)
	public String edittestimonialGet(@PathVariable int id,Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Testimonial test=testService.findById(id);

		model.addAttribute("testimonials", test);

		return "updateTestimonial";
	}

	@RequestMapping(value = "/updateTestimonial", method = RequestMethod.POST)
	public String updatetestimonialGet(HttpServletRequest req,Model model,Principal principal,@RequestParam("TestiVideo") MultipartFile file) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		String testiId=req.getParameter("testimonialId");
		String name=req.getParameter("testimonialName");
		String desc=req.getParameter("desc");

		Testimonial test=testService.findById(Integer.parseInt(testiId));

		if(test==null) {
			// accommodate error message

			return "updateTestimonial";
		}

		if(!file.isEmpty()) {
		try {

				String pathtoUploadPoster=ServiceUtility.uploadVideoFile(file, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryTestimonial+test.getTestimonialId());
				int indexToStart=pathtoUploadPoster.indexOf("Media");

				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
				test.setName(name);
				test.setDescription(desc);
				test.setFilePath(document);

				testService.save(test);


		}catch (Exception e) {
			// TODO: handle exception

			e.printStackTrace();

			return "updateTestimonial";    // throw a error
		}
		}else {

			test.setName(name);
			test.setDescription(desc);

			testService.save(test);
		}



		return "updateTestimonial";
	}


	/************************************END**********************************************/

	/************************************ROLE MANGAEMENT OPERATION**********************************************/

	@RequestMapping(value = "/addContributorRole", method = RequestMethod.GET)
	public String addContributorGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Language> languages=lanService.getAllLanguages();

		model.addAttribute("languages", languages);
		return "addContributorRole";
	}

	@RequestMapping(value = "/addContributorRole", method = RequestMethod.POST)
	public String addContributorPost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		String lanName=req.getParameter("selectedLan");

		Language lan=lanService.getByLanName(lanName);

		Role role=roleService.findByname(CommonData.contributorRole);
		List<UserRole> userRoles = usrRoleService.findByLanUser(lan, usr, role);
		if(!userRoles.isEmpty()) {
			System.out.println("***************IF True*****");
			System.out.println(usrRoleService.findByLanUser(lan, usr, role));

			// throw error
			//model.addAttribute("msgSuccefull", CommonData.ADMIN_ADDED_SUCCESS_MSG);
			List<Language> languages=lanService.getAllLanguages();
			List<Category> categories=catService.findAll();

			model.addAttribute("categories", categories);

			model.addAttribute("languages", languages);

			model.addAttribute("error_msg", CommonData.CONTRIBUTOR_ERROR);

			return "addContributorRole";
		}

		UserRole usrRole=new UserRole();
		usrRole.setCreated(ServiceUtility.getCurrentTime());
		usrRole.setUser(usr);
		usrRole.setRole(role);
		usrRole.setLanguage(lan);
		usrRole.setUserRoleId(usrRoleService.getNewUsrRoletId());

		try {
			usrRoleService.save(usrRole);
			model.addAttribute("success_msg", CommonData.CONTRIBUTOR_ADDED_SUCCESS_MSG);
		} catch (Exception e) {
			model.addAttribute("error_msg", CommonData.CONTRIBUTOR_ERROR_MSG);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Language> languages=lanService.getAllLanguages();

		model.addAttribute("languages", languages);

		return "addContributorRole";
	}

	@RequestMapping(value = "/addAdminRole", method = RequestMethod.GET)
	public String addAdminPost(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Language> languages=lanService.getAllLanguages();
		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);
		model.addAttribute("languages", languages);


		return "addAdminRole";
	}

	@RequestMapping(value = "/addAdminRole", method = RequestMethod.POST)
	public String addAdminPost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		String lanName=req.getParameter("selectedLan");
		String catName=req.getParameter("catSelected");

		Category cat=catService.findBycategoryname(catName);

		Language lan=lanService.getByLanName(lanName);

		Role role=roleService.findByname(CommonData.adminReviewerRole);

		if(usrRoleService.findByLanCatUser(lan, cat, usr, role)!=null) {

			// throw error
			//model.addAttribute("msgSuccefull", CommonData.ADMIN_ADDED_SUCCESS_MSG);
			List<Language> languages=lanService.getAllLanguages();
			List<Category> categories=catService.findAll();

			model.addAttribute("categories", categories);

			model.addAttribute("languages", languages);
			model.addAttribute("error_msg", CommonData.DUPLICATE_ROLE_ERROR);

			return "addAdminRole";
		}

		UserRole usrRole=new UserRole();
		usrRole.setCreated(ServiceUtility.getCurrentTime());
		usrRole.setUser(usr);
		usrRole.setRole(role);
		usrRole.setLanguage(lan);
		usrRole.setCategory(cat);
		usrRole.setUserRoleId(usrRoleService.getNewUsrRoletId());

		try {
			usrRoleService.save(usrRole);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error_msg", CommonData.ROLE_ERROR_MSG);
			e.printStackTrace();
												// accommodate error message
		}

		List<Language> languages=lanService.getAllLanguages();
		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);

		model.addAttribute("languages", languages);

		model.addAttribute("success_msg", CommonData.ADMIN_ADDED_SUCCESS_MSG);
		return "addAdminRole";
	}

	@RequestMapping(value = "/addQualityRole", method = RequestMethod.GET)
	public String addQualityGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Language> languages=lanService.getAllLanguages();
		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);

		model.addAttribute("languages", languages);

		return "addQualityRole";
	}

	@RequestMapping(value = "/addQualityRole", method = RequestMethod.POST)
	public String addQualityPost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		String lanName=req.getParameter("selectedLan");
		String catName=req.getParameter("catSelected");

		Category cat=catService.findBycategoryname(catName);

		Language lan=lanService.getByLanName(lanName);
		Role role=roleService.findByname(CommonData.qualityReviewerRole);

		if(usrRoleService.findByLanCatUser(lan, cat, usr, role)!=null) {

			// throw error
			//model.addAttribute("msgSuccefull", CommonData.ADMIN_ADDED_SUCCESS_MSG);
			List<Language> languages=lanService.getAllLanguages();
			List<Category> categories=catService.findAll();

			model.addAttribute("categories", categories);

			model.addAttribute("languages", languages);
			model.addAttribute("error_msg", CommonData.DUPLICATE_ROLE_ERROR);

			return "addQualityRole";
		}

		UserRole usrRole=new UserRole();
		usrRole.setCreated(ServiceUtility.getCurrentTime());
		usrRole.setUser(usr);
		usrRole.setRole(role);
		usrRole.setCategory(cat);
		usrRole.setLanguage(lan);
		usrRole.setUserRoleId(usrRoleService.getNewUsrRoletId());

		try {
			usrRoleService.save(usrRole);
			model.addAttribute("success_msg", CommonData.QUALITY_ADDED_SUCCESS_MSG);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error_msg", CommonData.ROLE_REQUEST_ERROR);
			e.printStackTrace();
												// accommodate error message
		}

		List<Language> languages=lanService.getAllLanguages();
		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);

		model.addAttribute("languages", languages);

		return "addQualityRole";
	}

	@RequestMapping(value = "/addMasterTrainerRole", method = RequestMethod.GET)
	public String addMasterTrainerGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
//			model.addAttribute("success_msg", "Error in requesting role");
		}

		model.addAttribute("userInfo", usr);
//		model.addAttribute("success_msg", "Request submitted for master trainer role");

		return "addMasterTrainerRole";
	}

	@RequestMapping(value = "/addMasterTrainerRole", method = RequestMethod.POST)
	public String addMasterTrainerPost(Model model,Principal principal,HttpServletRequest req) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String mobileNumber=req.getParameter("phone");
		String address=req.getParameter("address");
		String organization=(req.getParameter("org"));
		String exp=req.getParameter("experience");
		String aadhar=req.getParameter("aadharNumber");

		if(aadhar.length()!=12) {
			 // throw error
			model.addAttribute("error_msg", "Invalid aadhar number");
			return "addMasterTrainerRole";
		}

		if(mobileNumber.length()!=10) {

			// throw error
			model.addAttribute("error_msg", "Invalid phone number");
			return "addMasterTrainerRole";
		}

		Role role=roleService.findByname(CommonData.masterTrainerRole);

		List<UserRole> userRoles = usrRoleService.findByRoleUser(usr, role);
		if(!userRoles.isEmpty()) {
			// throw error
			model.addAttribute("error_msg", "Error in submitting request");
			return "addMasterTrainerRole";
		}

		usr.setAadharNumber(Long.parseLong(aadhar));
		usr.setExperience(Integer.parseInt(exp));
		usr.setAddress(address);
		usr.setFirstName(name);
		usr.setOrganization(organization);
		usr.setAge(Integer.parseInt(age));
		usr.setPhone(Long.parseLong(mobileNumber));

		try {

			userService.save(usr);

			UserRole usrRole=new UserRole();
			usrRole.setCreated(ServiceUtility.getCurrentTime());
			usrRole.setUser(usr);
			usrRole.setRole(role);
			usrRole.setUserRoleId(usrRoleService.getNewUsrRoletId());

			usrRoleService.save(usrRole);
//			model.addAttribute("msgSuccefull", CommonData.MASTER_TRAINER_ADDED_SUCCESS_MSG);
//			model.addAttribute("success_msg", "Request submitted for role successfully");

		}catch (Exception e) {
			// TODO: handle exception
//			model.addAttribute("userInfo", usr);
			model.addAttribute("error_msg", "Error in submitting request");
			// throw error
		}
		model.addAttribute("userInfo", usr);
		model.addAttribute("success_msg", "Request submitted for role successfully");
		return "addMasterTrainerRole";
	}


	/************************************END****************************************************************/

	/*********************************** Approve Role ************************************************/

	@RequestMapping(value = "/approveRole", method = RequestMethod.GET)
	public String approveRoleGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Role contributor=roleService.findByname(CommonData.contributorRole);
		Role admin=roleService.findByname(CommonData.adminReviewerRole);
		Role master=roleService.findByname(CommonData.masterTrainerRole);
		Role quality=roleService.findByname(CommonData.qualityReviewerRole);

		List<UserRole> adminReviewer = usrRoleService.findAllByRoleAndStatus(admin,false);
		List<UserRole> masterTrainer = usrRoleService.findAllByRoleAndStatus(master,false);
		List<UserRole> qualityReviewer = usrRoleService.findAllByRoleAndStatus(quality,false);
		List<UserRole> contributorReviewer = usrRoleService.findAllByRoleAndStatus(contributor,false);

		model.addAttribute("userInfoAdmin", adminReviewer);
		model.addAttribute("userInfoQuality", qualityReviewer);
		model.addAttribute("userInfoContributor", contributorReviewer);
		model.addAttribute("userInfoMaster", masterTrainer);


		return "approveRole";
	}




	/******************************************END **************************************************/


	/*************************************** ASSIGN CONTRINUTOR ****************************************/

	@RequestMapping(value = "/assignTutorialToContributor", method = RequestMethod.GET)
	public String assignTutorialToContributoreGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Role role=roleService.findByname(CommonData.contributorRole);

		List<UserRole> userRoles= usrRoleService.findAllByRoleAndStatus(role, true);

		model.addAttribute("userByContributors", userRoles);

		return "assignContributorList";
	}

	@RequestMapping(value = "/assignTutorialToContributor", method = RequestMethod.POST)
	public String assignTutorialToContributorePost(Model model,Principal principal,
												@RequestParam(name = "contributorName") String contributorName,
												@RequestParam(name = "languageName") String lanName,
												@RequestParam(name = "contributorCategory") String catName,
												@RequestParam(name = "inputTopic") String[] topics) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Role role=roleService.findByname(CommonData.contributorRole);

		List<UserRole> userRoles= usrRoleService.findAllByRoleAndStatus(role, true);

		model.addAttribute("userByContributors", userRoles);

		System.out.println(catName);

		Language lan=lanService.getByLanName(lanName);
		Category cat=catService.findByid(Integer.parseInt(catName));
		User userAssigned=userService.findByUsername(contributorName);
		Set<ContributorAssignedTutorial> conTutorials=new HashSet<ContributorAssignedTutorial>();
		int conNewId=conRepo.getNewId();

		for(String topic:topics) {

			Topic localtopic=topicService.findById(Integer.parseInt(topic));
			if(localtopic != null) {

				TopicCategoryMapping topicCat=topicCatService.findAllByCategoryAndTopic(cat, localtopic);

				System.out.println(topicCat.getTopicCategoryId());
				ContributorAssignedTutorial x=conRepo.findByTopicCatAndLanViewPart(topicCat, lan);

				if(x == null) {

					ContributorAssignedTutorial temp=new ContributorAssignedTutorial(conNewId++, ServiceUtility.getCurrentTime(), userAssigned, topicCat, lan);
					conTutorials.add(temp);

				}else {
					// throw error for repeated task
					model.addAttribute("error_msg", CommonData.CONTRIBUTOR_ERROR_MSG);
					return "assignContributorList";
				}



			}else {
				// throw error as topic doesn't exist
				model.addAttribute("error_msg", CommonData.CONTRIBUTOR_TOPIC_ERROR);
				return "assignContributorList";
			}
		}


		userService.addUserToContributorTutorial(userAssigned, conTutorials);

		model.addAttribute("success_msg", CommonData.CONTRIBUTOR_ASSIGNED_TUTORIAL);

		return "assignContributorList";
	}




	/********************************************END*************************************************/


	/*********************************** CONTRIBUTOR ROLE OPERATION *************************************/
	@RequestMapping(value = "/uploadTutorial", method = RequestMethod.GET)
	public String uploadTutorialGet(Model model,Principal principal) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<String> catName = new ArrayList<String>();
		List<ContributorAssignedTutorial> con=conRepo.findAllByUser(usr);

		for(ContributorAssignedTutorial temp:con) {
			catName.add(temp.getTopicCatId().getCat().getCatName());

		}
		HashSet<String> uniqueCatName=new HashSet<String>(catName);    // to return unique value


		model.addAttribute("contributorTutorial", uniqueCatName);
		return "uploadTutorialPre";
	}


	@RequestMapping(value = "/uploadTutorial", method = RequestMethod.POST)
	public String uploadTutorialPost(Model model,Principal principal,
										@RequestParam(value="categoryName") String categoryName,
										@RequestParam(name="inputTopic") int topicId,
										@RequestParam(name="inputLanguage") String langName) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Category> categories = catService.findAll();
		Category cat=catService.findBycategoryname(categoryName);
		Topic topic=topicService.findById(topicId);
		Language lan=lanService.getByLanName(langName);
		TopicCategoryMapping topicCat=topicCatService.findAllByCategoryAndTopic(cat, topic);
		ContributorAssignedTutorial conTutorial=conRepo.findByUserTopicCatLan(usr, topicCat, lan);
		List<Tutorial> tutorials=tutService.findAllByContributorAssignedTutorial(conTutorial);

		if(tutorials.isEmpty()) {

			model.addAttribute("statusOutline", CommonData.ADD_CONTENT);
			model.addAttribute("statusScript", CommonData.ADD_CONTENT);
			model.addAttribute("statusSlide", CommonData.ADD_CONTENT);
			model.addAttribute("statusVideo", CommonData.ADD_CONTENT);
			model.addAttribute("statusKeyword", CommonData.ADD_CONTENT);
			model.addAttribute("statusPreReq", CommonData.ADD_CONTENT);
			model.addAttribute("statusGraphics", CommonData.ADD_CONTENT);
			model.addAttribute("tutorial", null);
		}else {

			for(Tutorial local:tutorials) {

				model.addAttribute("statusOutline", CommonData.tutorialStatus[local.getOutlineStatus()]);
				model.addAttribute("statusScript", CommonData.tutorialStatus[local.getScriptStatus()]);
				model.addAttribute("statusSlide", CommonData.tutorialStatus[local.getSlideStatus()]);
				model.addAttribute("statusVideo", CommonData.tutorialStatus[local.getVideoStatus()]);
				model.addAttribute("statusKeyword", CommonData.tutorialStatus[local.getKeywordStatus()]);
				model.addAttribute("statusPreReq", CommonData.tutorialStatus[local.getPreRequisticStatus()]);
				model.addAttribute("statusGraphics", CommonData.tutorialStatus[local.getGraphicsStatus()]);
				model.addAttribute("tutorial", local);

				List<Comment> comVideo = comService.getCommentBasedOnTutorialType(CommonData.VIDEO, local);
				List<Comment> comScript = comService.getCommentBasedOnTutorialType(CommonData.SCRIPT, local);
				List<Comment> comSlide = comService.getCommentBasedOnTutorialType(CommonData.SLIDE, local);
				List<Comment> comGraphics = comService.getCommentBasedOnTutorialType(CommonData.GRAPHICS, local);
				List<Comment> comKeyword = comService.getCommentBasedOnTutorialType(CommonData.KEYWORD, local);
				List<Comment> comPreRequistic = comService.getCommentBasedOnTutorialType(CommonData.PRE_REQUISTIC, local);
				List<Comment> comOutline = comService.getCommentBasedOnTutorialType(CommonData.OUTLINE, local);

				model.addAttribute("comOutline", comOutline);
				model.addAttribute("comScript",comScript );
				model.addAttribute("comSlide",comSlide );
				model.addAttribute("comVideo", comVideo);
				model.addAttribute("comKeyword", comKeyword);
				model.addAttribute("comPreReq", comPreRequistic);
				model.addAttribute("comGraphics",comGraphics );
			}
		}

		model.addAttribute("category", cat);
		model.addAttribute("topic", topic);
		model.addAttribute("language", lan);
		model.addAttribute("categories", categories);
		return "uploadTutorialPost";
	}



	/****************************************END********************************************************/

/********************************** operation at Admin End *****************************************/
	@RequestMapping(value = "listTutorialForAdminReview", method = RequestMethod.GET)
	public String listAdminReviewTutorialGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Tutorial> toReview = new ArrayList<>();
		List<Tutorial> reviewed = new ArrayList<>();
		Role role=roleService.findByname(CommonData.adminReviewerRole);

		List<UserRole> userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategoryBasedOnUserRoles(userRoles);

		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles);

		List<Tutorial> tutorials =  tutService.findAllByContributorAssignedTutorialList(conTutorials);
		for(Tutorial temp:tutorials) {

			if(temp.getVideoStatus() == CommonData.ADMIN_STATUS) {
				toReview.add(temp);
			}else if(temp.getVideoStatus() > CommonData.ADMIN_STATUS) {
				reviewed.add(temp);
			}
		}

		model.addAttribute("tutorialToReview", toReview);
		model.addAttribute("tutorialReviewed", reviewed);
		return "listTutorialAdminReviwer";



	}

	@RequestMapping(value = "adminreview/review/{id}", method = RequestMethod.GET)
	public String listAdminReviewTutorialGet(@PathVariable int id,Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		Tutorial tutorial=tutService.getById(id);

		if(tutorial.getVideoStatus() != CommonData.ADMIN_STATUS) {
			 // return some error

		}

		if(tutorial == null) {
			// throw a error
			model.addAttribute("error_msg", CommonData.STATUS_ERROR);
			model.addAttribute("tutorialNotExist", "Bad request");   //  throw proper error
			return "listTutorialAdminReviwer";

		}

		List<Comment> comVideo = comService.getCommentBasedOnUserTutorialType(CommonData.VIDEO, usr, tutorial,CommonData.adminReviewerRole);

		model.addAttribute("comVideo", comVideo);


		model.addAttribute("category", tutorial.getConAssignedTutorial().getTopicCatId().getCat().getCatName());
		model.addAttribute("topic", tutorial.getConAssignedTutorial().getTopicCatId().getTopic().getTopicName());
		model.addAttribute("language", tutorial.getConAssignedTutorial().getLan().getLangName());
		model.addAttribute("tutorial", tutorial);

		model.addAttribute("success_msg", CommonData.Video_STATUS_SUCCESS_MSG);
		return "addContentAdminReview";



	}



	/***********************************END ***************************************************************/

	/*************************** OPERATION AT DOMAIN REVIEWER END ***********************************/
	@RequestMapping(value = "listTutorialForDomainReview", method = RequestMethod.GET)
	public String listDomainReviewTutorialGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Tutorial> toReview = new ArrayList<>();
		List<Tutorial> published = new ArrayList<>();
		Role role=roleService.findByname(CommonData.domainReviewerRole);

		List<UserRole> userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategoryBasedOnUserRoles(userRoles);

		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles);

		List<Tutorial> tutorials =  tutService.findAllByContributorAssignedTutorialList(conTutorials);
		for(Tutorial temp:tutorials) {

			if(temp.getOutlineStatus() == CommonData.PUBLISH_STATUS && temp.getScriptStatus() == CommonData.PUBLISH_STATUS &&
					temp.getSlideStatus() == CommonData.PUBLISH_STATUS && temp.getKeywordStatus() == CommonData.PUBLISH_STATUS &&
					temp.getVideoStatus() == CommonData.PUBLISH_STATUS && temp.getGraphicsStatus() == CommonData.PUBLISH_STATUS &&
					temp.getPreRequisticStatus() == CommonData.PUBLISH_STATUS) {

				published.add(temp);
			}else {
				toReview.add(temp);
			}

		}

		model.addAttribute("tutorialToReview", toReview);
		model.addAttribute("tutorialReviewed", published);
		return "listTutorialDomainReviewer";
	}

	@RequestMapping(value = "domainreview/review/{id}", method = RequestMethod.GET)
	public String listDomainReviewTutorialGet(@PathVariable int id,Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		Tutorial tutorial=tutService.getById(id);

		if(tutorial.getVideoStatus() != CommonData.DOMAIN_STATUS) {
			 // return some error

		}

		if(tutorial == null) {
			// throw a error
			model.addAttribute("tutorialNotExist", "Bad request");   //  throw proper error
			return "listTutorialAdminReviwer";

		}

		List<Comment> comVideo = comService.getCommentBasedOnUserTutorialType(CommonData.VIDEO, usr, tutorial,CommonData.domainReviewerRole);
		List<Comment> comScript = comService.getCommentBasedOnUserTutorialType(CommonData.SCRIPT, usr, tutorial,CommonData.domainReviewerRole);
		List<Comment> comSlide = comService.getCommentBasedOnUserTutorialType(CommonData.SLIDE, usr, tutorial,CommonData.domainReviewerRole);
		List<Comment> comGraphics = comService.getCommentBasedOnUserTutorialType(CommonData.GRAPHICS, usr, tutorial,CommonData.domainReviewerRole);
		List<Comment> comKeyword = comService.getCommentBasedOnUserTutorialType(CommonData.KEYWORD, usr, tutorial,CommonData.domainReviewerRole);
		List<Comment> comPreRequistic = comService.getCommentBasedOnUserTutorialType(CommonData.PRE_REQUISTIC, usr, tutorial,CommonData.domainReviewerRole);
		List<Comment> comOutline = comService.getCommentBasedOnUserTutorialType(CommonData.OUTLINE, usr, tutorial,CommonData.domainReviewerRole);

		model.addAttribute("comOutline", comOutline);
		model.addAttribute("comScript",comScript );
		model.addAttribute("comSlide",comSlide );
		model.addAttribute("comVideo", comVideo);
		model.addAttribute("comKeyword", comKeyword);
		model.addAttribute("comPreReq", comPreRequistic);
		model.addAttribute("comGraphics",comGraphics );

		model.addAttribute("statusOutline", CommonData.tutorialStatus[tutorial.getOutlineStatus()]);
		model.addAttribute("statusScript", CommonData.tutorialStatus[tutorial.getScriptStatus()]);
		model.addAttribute("statusSlide", CommonData.tutorialStatus[tutorial.getSlideStatus()]);
		model.addAttribute("statusVideo", CommonData.tutorialStatus[tutorial.getVideoStatus()]);
		model.addAttribute("statusKeyword", CommonData.tutorialStatus[tutorial.getKeywordStatus()]);
		model.addAttribute("statusPreReq", CommonData.tutorialStatus[tutorial.getPreRequisticStatus()]);
		model.addAttribute("statusGraphics", CommonData.tutorialStatus[tutorial.getGraphicsStatus()]);
		model.addAttribute("tutorial", tutorial);

		model.addAttribute("category", tutorial.getConAssignedTutorial().getTopicCatId().getCat().getCatName());
		model.addAttribute("topic", tutorial.getConAssignedTutorial().getTopicCatId().getTopic().getTopicName());
		model.addAttribute("language", tutorial.getConAssignedTutorial().getLan().getLangName());

		return "addContentDomainReview";



	}

	/*********************************** END *******************************************************/

	/*************************** OPERATION AT QUALITY REVIEWER END ***********************************/

	@RequestMapping(value = "listTutorialForQualityReview", method = RequestMethod.GET)
	public String listQualityReviewTutorialGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Tutorial> toReview = new ArrayList<>();
		List<Tutorial> published = new ArrayList<>();
		Role role=roleService.findByname(CommonData.qualityReviewerRole);

		List<UserRole> userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategoryBasedOnUserRoles(userRoles);

		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles);

		List<Tutorial> tutorials =  tutService.findAllByContributorAssignedTutorialList(conTutorials);
		for(Tutorial temp:tutorials) {

			if(temp.getOutlineStatus() == CommonData.PUBLISH_STATUS && temp.getScriptStatus() == CommonData.PUBLISH_STATUS &&
					temp.getSlideStatus() == CommonData.PUBLISH_STATUS && temp.getKeywordStatus() == CommonData.PUBLISH_STATUS &&
					temp.getVideoStatus() == CommonData.PUBLISH_STATUS && temp.getGraphicsStatus() == CommonData.PUBLISH_STATUS &&
					temp.getPreRequisticStatus() == CommonData.PUBLISH_STATUS) {

				published.add(temp);
			}else {
				toReview.add(temp);
			}

		}

		model.addAttribute("tutorialToReview", toReview);
		model.addAttribute("tutorialReviewed", published);

		return "listTutorialQualityReviewer";


	}

	@RequestMapping(value = "tutorialToPublish", method = RequestMethod.GET)
	public String tutorialToPublishGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Tutorial> published = new ArrayList<>();
		Role role=roleService.findByname(CommonData.qualityReviewerRole);

		List<UserRole> userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategoryBasedOnUserRoles(userRoles);

		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles);

		List<Tutorial> tutorials =  tutService.findAllByContributorAssignedTutorialList(conTutorials);
		for(Tutorial temp:tutorials) {

			if(temp.getOutlineStatus() >= CommonData.WAITING_PUBLISH_STATUS && temp.getScriptStatus() >= CommonData.WAITING_PUBLISH_STATUS &&
					temp.getSlideStatus() >= CommonData.WAITING_PUBLISH_STATUS && temp.getKeywordStatus() >= CommonData.WAITING_PUBLISH_STATUS &&
					temp.getVideoStatus() >= CommonData.WAITING_PUBLISH_STATUS && temp.getGraphicsStatus() >= CommonData.WAITING_PUBLISH_STATUS &&
					temp.getPreRequisticStatus() >= CommonData.WAITING_PUBLISH_STATUS) {

				published.add(temp);
			}

		}

		model.addAttribute("tutorial", published);

		return "listTutorialPublishQualityReviwer";


	}

	@RequestMapping(value = "publish/{id}", method = RequestMethod.GET)
	public String publishTutorialGet(@PathVariable int id,Model model,Principal principal,RedirectAttributes redirectAttributes) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		Tutorial tutorial=tutService.getById(id);

		if(tutorial == null) {
			// throw a error
			model.addAttribute("tutorialNotExist", "Bad request");   //  throw proper error
			return "redirect:/tutorialToPublish";

		}

		tutorial.setKeywordStatus(CommonData.PUBLISH_STATUS);
		tutorial.setOutlineStatus(CommonData.PUBLISH_STATUS);
		tutorial.setSlideStatus(CommonData.PUBLISH_STATUS);
		tutorial.setScriptStatus(CommonData.PUBLISH_STATUS);
		tutorial.setGraphicsStatus(CommonData.PUBLISH_STATUS);
		tutorial.setPreRequisticStatus(CommonData.PUBLISH_STATUS);
		tutorial.setVideoStatus(CommonData.PUBLISH_STATUS);
		tutorial.setStatus(true);

		tutService.save(tutorial);
		model.addAttribute("success_msg", CommonData.PUBLISHED_SUCCESS);
		model.addAttribute("success_msg", "as");
		redirectAttributes.addAttribute("success_msg", "rdValue");


		return "redirect:/tutorialToPublish";
	}

	@RequestMapping(value = "qualityreview/review/{id}", method = RequestMethod.GET)
	public String listQualityReviewTutorialGet(@PathVariable int id,Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		Tutorial tutorial=tutService.getById(id);

		if(tutorial.getVideoStatus() != CommonData.QUALITY_STATUS) {
			 // return some error

		}

		if(tutorial == null) {
			// throw a error
			model.addAttribute("tutorialNotExist", "Bad request");   //  throw proper error
			return "listTutorialAdminReviwer";

		}

		List<Comment> comVideo = comService.getCommentBasedOnUserTutorialType(CommonData.VIDEO, usr, tutorial,CommonData.qualityReviewerRole);
		List<Comment> comScript = comService.getCommentBasedOnUserTutorialType(CommonData.SCRIPT, usr, tutorial,CommonData.qualityReviewerRole);
		List<Comment> comSlide = comService.getCommentBasedOnUserTutorialType(CommonData.SLIDE, usr, tutorial,CommonData.qualityReviewerRole);
		List<Comment> comGraphics = comService.getCommentBasedOnUserTutorialType(CommonData.GRAPHICS, usr, tutorial,CommonData.qualityReviewerRole);
		List<Comment> comKeyword = comService.getCommentBasedOnUserTutorialType(CommonData.KEYWORD, usr, tutorial,CommonData.qualityReviewerRole);
		List<Comment> comPreRequistic = comService.getCommentBasedOnUserTutorialType(CommonData.PRE_REQUISTIC, usr, tutorial,CommonData.qualityReviewerRole);
		List<Comment> comOutline = comService.getCommentBasedOnUserTutorialType(CommonData.OUTLINE, usr, tutorial,CommonData.qualityReviewerRole);

		model.addAttribute("comOutline", comOutline);
		model.addAttribute("comScript",comScript );
		System.out.println(comScript+"********************");
		model.addAttribute("comSlide",comSlide );
		model.addAttribute("comVideo", comVideo);
		model.addAttribute("comKeyword", comKeyword);
		model.addAttribute("comPreReq", comPreRequistic);
		model.addAttribute("comGraphics",comGraphics );

		model.addAttribute("statusOutline", CommonData.tutorialStatus[tutorial.getOutlineStatus()]);
		model.addAttribute("statusScript", CommonData.tutorialStatus[tutorial.getScriptStatus()]);
		model.addAttribute("statusSlide", CommonData.tutorialStatus[tutorial.getSlideStatus()]);
		model.addAttribute("statusVideo", CommonData.tutorialStatus[tutorial.getVideoStatus()]);
		model.addAttribute("statusKeyword", CommonData.tutorialStatus[tutorial.getKeywordStatus()]);
		model.addAttribute("statusPreReq", CommonData.tutorialStatus[tutorial.getPreRequisticStatus()]);
		model.addAttribute("statusGraphics", CommonData.tutorialStatus[tutorial.getGraphicsStatus()]);
		model.addAttribute("tutorial", tutorial);

		model.addAttribute("category", tutorial.getConAssignedTutorial().getTopicCatId().getCat().getCatName());
		model.addAttribute("topic", tutorial.getConAssignedTutorial().getTopicCatId().getTopic().getTopicName());
		model.addAttribute("language", tutorial.getConAssignedTutorial().getLan().getLangName());

		return "addContentQualityReview";



	}

	/*********************************** END *******************************************************/

	/************************* OPERATION AT MASTER TRAINER ******************************************/

	@RequestMapping(value = "/trainerProfile", method = RequestMethod.GET)
	public String profileMasterTrainerGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		return "traineeView";



	}

	@RequestMapping(value = "/masterTrainerOperation", method = RequestMethod.GET)
	public String MasterTrainerGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		List<Category> cat=catService.findAll();

		List<State> states=stateService.findAll();

		List<Language> lan=lanService.getAllLanguages();

		model.addAttribute("categories", cat);

		model.addAttribute("states", states);
		model.addAttribute("lans", lan);

		return "masterTrainerOperation";

	}

	@RequestMapping(value = "/downloadQuestion", method = RequestMethod.POST)
	public String downloadQuestionPost(Model model,Principal principal,
										@RequestParam(value="catMasterId") int catName,
										@RequestParam(value="lanMasterTrId") int topicId,
										@RequestParam(value="dwnByLanguageId") String lanName) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Category cat=catService.findByid(catName);
		Topic topic=topicService.findById(topicId);
		TopicCategoryMapping topicCat=topicCatService.findAllByCategoryAndTopic(cat, topic);
		Language lan = lanService.getByLanName(lanName);
		Question questions = questService.getQuestionBasedOnTopicCatAndLan(topicCat, lan);
		model.addAttribute("Questions", questions);

		List<Category> cats=catService.findAll();

		List<State> states=stateService.findAll();

		List<Language> lans=lanService.getAllLanguages();

		model.addAttribute("categories", cats);

		model.addAttribute("states", states);
		model.addAttribute("lans", lans);
		model.addAttribute("question", "question");

		return "masterTrainerOperation";

	}

	@RequestMapping(value = "/viewTrainee", method = RequestMethod.GET)
	public String downloadQuestionPost(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<TraineeInformation> trainees = traineeService.findAll();
		List<Category> categories=catService.findAll();

		model.addAttribute("TraineesData", trainees);
		model.addAttribute("categories", categories);

		return "traineeView";

	}


	@RequestMapping(value = "/addTrainingInfo", method = RequestMethod.POST)
	public String addTrainingInfoPost(Model model,Principal principal,
			@RequestParam("ParticipantsPhoto") MultipartFile[] trainingImage,
			@RequestParam("traineeInformation") MultipartFile traineeInfo,
			@RequestParam(value="categoryName") int catName,
			@RequestParam(value="inputTopic") int[] topicId,
			@RequestParam(value="language") String lanName,
			@RequestParam(value="date") String startDate,
			@RequestParam(value="endDate") String endDate,
			@RequestParam(value="stateName") int state,
			@RequestParam(value="districtName") int district,
			@RequestParam(value="cityName") int city,
			@RequestParam(value="traningInfo") String trainingInformation,
			@RequestParam(value = "totalPar") int totaltrainee,
			@RequestParam(value="addressInformationName") String address,
			@RequestParam(value="pinCode") int pinCode,
			@RequestParam(value="titleName") String titleName) {

		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);

		Set<TrainingTopic> trainingTopicTemp = new HashSet<>();

		if(!ServiceUtility.checkFileExtensiononeFileCSV(traineeInfo)) {

			// throw error on output
			model.addAttribute("error_msg",CommonData.CSV_ERROR);
			return "masterTrainerOperation";
		}

		if(!ServiceUtility.checkFileExtensionZip(trainingImage)) {

			// throw error on output
			model.addAttribute("error_msg",CommonData.ZIP_ERROR);
			return "masterTrainerOperation";
		}

		if(trainingInfoService.findByTopicName(titleName) != null) {

			// throw error on output
			model.addAttribute("error_msg",CommonData.NAME_ERROR);
			return "masterTrainerOperation";
		}

		Date startDate1 =null;
		Date endDate1 = null;
		try {
			startDate1 = ServiceUtility.convertStringToDate(startDate);
			endDate1 = ServiceUtility.convertStringToDate(endDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			// throw error
			model.addAttribute("error_msg",CommonData.EVENT_ERROR);
			return "masterTrainerOperation";
		}

		if(endDate1.before(startDate1)) {      // throws error if end date is previous to start date
			model.addAttribute("error_msg",CommonData.EVENT_CHECK_DATE);
			return "masterTrainerOperation";
		}

		State stat=stateService.findById(state);
		District districtTemp=districtService.findById(district);
		City cityTemp=cityService.findById(city);
		Language lan=lanService.getByLanName(lanName);
		Category cat=catService.findByid(catName);

//		Topic topic=topicService.findById(topicId);
//		TopicCategoryMapping topicCatMap=topicCatService.findAllByCategoryAndTopic(cat, topic);

		int newTrainingdata=trainingInfoService.getNewId();
		TrainingInformation trainingData=new TrainingInformation();
		trainingData.setCity(cityTemp);
		trainingData.setDateAdded(ServiceUtility.getCurrentTime());
		trainingData.setState(stat);
		trainingData.setDistrict(districtTemp);
		trainingData.setTrainingId(newTrainingdata);
		trainingData.setTitleName(titleName);
		trainingData.setTotalParticipant(totaltrainee);
		try {
			trainingData.setStartDate(ServiceUtility.convertStringToDate(startDate));
			trainingData.setEnddate(ServiceUtility.convertStringToDate(endDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			model.addAttribute("error_msg",CommonData.EVENT_ERROR);
			e.printStackTrace();
			//  return error for ill formatted error
			return "masterTrainerOperation";
		}

		trainingData.setPincode(pinCode);
		trainingData.setLan(lan);
		trainingData.setAddress(address);
		trainingData.setUser(usr);

		try {
			trainingInfoService.save(trainingData);
			int trainingTopicId=trainingTopicServ.getNewId();
			for(int topicID : topicId) {
				Topic topicTemp=topicService.findById(topicID);
				TopicCategoryMapping topicCatMap=topicCatService.findAllByCategoryAndTopic(cat, topicTemp);
				TrainingTopic trainingTemp=new TrainingTopic(trainingTopicId++, topicCatMap, trainingData);
				trainingTopicTemp.add(trainingTemp);

			}

			trainingData.setTrainingTopicId(trainingTopicTemp);
			trainingInfoService.save(trainingData);

			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryMasterTrainer+newTrainingdata)) {
				String pathtoUploadPoster=ServiceUtility.uploadFile(trainingImage, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryMasterTrainer+newTrainingdata);
				int indexToStart=pathtoUploadPoster.indexOf("Media");

				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

				trainingData.setPosterPath(document);

				byte[] bytes = traineeInfo.getBytes();
	            String completeData = new String(bytes);
	            System.out.println(completeData);
	            String[] rows = completeData.split("\n");
	            System.out.println("data"+rows.length);

	            Set<TraineeInformation> trainees=new HashSet<TraineeInformation>();
	            int newTraineeId=traineeService.getNewId();
	   
	            for(int i=0;i<rows.length;i++) {
	            	String[] columns = rows[i].split(",");
	            	TraineeInformation temp=new TraineeInformation(newTraineeId++, columns[0], columns[1], Long.parseLong(columns[2]),Integer.parseInt(columns[3]), Long.parseLong(columns[4]), columns[5], columns[6], trainingData);
	            	trainees.add(temp);
	            }

	            trainingInfoService.addTrainee(trainingData, trainees);

			}else {      // throw a error

			}



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 // throw a error
			model.addAttribute("error_msg",CommonData.EVENT_ERROR);
			return "masterTrainerOperation";
		}


		model.addAttribute("error_msg",CommonData.EVENT_SUCCESS);
		return "masterTrainerOperation";

	}

	@RequestMapping(value = "/uploadfeedback", method = RequestMethod.POST)
	public String uploadFeedbackPost(Model model,Principal principal,
								@RequestParam(value = "catMasId") int catId,
								@RequestParam(value = "feedbackmasterId") int trainingTitle,
								@RequestParam(value = "feedbackForm") MultipartFile[] feedbackFile,
								@RequestParam(value = "nameOfMasterTrainer") String name,
								@RequestParam(value = "email") String email,
								@RequestParam(value = "traningInformation") String desc) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		List<Category> cats=catService.findAll();

		List<State> states=stateService.findAll();

		List<Language> lan=lanService.getAllLanguages();

		model.addAttribute("categories", cats);

		model.addAttribute("states", states);
		model.addAttribute("lans", lan);

		if(!ServiceUtility.checkFileExtensionZip(feedbackFile)) {

												// Accommodate error message
			return "masterTrainerOperation";
		}

		TrainingInformation trainingInfo = trainingInfoService.getById(trainingTitle);

		FeedbackMasterTrainer feed = new FeedbackMasterTrainer(feedServ.getNewId(), desc, ServiceUtility.getCurrentTime(), null, trainingInfo, usr);
		try {
			feedServ.save(feed);

			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryMasterTrainerFeedback+feed.getId())) {
				String pathtoUploadPoster=ServiceUtility.uploadFile(feedbackFile, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryMasterTrainerFeedback+feed.getId());
				int indexToStart=pathtoUploadPoster.indexOf("Media");

				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());

				feed.setPath(document);
				feedServ.save(feed);

			}else {

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "masterTrainerOperation";

	}
	
	
	/************************ DOMAIN ROLE CONSULTANT MAPPING *************************************/
	
	@RequestMapping(value = "/assignRoleToDomain" , method = RequestMethod.GET)
	public String assignRoleToDomainGet(Model model,Principal principal) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		
		List<Consultant> consults = consultService.findAll();
		List<Category> categories = catService.findAll();
		List<Language> languages = lanService.getAllLanguages();
		
		model.addAttribute("categories", categories);
		model.addAttribute("consultants", consults);
		model.addAttribute("languages", languages);
		
		return "assignRoleToDomain"; // add html page
		
	}
	
	@RequestMapping(value = "/assignRoleToDomain" , method = RequestMethod.POST)
	public String assignRoleToDomainPost(Model model,Principal principal,
									@RequestParam(value = "consultEmail") String email,
									@RequestParam(value = "category") String cat,
									@RequestParam(value = "language") String lan) {
		User usr=new User();

		if(principal!=null) {

			usr=userService.findByUsername(principal.getName());
		}

		model.addAttribute("userInfo", usr);
		
		List<Consultant> consults = consultService.findAll();
		List<Category> categories = catService.findAll();
		List<Language> languages = lanService.getAllLanguages();
		
		model.addAttribute("categories", categories);
		model.addAttribute("consultants", consults);
		model.addAttribute("languages", languages);
		
		User usrTemp = userService.findByEmail(email);
		Category category = catService.findBycategoryname(cat);
		Language language = lanService.getByLanName(lan);
		Role role = roleService.findByname(CommonData.domainReviewerRole);
		
		if(usrRoleService.findByLanCatUser(language, category, usrTemp, role)!=null) {

			// throw error
			//model.addAttribute("msgSuccefull", CommonData.ADMIN_ADDED_SUCCESS_MSG);
			
			model.addAttribute("error_msg", CommonData.DUPLICATE_ROLE_ERROR);

			return "assignRoleToDomain";
		}

		UserRole usrRole=new UserRole();
		usrRole.setCreated(ServiceUtility.getCurrentTime());
		usrRole.setUser(usrTemp);
		usrRole.setRole(role);
		usrRole.setLanguage(language);
		usrRole.setCategory(category);
		usrRole.setUserRoleId(usrRoleService.getNewUsrRoletId());

		try {
			usrRoleService.save(usrRole);
			
			usrTemp.setPassword(SecurityUtility.passwordEncoder().encode(CommonData.COMMON_PASSWORD));
			userService.save(usrTemp);
			
			SimpleMailMessage newEmail = mailConstructor.domainRoleMailSend(usrTemp);

			mailSender.send(newEmail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			model.addAttribute("error_msg", CommonData.ROLE_ERROR_MSG);
			e.printStackTrace();
			return "assignRoleToDomain";				// accommodate error message
		}
		
		
		model.addAttribute("success_msg", CommonData.MAIL_SEND);
		
		
		return "assignRoleToDomain"; // add html page
		
	}
	
	
	/****************************** END ***********************************************************/

}
