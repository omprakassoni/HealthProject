
package com.health.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Consaltantant;
import com.health.model.Event;
import com.health.model.Testimonial;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.category_Tutorial;
import com.health.repository.CategoryDao;
import com.health.repository.CategoryTutorialDao;
import com.health.repository.ConsaltantDao;
import com.health.repository.EventDao;
import com.health.repository.RoleRepository;
import com.health.repository.TestimonialDao;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.service.ConsaltantService;
import com.health.service.categoryService;
import com.health.service.eventService;
import com.health.service.testimonialService;

@Controller
public class ControllerHealth {

	public static String uploadDirectoryConsaltant = "src/main/resources/static" + "/Media/content" + "/Consaltant";

	public static String uploadDirectory = "src/main/resources/static" + "/Media/content" + "/Testimonial";

	public static String uploadDirectorOutLine = "src/main/resources/static" + "/Media/content" + "/Tutorial/Outline";
	public static String uploadDirectorScript = "src/main/resources/static" + "/Media/content" + "/Tutorial/Script";
	public static String uploadDirectorTimeScript = "src/main/resources/static" + "/Media/content"
			+ "/Tutorial/TimeScript";
	public static String uploadDirectorVideo = "src/main/resources/static" + "/Media/content" + "/Tutorial/Video";
	public static String uploadDirectorKeyWord = "src/main/resources/static" + "/Media/content" + "/Tutorial/KeyWord";

	public String pathfile = uploadDirectory;

	@Autowired
	private ConsaltantService consaltantservice;

	@Autowired
	private ConsaltantDao consalttantDao;

	@Autowired
	private testimonialService testimonialService;

	@Autowired
	private TestimonialDao testimonialDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private categoryService categoryService;

	@Autowired
	private eventService eventService;

	@Autowired
	private EventDao eventDao;

	@Autowired
	private TutorialDao tutorialDao;

	@Autowired
	private CategoryTutorialDao categoryTutorialDao;

	@Autowired
	private RoleRepository rolerespositary;

	@Autowired
	private UserRoleRepositary userRoleRepositary;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/Consaltant")
	public String Consaltant() {

		return "addConsaltant";

	}

	@RequestMapping("/show_consalantant")
	public String show_consalantant() {

		return "Show_Consaltant";

	}

	@RequestMapping("/Testimonial")
	public String Testimonial() {

		return "addTestimonial";

	}

	@RequestMapping("/Event")
	public String Event() {

		return "addEvent";

	}

	@RequestMapping("/adminShowDomainReviweer")
	public String adminShowQualityreviweer(Model model) {

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

		return "adminShowDomainReviweer";

	}

	@RequestMapping("/adminShowQualityreviweer")
	public String adminshowDomainReviweer(Model model) {

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

		return "adminShowQualityReviweer";

	}

	@RequestMapping("/adminShowMasterTrainer")
	public String showMasterTrainer(Model model) {

		int rolId = 4;

		Role role = rolerespositary.findByIdRoles(rolId);
		int status = 0;
		List<UserRole> userByStatus = userRoleRepositary.findByStatus(status, role);

		List<User> userAddInformation = new ArrayList<>();

		for (UserRole ur : userByStatus) {

			User userInformation = userRepository.findOne(ur.getUser().getId());

			userAddInformation.add(userInformation);

		}

		model.addAttribute("masterTrainerDetail", userAddInformation);

		return "adminShowMasterTrainer";
	}

	@RequestMapping("/Category")
	public String addCategory() {

		return "addCategory";
	}

	@RequestMapping("/TutorialAdd")
	public String tutorialAdd(Model model) {

		List<Category> categoryList = (List<Category>) categoryService.findAll();

		model.addAttribute("categorys", categoryList);
		return "adduploadTutorial";
	}

	@RequestMapping("/show_category")
	public String show_category(Model model) {

		List<Category> category = (List<Category>) categoryDao.findAll();

		model.addAttribute("products", category);

		return "showCategory";
	}

	/*****************************************************
	 * Here we write code for add conslantant
	 *************************************************************************/

	String fileconsalantant;

	@RequestMapping("/addConsaltant")
	public String uploadConsaltant(HttpServletRequest req, Model model,
			@RequestParam("uploadConsaltantImage") MultipartFile[] files)

	{

		String path = null;
		String nameConsaltant = req.getParameter("nameConsaltant");
		String descriptionConsaltant = req.getParameter("descriptionConsaltant");

		String abc = uploadDirectoryConsaltant + "/" + nameConsaltant;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());

				fileconsalantant = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String substring = fileconsalantant.substring(26);

		Consaltantant consaltantant = new Consaltantant();

		consaltantant.setNameConsaltant(nameConsaltant);
		consaltantant.setDescriptionConsaltant(descriptionConsaltant);
		consaltantant.setUploadConsaltantImage(substring);

		consalttantDao.save(consaltantant);

		System.err.println(uploadDirectory);

		model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());

		return "addConsaltant";

	}

	/*****************************************************
	 * Here Start Write code to show consalantant
	 *************************************************************************/

	@RequestMapping(value = "/show_consalantant", method = RequestMethod.GET)

	public String showconsaltant(Model model) {

		List<Consaltantant> name = consaltantservice.findAll();

		model.addAttribute("products", name);

		return "Show_Consaltant";

	}

	/*****************************************************
	 * Here End Write code to show consalantant
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to consalantant delete
	 *************************************************************************/

	@RequestMapping("/consalantant/delete/{id}")
	public String deleteconsalantant(@PathVariable Integer id, Model model, ModelAndView mv) {

		consaltantservice.deleteProduct(id);

		return "redirect:/show_consalantant";

	}

	/*****************************************************
	 * Here End Write code to consalantant delete
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to consalantant select by id for Edit
	 *************************************************************************/

	/* Here we Edit information User by id */

	@RequestMapping("productconsalantant/edit/{id}")
	public String editconsalantant(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Consaltantant consaltantant = consaltantservice.getProductById(id);

		model.addAttribute("products", consaltantant);

		// return "Update_Consalantant"; categoryService

		return "Update _ConsalantantTwo";

	}

	/*****************************************************
	 * Here End Write code to consalantant select by id for Edit
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to update consalantant
	 *************************************************************************/

	String fileconversion;

	@RequestMapping(value = "/consalantantupdate", method = RequestMethod.POST)
	public String uploadConsaltantUpdate(HttpServletRequest req,
			@RequestParam("uploadConsaltantImage") MultipartFile[] files) {

		String id = req.getParameter("productId");

		String path = null;
		String nameConsaltant = req.getParameter("nameConsaltant");
		String descriptionConsaltant = req.getParameter("descriptionConsaltant");
		int consalantant_id = Integer.parseInt(id);

		System.out.println("hi" + consalantant_id);
		System.err.println("Hi" + consalantant_id);
		System.err.println(descriptionConsaltant);
		System.out.println(nameConsaltant);

		String abc = uploadDirectoryConsaltant + "/" + nameConsaltant;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");

			try {

				Files.write(fileNameAndPath, file.getBytes());
				fileconversion = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String substring = fileconversion.substring(26);

		String var = substring.toString();
		System.out.println(var);

		consaltantservice.UpdateConsalantant(descriptionConsaltant, nameConsaltant, var, consalantant_id);

		System.err.println(uploadDirectory);

		return "redirect:/show_consalantant";

	}

	/*****************************************************
	 * Here End code update of consalantant
	 *************************************************************************/

	/*****************************************************
	 * Here we write code for add testimonial
	 *************************************************************************/

	String filepath;

	@RequestMapping("/addTestimonial")
	public String upload(HttpServletRequest req, Model model,
			@RequestParam("uploadTestiminial") MultipartFile[] files) {

		String path = null;
		String testimonialName = req.getParameter("testimonialName");
		String testimoniaqlDescription = req.getParameter("testimoniaqlDescription");

		String abc = uploadDirectory + "/" + testimonialName;

		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());

			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		String substring = filepath.substring(26);

		Testimonial testimonial = new Testimonial();

		testimonial.setTestimonialName(testimonialName);
		testimonial.setTestimoniaqlDescription(testimoniaqlDescription);

		testimonial.setUploadTestiminial(substring);

		testimonialDao.save(testimonial);

		model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());

		return "addTestimonial";
	}

	/*****************************************************
	 * Here we End write code for add testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to Show Testimonial
	 *************************************************************************/

	@RequestMapping(value = "/show_testimonial", method = RequestMethod.GET)

	public String showtestimonial(Model model) {

		List<Testimonial> name = testimonialService.findAll();

		model.addAttribute("testimonials", name);

		return "show_Testimonial";

	}

	/*****************************************************
	 * Here End Write code to End show testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to Edit Testimonial
	 *************************************************************************/

	@RequestMapping("productTesdtimonial/edit/{id}")
	public String editconsalantantDemo(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Testimonial testimonial = new Testimonial();

		testimonial = testimonialService.getProductById(id);

		model.addAttribute("testimonials", testimonial);

		return "updateTestimonial";

	}

	/*****************************************************
	 * Here Write code to End Edit Testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to update Testimonial
	 ****************************************************************************/

	@RequestMapping(value = "/updateTetimonial", method = RequestMethod.POST)
	public String updateTestimonial(HttpServletRequest req, @RequestParam("uploadTestiminial") MultipartFile[] files) {

		String id = req.getParameter("testimonialId");
		String path = null;
		String nametestimonial = req.getParameter("testimonialName");
		String descriptionTestimonial = req.getParameter("testimoniaqlDescription");
		int testimonial_id = Integer.parseInt(id);

		String abc = uploadDirectoryConsaltant + "/" + nametestimonial;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				fileconversion = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String substring = fileconversion.substring(26);

		String var = substring.toString();
		System.out.println(var);

		testimonialService.updateTestimonial(nametestimonial, descriptionTestimonial, var, testimonial_id);

		System.err.println(uploadDirectory);

		return "redirect:/show_testimonial";

	}

	/*****************************************************
	 * Here End code update to Testimonial
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to delete Testimonial
	 *************************************************************************/

	@RequestMapping("testimonial/delete/{id}")
	public String deleteTestimonial(@PathVariable Integer id, Model model, ModelAndView mv) {

		testimonialService.deleteProduct(id);

		return "redirect:/show_testimonial";

	}

	/*****************************************************
	 * Here End Write code to Event delete
	 *************************************************************************/

	/*****************************************************
	 * Here we write code for add Event
	 *************************************************************************/

	@RequestMapping("/addEvent")
	public String addEvent(HttpServletRequest req, Model model) {

		System.out.println(req.getParameter("eventname"));

		String eventname = req.getParameter("eventname");
		String date = req.getParameter("date");
		String description = req.getParameter("description");
		String venuename = req.getParameter("venuename");
		String contactperson = req.getParameter("contactperson");
		String contactnumber = req.getParameter("contactnumber");
		String email = req.getParameter("email");

		System.out.println(eventname + "" + date + "" + description);

		Event event1 = new Event();

		event1.setEventname(eventname);
		event1.setDate(date);
		event1.setDescription(description);
		event1.setVenuename(venuename);
		event1.setContactperson(contactperson);
		event1.setContactnumber(contactnumber);
		event1.setEmail(email);
		model.addAttribute("msg", "Succefully Add Event");

		eventDao.save(event1);

		return "addEvent";

	}

	/*****************************************************
	 * Here we end write code for add Event
	 **************************************************************************/

	/*****************************************************
	 * Here Start Write code to show Event
	 *************************************************************************/

	@RequestMapping(value = "/show_Event", method = RequestMethod.GET)
	public String showEvent(Model model) {

		List<Event> name = eventService.findAll();
		model.addAttribute("events", name);
		return "Show_Event";

	}

	/*****************************************************
	 * Here End Write code to show event
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to Event delete
	 *************************************************************************/

	@RequestMapping("event/delete/{id}")

	public String deleteEvent(@PathVariable Integer id, Model model, ModelAndView mv) {

		eventService.deleteProduct(id);

		return "redirect:/show_Event";

	}

	/*****************************************************
	 * Here End Write code to Event delete
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to Event select by id for Edit
	 *************************************************************************/

	/* Here we Edit information User by id */

	@RequestMapping("event/edit/{id}")
	public String editEvent(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Event event = eventService.getProductById(id);

		model.addAttribute("events", event);

		System.err.println(event.getDate() + "" + event.getEmail() + "" + event.getDescription());

		return "Update_Event";

	}

	/*****************************************************
	 * Here End Write code to Event select by id for Edit
	 *************************************************************************/

	/*****************************************************
	 * Here Write code to update Event
	 *************************************************************************/

	@RequestMapping(value = "/eventUpdate", method = RequestMethod.POST)
	public String eventUpdate(HttpServletRequest req) {
		String eventname = req.getParameter("eventname");
		String date = req.getParameter("date");
		String description = req.getParameter("description");
		String venuename = req.getParameter("venuename");
		String contactperson = req.getParameter("contactperson");
		String contactnumber = req.getParameter("contactnumber");
		String email = req.getParameter("email");

		String id_event = req.getParameter("eventId");

		int id = Integer.parseInt(id_event);

		System.err.println("hi" + id);

		eventService.UpdateEvent(eventname, date, description, venuename, contactperson, contactnumber, email, id);

		return "redirect:/show_Event";

	}

	/*****************************************************
	 * Here End code update of Event
	 *************************************************************************/

	/*****************************************************
	 * Here we write code save category
	 *************************************************************************/

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String add(HttpServletRequest req, Model model) {

		String categoryName = req.getParameter("categoryname");

		Category category = new Category();

		category.setCategoryname(categoryName);

		categoryDao.save(category);

		model.addAttribute("msg", "Successfully upload File");

		return "addCategory";

	}

	/*****************************************************
	 * Here we write code End save category
	 *************************************************************************/

	/*****************************************************
	 * Here we write code Tutorial category
	 *************************************************************************/

	@RequestMapping(value = "/addTutorail", method = RequestMethod.POST)
	public String addTutorail(HttpServletRequest req, Model model, @RequestParam("outline") MultipartFile[] outline,
			@RequestParam("script") MultipartFile[] script, @RequestParam("timeScript") MultipartFile[] timeScript,
			@RequestParam("tutorial") MultipartFile[] video, @RequestParam(name = "categoryName") String categoryName

	) {
		System.err.println(categoryName);
		String topicname = req.getParameter("topicName");
		String languageName = req.getParameter("languageName");

//OutLine	

		String path = null;
		String abc = uploadDirectorOutLine + "/" + topicname;
		new File(abc).mkdir();

		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : outline) {

			Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());

			fileNames.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String outlinefile = filepath.substring(26);

		// script

		String pathScript = null;
		String Script = uploadDirectorScript + "/" + topicname;
		new File(Script).mkdir();

		StringBuilder Scriptname = new StringBuilder();
		for (MultipartFile file : script) {

			Path fileNameAndPath = Paths.get(Script, file.getOriginalFilename());

			Scriptname.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		String scriptfile = filepath.substring(26);

//TimeScript
		String pathTimeScript = null;
		String TimeScript = uploadDirectorTimeScript + "/" + topicname;
		new File(TimeScript).mkdir();

		StringBuilder TimeScriptname = new StringBuilder();
		for (MultipartFile file : timeScript) {

			Path fileNameAndPath = Paths.get(TimeScript, file.getOriginalFilename());

			Scriptname.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String TimeScriptfile = filepath.substring(26);

//Video
		String pathVideo = null;
		String Video = uploadDirectorVideo + "/" + topicname;
		new File(Video).mkdir();

		StringBuilder videoname = new StringBuilder();
		for (MultipartFile file : video) {

			Path fileNameAndPath = Paths.get(Video, file.getOriginalFilename());

			Scriptname.append(file.getOriginalFilename() + " ");

			try {
				Files.write(fileNameAndPath, file.getBytes());
				System.out.println(fileNameAndPath.toString());

				filepath = fileNameAndPath.toString();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		String Videofile = filepath.substring(26);

		Category category = categoryService.findBycategoryname(categoryName);

		Set<category_Tutorial> category_Tutorials = new HashSet<>();

		Tutorial turorial = new Tutorial();
		turorial.setTopicname(topicname);
		turorial.setLanguage(languageName);
		turorial.setOutlin(outlinefile);
		turorial.setScript(scriptfile);
		turorial.setTimeScript(TimeScriptfile);
		turorial.setVideo(Videofile);

		category_Tutorial cate_tutorial = new category_Tutorial(category, turorial);

		/*
		 * category_Tutorials.add(new category_Tutorial(category, turorial));
		 * categoryTutorialDao.save(category_Tutorials);
		 */

		// userService.createUser(user1, userRoles);

		categoryTutorialDao.save(cate_tutorial);

		model.addAttribute("msg", "Successfully uploaded files " + fileNames.toString());

		return "adduploadTutorial";

	}

	/*****************************************************
	 * Here we write code End Tutorial category
	 *************************************************************************/
	////

	/*****************************************************
	 * Here Start Write code to category delete
	 *************************************************************************/

	@RequestMapping("category/delete/{id}")

	public String deleteCategory(@PathVariable Integer id, Model model, ModelAndView mv) {

		categoryService.deleteProduct(id);

		return "redirect:/show_category";

	}

	/*****************************************************
	 * Here End Write code to category delete
	 *************************************************************************/

	/*****************************************************
	 * Here Start Write code to category select by id for Edit
	 *************************************************************************/

	/* Here we Edit information User by id */

	@RequestMapping("category/edit/{id}")
	public String editCategory(@PathVariable Integer id, Model model, HttpServletRequest req) {

		Category category = categoryService.getProductById(id);
		model.addAttribute("category", category);
		return "updateCategory";
	}

	/*****************************************************
	 * Here Start Write code to end category select by id for Edit
	 *************************************************************************/

	/*
	 * @RequestMapping("/loadByCategoryTuturial") public String
	 * loadByCategory(@PathVariable Integer id, Model model, HttpServletRequestnew
	 * req,@RequestParam(name = "categoryName") String categoryName){
	 * 
	 * 
	 * Category category=categoryService.findBycategoryname(categoryName);
	 * 
	 * category_Tutorial
	 * categoryTutorials=categoryTutorialDao.findOne(category.getId());
	 * 
	 * String lan=categoryTutorials.getTutorial().getLanguage();
	 * 
	 * model.addAttribute("languages",lan);
	 * 
	 * ///
	 * 
	 * 
	 * Category cat=categoryService.findBycategoryname(categoryName);
	 * 
	 * List<category_Tutorial> categoryTutorial=(List<category_Tutorial>)
	 * categoryTutorialDao.findOne(cat.getId());
	 * 
	 * List<Tutorial> userAddInformation = new ArrayList<>();
	 * 
	 * 
	 * 
	 * for (category_Tutorial ur : categoryTutorial) {
	 * 
	 * 
	 * Tutorial userInformation =
	 * tutorialDao.findOne(ur.getTutorial().getTutorialid());
	 * 
	 * userAddInformation.add(userInformation); }
	 * 
	 * model.addAttribute("languages", userAddInformation);
	 * 
	 * return "index"; }
	 */
	 
	
	@RequestMapping(value = "/findTutorialByLanand", method = RequestMethod.GET)
	public String viewCoursesAvailable(@RequestParam(value="categoryName") int categoryNameId,@RequestParam(name="inputLanguage") String inputLanguage,Model model) {
	
	
		System.err.println("cat Id:"+categoryNameId);
		
		List<Tutorial> addlanguage=new ArrayList<>();
		
		Category category=categoryDao.findByid(categoryNameId);
		
		  
		 
		  Tutorial  tutorials=tutorialDao.findBylanguage(inputLanguage);
		  
		  System.err.println(tutorials.getTutorialid());
		
		 
		 List<category_Tutorial> categtory_tutorials=(List<category_Tutorial>)categoryTutorialDao.findBycategoryAndlanguageza(category,tutorials);
		
		 System.err.println(categtory_tutorials.size());
		  for(category_Tutorial s:categtory_tutorials) 
		  {
			 
		
			 Tutorial tutorial=tutorialDao.findOne(s.getTutorial().getTutorialid());
			 
			 addlanguage.add(tutorial);
		
			  System.err.println("Hiiii"+s.getCat().getCategoryname());
			  
	  
	 }
		  
		  model.addAttribute("cat_Tu",categtory_tutorials);
		
		return "showTutorial";	
		
	}
	
	@RequestMapping("/loadByCategoryTuturial")
	public @ResponseBody  List<String> getAllSubcategories(@RequestParam(value="id") int id)
	{
	

	    System.err.println("hjasdhgh");
	    
	    List<String> topicName=new ArrayList<String>();
		
		//Category cat=categoryService.findBycategoryname(category.getCategoryname());
		
		Category cat=categoryService.findByid(id);
		
		
		System.err.println("category_id"+cat.getId());
	
		List<category_Tutorial> catTut=(List<category_Tutorial>) categoryTutorialDao.findByCategory(cat);
	
		
		//List<category_Tutorial> categoryTutorials=(List<category_Tutorial>) categoryTutorialDao.findOne(cat);
		
		
		for(category_Tutorial s:catTut)
		{

			//System.err.println("Language is"+s.getTutorial().getLanguage());
			
			topicName.add(s.getTutorial().getLanguage());

			
		}
	
		return topicName;   

	}
	
	
	@RequestMapping(value = "/fetchInformation", method = RequestMethod.POST)
    public @ResponseBody  List<String> getAllSubcategories1(@RequestParam(value="id") int id) {
				
			
			List<String> topicName=new ArrayList<String>();
			
			//Category cat=categoryService.findBycategoryname(category.getCategoryname());
			
			Category cat=categoryService.findByid(id);
			
			List<category_Tutorial> categoryTutorial=(List<category_Tutorial>) categoryTutorialDao.findOne(cat.getId());
			
			
			for(category_Tutorial s:categoryTutorial)
			{
				
				topicName.add(s.getTutorial().getLanguage());
	
			}
		
		return topicName;
		
      
    }
	
	@RequestMapping("/masterTrainer")
	public @ResponseBody  List<String> masterTrainer(@RequestParam(value="id") int id)
	{
	

	    System.err.println("hjasdhgh");
	    
	    List<String> topicName=new ArrayList<String>();
		
		//Category cat=categoryService.findBycategoryname(category.getCategoryname());
		
		Category cat=categoryService.findByid(id);
		
		
		System.err.println("category_id"+cat.getId());
	
		List<category_Tutorial> catTut=(List<category_Tutorial>) categoryTutorialDao.findByCategory(cat);
	
		
		//List<category_Tutorial> categoryTutorials=(List<category_Tutorial>) categoryTutorialDao.findOne(cat);
		
		
		for(category_Tutorial s:catTut)
		{

			//System.err.println("Language is"+s.getTutorial().getLanguage());
			
			topicName.add(s.getTutorial().getLanguage());

			
		}
	
		return topicName;   

	}
	
	


	
	
	
	

}
