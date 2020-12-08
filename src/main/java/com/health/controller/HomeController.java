package com.health.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.persistence.criteria.CommonAbstractCriteria;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.health.domain.security.PasswordResetToken;
import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;

import com.health.model.Consultant;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Event;
import com.health.model.Language;
import com.health.model.Question;
import com.health.model.Testimonial;
import com.health.model.Topic;
import com.health.model.TopicCategoryMapping;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.repository.LangaugeRepository;
import com.health.service.CategoryService;
import com.health.service.ConsultantService;
import com.health.service.ContributorAssignedTutorialService;
import com.health.service.EventService;
import com.health.service.LanguageService;
import com.health.service.QuestionService;
import com.health.service.RoleService;
import com.health.service.TestimonialService;
import com.health.service.TopicCategoryMappingService;
import com.health.service.TopicService;
import com.health.service.TutorialService;
import com.health.service.UserRoleService;
import com.health.service.UserService;
import com.health.service.impl.CatgoryServiceImpl;
import com.health.service.impl.UserSecurityService;
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

	@RequestMapping("/login")									// in use
	public String loginGet(Model model) {
		model.addAttribute("classActiveLogin", true);
		return "signup";
	}

//	@RequestMapping("/HomeRemove")
//	public String homeLogin() {
//		return "HomeRemove";
//	}

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
		
		String categoryName = req.getParameter("categoryname");
		String categoryDesc = req.getParameter("categoryDesc");
		
		if(catService.findBycategoryname(categoryName)!=null) {
			
			model.addAttribute("msg", true);
			
			return "addCategory";
		}
		
		if(!ServiceUtility.checkFileExtensionImage(files)) {
			
			//model.addAttribute("msg", true);        error aganist file format
			
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
			
			return "addCategory";
		}
		
		model.addAttribute("msg1", CommonData.RECORD_SAVE_SUCCESS_MSG);
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
		
		model.addAttribute("languageAll", languages);
		
		return "addlanguage";
	
	}
	
	@RequestMapping(value = "/addLanguage",method = RequestMethod.POST)
	public String addLanguagePost(Model model,Principal principal,HttpServletRequest req) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=userService.findByUsername(principal.getName());
		}
		
		model.addAttribute("userInfo", usr);
		
		List<Language> languageExist=lanService.getAllLanguages();
		
		String languagename=req.getParameter("languageName");
		
		if(languagename==null) {
			
			model.addAttribute("msg", true);
			model.addAttribute("languageAll", languageExist);
			return "addlanguage";
		}
	
		if(lanService.getByLanName(languagename)!=null) {
			
			model.addAttribute("msg1", true);
			model.addAttribute("languageAll", languageExist);
			return "addlanguage";
		}
		
		
		Language newLan=new Language();
		newLan.setLanId(lanService.getnewLanId());
		newLan.setLangName(languagename);
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
		
		
		model.addAttribute("msgSuccefull", CommonData.RECORD_SAVE_SUCCESS_MSG);
		
		languageExist=lanService.getAllLanguages();
		
		model.addAttribute("languageAll", languageExist);
		
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
		
		List<Category> category = catService.findAll();
		
		model.addAttribute("categories", category);
		
		Category cat =catService.findByid(categoryId);
		System.out.println(cat.getCatName());
		
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
		
		model.addAttribute("msg", CommonData.RECORD_SAVE_SUCCESS_MSG);
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
		
		return "addNewRole";
	
	}
	
	@RequestMapping(value = "/addRole",method = RequestMethod.POST)
	public String addRolePost(Model model,Principal principal,HttpServletRequest req) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=userService.findByUsername(principal.getName());
		}
		
		model.addAttribute("userInfo", usr);
		
		String roleName = req.getParameter("roleName");
		
		if(roleService.findByname(roleName)!=null) {
			
			model.addAttribute("msg1", true);
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
		
		model.addAttribute("msgSuccefull", CommonData.RECORD_SAVE_SUCCESS_MSG);
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
		
		List<Language> languages=lanService.getAllLanguages();
		
		List<Category> categories=catService.findAll();

		model.addAttribute("categories", categories);

		model.addAttribute("languages", languages);
		
		if(!ServiceUtility.checkFileExtensionPDF(quesPdf)) {  // throw error
			
			return "uploadQuestion";
		}
		
		Category cat=catService.findByid(categoryId);
		Topic topic=topicService.findById(topicId);
		TopicCategoryMapping topicCat=topicCatService.findAllByCategoryAndTopic(cat, topic);
		Language lan=lanService.getById(languageId);
		
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
			
			return "uploadQuestion";
		}
		
		model.addAttribute("msg",CommonData.RECORD_SAVE_SUCCESS_MSG);

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

		return "addConsultant";
		
	}
	
	@RequestMapping(value = "/addConsultant",method = RequestMethod.POST)
	public String addConsultantPost(Model model,Principal principal,
									@RequestParam("uploadConsaltantImage") MultipartFile[] file,
									@RequestParam("nameConsaltant") String name,
									@RequestParam("descriptionConsaltant") String desc,
									@RequestParam(defaultValue = "false") String showOnHomePage) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=userService.findByUsername(principal.getName());
		}
		
		model.addAttribute("userInfo", usr);
		boolean show=false;
		
		if(showOnHomePage!=null) {
			show=showOnHomePage.equals("showOnHomePage");
		}
		
		if(!ServiceUtility.checkFileExtensionImage(file)) {   // throw error extension file.
			
			return "addConsultant";
		}
		
		int newConsultid=consultService.getNewConsultantId();
		Consultant local=new Consultant();
		local.setConsultantId(newConsultid);
		local.setDescription(desc);
		local.setDateAdded(ServiceUtility.getCurrentTime());
		local.setName(name);
		local.setPosterPath("null");
		local.setUser(usr);
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
		
		try {
			if(ServiceUtility.createFolder(env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryConsultant+newConsultid)) {
				String pathtoUploadPoster=ServiceUtility.uploadFile(file, env.getProperty("spring.applicationexternalPath.name")+CommonData.uploadDirectoryConsultant+newConsultid);
				int indexToStart=pathtoUploadPoster.indexOf("Media");
				
				String document=pathtoUploadPoster.substring(indexToStart, pathtoUploadPoster.length());
				
				Consultant temp=consultService.findById(newConsultid);
				
				temp.setPosterPath(document);
				
				consultService.save(temp);
				
			}else {      // throw a error
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			 
			return "addConsultant";    // throw a error
		}
		
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

		return "addEvent";
		
	}
	
	@RequestMapping(value = "/addEvent",method = RequestMethod.POST)
	public String addEventPost(Model model,Principal principal,HttpServletRequest req) {
		
		User usr=new User();
		
		if(principal!=null) {
			
			usr=userService.findByUsername(principal.getName());
		}
		
		model.addAttribute("userInfo", usr);
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
				
				return "addEvent";
			}
			
			if(!ServiceUtility.checkEmailValidity(email)) { // throw error on wrong email
				
				return "addEvent";
			}
			
			if(!ServiceUtility.checkEmailValidity(email)) {    // throw error on wrong email
				
				return "addEvent";
			}
			
			if(contactNumber.length() != 10) {        // throw error on wrong phone number
				
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
			e.printStackTrace();
		}
		
		model.addAttribute("msg",CommonData.RECORD_SAVE_SUCCESS_MSG);
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
		
		model.addAttribute("msg",CommonData.RECORD_SAVE_SUCCESS_MSG);
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
		
		if(usrRoleService.findByLanUser(lan, usr, role)!=null) {
			 
			// throw error 
			//model.addAttribute("msgSuccefull", CommonData.ADMIN_ADDED_SUCCESS_MSG);
			List<Language> languages=lanService.getAllLanguages();
			List<Category> categories=catService.findAll();
			
			model.addAttribute("categories", categories);
			
			model.addAttribute("languages", languages);
			
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
			model.addAttribute("msgSuccefull", CommonData.CONTRIBUTOR_ADDED_SUCCESS_MSG);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
												// accommodate error message
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
			model.addAttribute("msgSuccefull", CommonData.ADMIN_ADDED_SUCCESS_MSG);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
												// accommodate error message
		}
		
		List<Language> languages=lanService.getAllLanguages();
		List<Category> categories=catService.findAll();
		
		model.addAttribute("categories", categories);
		
		model.addAttribute("languages", languages);
		
		
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
			model.addAttribute("msgSuccefull", CommonData.QUALITY_ADDED_SUCCESS_MSG);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
		}
		
		model.addAttribute("userInfo", usr);
		
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
			return "addMasterTrainerRole";
		}
		
		if(mobileNumber.length()!=10) {
			
			// throw error
			return "addMasterTrainerRole";
		}
		
		Role role=roleService.findByname(CommonData.masterTrainerRole);
		
		if(usrRoleService.findByRoleUser(usr, role)!=null) {
			// throw error
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
			model.addAttribute("msgSuccefull", CommonData.MASTER_TRAINER_ADDED_SUCCESS_MSG);
			
		}catch (Exception e) {
			// TODO: handle exception
			
			// throw error
		}
		
		model.addAttribute("userInfo", usr);
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
				ContributorAssignedTutorial x=conRepo.findByUserTopicCatLan(userAssigned, topicCat, lan);
				
				if(x == null) {
					
					ContributorAssignedTutorial temp=new ContributorAssignedTutorial(conNewId++, ServiceUtility.getCurrentTime(), userAssigned, topicCat, lan);
					conTutorials.add(temp);
					
				}else {
					// throw error for repeated task 
					return "assignContributorList";
				}
				
				
				
			}else {
				// throw error as topic doesn't exist
				return "assignContributorList";
			}
		}
		
		
		userService.addUserToContributorTutorial(userAssigned, conTutorials);
		
		model.addAttribute("msg", CommonData.CONTRIBUTOR_ASSIGNED_TUTORIAL);
	
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
			}
		}
		
		model.addAttribute("category", cat);
		model.addAttribute("topic", topic);
		model.addAttribute("language", lan);
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
		
		UserRole userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategory(userRoles.getCategory());
		
		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles.getLanguage());
		
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
			model.addAttribute("tutorialNotExist", "Bad request");   //  throw proper error
			return "listTutorialAdminReviwer";
			
		}
		
		model.addAttribute("tutorial", tutorial);
		
		model.addAttribute("category", tutorial.getConAssignedTutorial().getTopicCatId().getCat().getCatName());
		model.addAttribute("topic", tutorial.getConAssignedTutorial().getTopicCatId().getTopic().getTopicName());
		model.addAttribute("language", tutorial.getConAssignedTutorial().getLan().getLangName());
		
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
		
		UserRole userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategory(userRoles.getCategory());
		
		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles.getLanguage());
		
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
		
		UserRole userRoles=usrRoleService.findByRoleUser(usr, role);
		List<TopicCategoryMapping> localMap=topicCatService.findAllByCategory(userRoles.getCategory());
		
		List<ContributorAssignedTutorial> conTutorials=conRepo.findByTopicCatLan(localMap, userRoles.getLanguage());
		
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
}
