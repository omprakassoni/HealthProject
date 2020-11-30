package com.health.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.health.domain.security.PasswordResetToken;
import com.health.model.Category;

import com.health.model.Consultant;
import com.health.model.Event;
import com.health.model.Testimonial;
import com.health.model.Tutorial;
import com.health.model.User;

import com.health.service.UserService;

import com.health.service.impl.UserSecurityService;
import com.health.utility.MailConstructor;
import com.health.utility.SecurityUtility;
import com.health.utility.ServiceUtility;

@Controller
public class HomeController {

	private static final List<Consultant> List = null;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private MailConstructor mailConstructor;

	@Autowired
	private UserService userService;  // in use

	@Autowired
	private UserSecurityService userSecurityService;

//	@Autowired
//	private categoryService categoryservice;
//
//	@Autowired
//	private stateRespositary statedao;
//
//	@Autowired
//	private EventDao eventDao;
//
//	@Autowired
//	private TestimonialDao testimonialdao;
//
//	@Autowired
//	private ConsaltantDao consalatantDao;
//
//	@Autowired
//	private TutorialDao tutorialDao;
//
//	@Autowired
//	private languagedao languageDao;
//
//	@Autowired
//	private ConsaltantDao consultantDao;
//
//	@Autowired
//	private CategoryDao categoryDao;



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
		user.setUsername(username);
		user.setEmail(userEmail);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setPhone(phoneLongValue);
		user.setPassword(SecurityUtility.passwordEncoder().encode(password));

		userService.save(user);
		model.addAttribute("emailSent", "true");

		return "signup";

	}

	@RequestMapping("/newUser")										// in use
	public String newUserGet (Model model) {
		
		model.addAttribute("classActiveNewAccount", true);
		return "signup";

		
	}
	
	@RequestMapping(value = "/dashBoard",method = RequestMethod.GET)
	public String dashBoardGet (Model model,Principal principal) {
		
		User usr=new User();
		if(principal!=null) {
			
			usr=userService.findByUsername(principal.getName());
		}
		
		model.addAttribute("userInfo", usr);
		
		return "roleAdminDetail";

		
	}

}
