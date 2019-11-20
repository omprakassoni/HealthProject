/*
 * package com.health.controller;
 * 
 * import java.io.File; import java.io.IOException; import java.nio.file.Files;
 * import java.nio.file.Path; import java.nio.file.Paths; import
 * java.util.ArrayList; import java.util.Iterator; import java.util.List;
 * 
 * import javax.security.auth.Subject; import
 * javax.servlet.http.HttpServletRequest; import javax.validation.Valid;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpRequest; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.bind.annotation.ResponseBody; import
 * org.springframework.web.multipart.MultipartFile; import
 * org.springframework.web.servlet.ModelAndView;
 * 
 * 
 * 
 * @Controller public class ControllerHealth {
 * 
 * public static String uploadDirectoryConsaltant = "src/main/resources/static"
 * + "/Media/content" + "/Consaltant";
 * 
 * 
 * public static String uploadDirectory = "src/main/resources/static" +
 * "/Media/content" + "/Testimonial";
 * 
 * public String pathfile = uploadDirectory;
 * 
 * @Autowired(required = false) private Daolayer daolayer;
 * 
 * @Autowired(required = false) private UserServiceREMOVE userservice;
 * 
 * @Autowired(required = false) private classservice classservice;
 * 
 * @Autowired private testimonialService testimonialService;
 * 
 * @Autowired(required = false) private ConsaltantService consaltantservice;
 * 
 * @Autowired(required = false) private eventService eventService;
 * 
 * @Autowired(required = false) private category_languageService catlanservice;
 * 
 * @Autowired(required = false) private catlanguageDao languagNewDao;
 * 
 * @Autowired(required = false) private LanguageService LanguageService;
 * 
 * @Autowired(required = false) private categoryNewdao categoryNewDao;;
 * 
 * @Autowired(required = false) private categoryNewService categoryNewService;
 * 
 * 
 * @RequestMapping("/") public String Admin(){
 * 
 * return "Admin_Template"; }
 * 
 * 
 * @RequestMapping("/h1") public String Admin2(){
 * 
 * return "Admin_Template"; }
 * 
 * 
 * @RequestMapping("/index") public String Index() {
 * 
 * return "index"; }
 * 
 * @RequestMapping("/Category") public String category() {
 * 
 * return "Category"; }
 * 
 * @RequestMapping("/Consaltant") public String Consaltant() {
 * 
 * return "Consaltant";
 * 
 * }
 * 
 * @RequestMapping("/Testimonial") public String Testimonial() {
 * 
 * return "Testimonial"; }
 * 
 * @RequestMapping("/Language") public String Language() {
 * 
 * return "addLanguage";
 * 
 * }
 * 
 * @RequestMapping("Event") public String Event() {
 * 
 * return "addEvent";
 * 
 * }
 * 
 * @RequestMapping("/Upload_Question") public String uploadquestion() {
 * 
 * return "Upload_Question";
 * 
 * }
 * 
 * 
 * @RequestMapping("/login") public String Login() {
 * 
 * return "Login"; }
 * 
 * 
 * @RequestMapping("/UploadVideo") public String uploadVideo() {
 * 
 * return "adduploadTutorial";
 * 
 * }
 * 
 * 
 * 
 * Here we write code for category
 * 
 * @RequestMapping(value = "/saveinfo", method = RequestMethod.POST) public
 * String add(HttpServletRequest req, Model model) {
 * 
 * String categoryName = req.getParameter("name");
 * 
 * UserReview user = new UserReview(); user.setName(categoryName);
 * 
 * userservice.saveProduct(user); model.addAttribute("msg",
 * "Successfully upload File");
 * 
 * return "Admin_Template";
 * 
 * }
 * 
 *//*****************************************************
	 * Here we write code for add testimonial
	 *************************************************************************/
/*
 * 
 * String filepath;
 * 
 * @RequestMapping("/addTestimonial") public String upload(HttpServletRequest
 * req, Model model,
 * 
 * @RequestParam("uploadTestiminial") MultipartFile[] files) {
 * 
 * String path = null; String testimonialName =
 * req.getParameter("testimonialName"); String testimoniaqlDescription =
 * req.getParameter("testimoniaqlDescription");
 * 
 * String abc = uploadDirectory + "/" + testimonialName;
 * 
 * new File(abc).mkdir();
 * 
 * StringBuilder fileNames = new StringBuilder(); for (MultipartFile file :
 * files) { Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
 * 
 * fileNames.append(file.getOriginalFilename() + " ");
 * 
 * try { Files.write(fileNameAndPath, file.getBytes());
 * System.out.println(fileNameAndPath.toString());
 * 
 * filepath = fileNameAndPath.toString();
 * 
 * } catch (IOException e) { e.printStackTrace(); }
 * 
 * }
 * 
 * String substring = filepath.substring(26);
 * 
 * Testimonial testimonial = new Testimonial();
 * 
 * testimonial.setTestimonialName(testimonialName);
 * testimonial.setTestimoniaqlDescription(testimoniaqlDescription);
 * 
 * testimonial.setUploadTestiminial(substring);
 * 
 * userservice.save(testimonial);
 * 
 * model.addAttribute("msg", "Successfully uploaded files " +
 * fileNames.toString());
 * 
 * return "Admin_Template"; }
 * 
 *//*****************************************************
	 * Here we End write code for add testimonial
	 *************************************************************************/
/*

*//*****************************************************
	 * Here we write code for add conslantant
	 *************************************************************************/
/*
 * 
 * String fileconsalantant;
 * 
 * @RequestMapping("addConsaltant") public String
 * uploadConsaltant(HttpServletRequest req, Model model,
 * 
 * @RequestParam("uploadConsaltantImage") MultipartFile[] files) {
 * 
 * String path = null; String nameConsaltant =
 * req.getParameter("nameConsaltant"); String descriptionConsaltant =
 * req.getParameter("descriptionConsaltant");
 * 
 * String abc = uploadDirectoryConsaltant + "/" + nameConsaltant; new
 * File(abc).mkdir();
 * 
 * StringBuilder fileNames = new StringBuilder(); for (MultipartFile file :
 * files) { Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
 * fileNames.append(file.getOriginalFilename() + " ");
 * 
 * try { Files.write(fileNameAndPath, file.getBytes());
 * 
 * fileconsalantant = fileNameAndPath.toString();
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 * 
 * String substring = fileconsalantant.substring(26);
 * 
 * Consaltantant consaltantant = new Consaltantant();
 * 
 * consaltantant.setNameConsaltant(nameConsaltant);
 * consaltantant.setDescriptionConsaltant(descriptionConsaltant);
 * consaltantant.setUploadConsaltantImage(substring);
 * 
 * userservice.save(consaltantant);
 * 
 * System.err.println(uploadDirectory);
 * 
 * model.addAttribute("msg", "Successfully uploaded files " +
 * fileNames.toString());
 * 
 * return "Admin_Template"; }
 * 
 *//*****************************************************
	 * Here we End write code for add Language
	 *************************************************************************/
/*
 * 
 * @RequestMapping("/addlanguage") public String AddLanaguage(HttpServletRequest
 * req, Model model) {
 * 
 * String lang = req.getParameter("language");
 * 
 * language language = new language(); language.setLanguage(lang);
 * userservice.save(language);
 * 
 * return "redirect:/Language";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End write code for add language
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Star write
	 *************************************************************************/
/*
 * 
 * Here code for access category
 * 
 * @RequestMapping(value = "/addabc", method = RequestMethod.GET)
 * 
 * public ModelAndView addClassget(ModelAndView mv) {
 * 
 * ArrayList<UserReview> standard = (ArrayList<UserReview>)
 * classservice.findAll();
 * 
 * ArrayList<String> newNonExistClass = new ArrayList<String>();
 * 
 * newNonExistClass.add("Breast Crawl");
 * newNonExistClass.add("Cross cradle hold for breastfeeding ");
 * newNonExistClass.add("Breastfeeding latching");
 * newNonExistClass.add("Breastfeeding difficulties ");
 * newNonExistClass.add("Science of breastmilk");
 * newNonExistClass.add("Nipple conditions");
 * newNonExistClass.add("Breast conditions");
 * 
 * for (UserReview s : standard) {
 * 
 * if (newNonExistClass.contains(s.getName()))
 * newNonExistClass.remove(s.getName()); } mv.addObject("classExist",
 * newNonExistClass); mv.setViewName("Language");
 * 
 * return mv;
 * 
 * }
 * 
 *//*****************************************************
	 * ???????????
	 *************************************************************************/
/*

*//*****************************************************
	 * ???????????
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/addabc", method = RequestMethod.POST) public
 * ModelAndView addClassPost(@RequestParam(name = "classSelected") String
 * classSelected, ModelAndView mv) {
 * 
 * UserReview class_data = new UserReview();
 * 
 * class_data.setName(classSelected); classservice.save(class_data);
 * 
 * mv.addObject("status", "Ad		\n" + "		ded Sucessfully");
 * 
 * ArrayList<UserReview> standard = (ArrayList<UserReview>)
 * classservice.findAll();
 * 
 * ArrayList<String> newNonExistClass = new ArrayList<String>();
 * newNonExistClass.add("Class 1"); newNonExistClass.add("Class 2");
 * newNonExistClass.add("Class 3"); newNonExistClass.add("Class 4");
 * newNonExistClass.add("Class 5"); newNonExistClass.add("Class 6");
 * newNonExistClass.add("Class 7"); newNonExistClass.add("Class 8");
 * newNonExistClass.add("Class 9"); newNonExistClass.add("Class 10");
 * newNonExistClass.add("Class 11"); newNonExistClass.add("Class 12");
 * 
 * for (UserReview s : standard) { if (newNonExistClass.contains(s.getName()))
 * newNonExistClass.remove(s.getName());
 * 
 * }
 * 
 * mv.addObject("classExist", newNonExistClass); mv.setViewName("addclass");
 * return mv;
 * 
 * }
 * 
 *//*****************************************************
	 * ???????????
	 *************************************************************************/
/*

*//*****************************************************
	 * here We write code for Upload tutorial
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/uploadTutorial", method = RequestMethod.GET) public
 * String list(Model model) {
 * 
 * List<UserReview> name = classservice.findAll();
 * 
 * model.addAttribute("products", name);
 * 
 * System.out.println("Returning rpoducts:");
 * 
 * return "Upload_Video";
 * 
 * }
 * 
 * 
 * Here we feching information User by id
 * 
 * 
 * @RequestMapping("product/{id}") public String showProduct(@PathVariable
 * Integer id, Model model) {
 * 
 * model.addAttribute("product", classservice.getProductById(id));
 * 
 * return "productshow";
 * 
 * }
 * 
 *//*****************************************************
	 * Here We end upload Testimonial
	 *************************************************************************/
/*
 * 
 * Here we Edit information User by id
 * 
 * @RequestMapping("product/edit/{id}") public String edit(@PathVariable Integer
 * id, Model model, HttpServletRequest req) {
 * 
 * String categoryName = req.getParameter("name");
 * 
 * System.err.println(categoryName);
 * 
 * UserReview user = classservice.getProductById(id);
 * 
 * user.setName(categoryName);
 * 
 * userservice.saveProduct(user);
 * 
 * model.addAttribute("product", classservice.getProductById(id));
 * 
 * System.err.println(categoryName);
 * 
 * return "productform";
 * 
 * }
 * 
 * Here we Edit and new item information User by id
 * 
 * @RequestMapping("product/new") public String newProduct(Model model) {
 * model.addAttribute("product", new UserReview());
 * 
 * return "productform"; }
 * 
 *//*****************************************************
	 * Here Start Write code to Show category
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/show_category", method = RequestMethod.GET) public
 * String showcategory(Model model) {
 * 
 * List<UserReview> name = classservice.findAll();
 * 
 * model.addAttribute("products", name);
 * 
 * return "Show_category"; }
 * 
 *//*****************************************************
	 * Here End Write code to Show category
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to Show Testimonial
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/show_testimonial", method = RequestMethod.GET)
 * 
 * public String showtestimonial(Model model) {
 * 
 * List<Testimonial> name = testimonialService.findAll();
 * 
 * model.addAttribute("testimonials", name);
 * 
 * return "Show_Testimonial";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to End show testimonial
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Write code to Edit Testimonial
	 *************************************************************************/
/*
 * 
 * @RequestMapping("productTesdtimonial/edit/{id}") public String
 * editconsalantantDemo(@PathVariable Integer id, Model model,
 * HttpServletRequest req) {
 * 
 * Testimonial testimonial = new Testimonial();
 * 
 * testimonial = testimonialService.getProductById(id);
 * 
 * model.addAttribute("testimonials", testimonial);
 * 
 * return "Update_Testimonial";
 * 
 * }
 * 
 *//*****************************************************
	 * Here Write code to End Edit Testimonial
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Write code to update Testimonial
	 ****************************************************************************/
/*
 * 
 * @RequestMapping(value = "/updateTetimonial", method = RequestMethod.POST)
 * public String updateTestimonial(HttpServletRequest
 * req, @RequestParam("uploadTestiminial") MultipartFile[] files) {
 * 
 * String id = req.getParameter("testimonialId"); String path = null; String
 * nametestimonial = req.getParameter("testimonialName"); String
 * descriptionTestimonial = req.getParameter("testimoniaqlDescription"); int
 * testimonial_id = Integer.parseInt(id);
 * 
 * String abc = uploadDirectoryConsaltant + "/" + nametestimonial; new
 * File(abc).mkdir();
 * 
 * StringBuilder fileNames = new StringBuilder(); for (MultipartFile file :
 * files) { Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
 * fileNames.append(file.getOriginalFilename() + " ");
 * 
 * try { Files.write(fileNameAndPath, file.getBytes()); fileconversion =
 * fileNameAndPath.toString();
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 * 
 * String substring = fileconversion.substring(26);
 * 
 * String var = substring.toString(); System.out.println(var);
 * 
 * testimonialService.updateTestimonial(nametestimonial, descriptionTestimonial,
 * var, testimonial_id);
 * 
 * System.err.println(uploadDirectory);
 * 
 * return "redirect:/show_testimonial";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End code update to Testimonial
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to delete Testimonial
	 *************************************************************************/
/*
 * 
 * @RequestMapping("testimonial/delete/{id}") public String
 * deleteTestimonial(@PathVariable Integer id, Model model, ModelAndView mv) {
 * 
 * testimonialService.deleteProduct(id);
 * 
 * return "redirect:/show_testimonial";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to Event delete
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to delete consalantant
	 *************************************************************************/
/*
 * 
 * @RequestMapping("product/delete/{id}") public String delete(@PathVariable
 * Integer id, Model model, ModelAndView mv) {
 * 
 * testimonialService.deleteProduct(id);
 * 
 * return "redirect:/show_testimonial";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to delete consalantant
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to show consalantant
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/show_consalantant", method = RequestMethod.GET)
 * 
 * public String showconsaltant(Model model) {
 * 
 * List<Consaltantant> name = consaltantservice.findAll();
 * 
 * model.addAttribute("products", name);
 * 
 * return "Show_Consaltant";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to show consalantant
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to consalantant delete
	 *************************************************************************/
/*
 * 
 * @RequestMapping("consalantant/delete/{id}") public String
 * deleteconsalantant(@PathVariable Integer id, Model model, ModelAndView mv) {
 * 
 * consaltantservice.deleteProduct(id);
 * 
 * return "redirect:/show_consalantant";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to consalantant delete
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to consalantant select by id for Edit
	 *************************************************************************/
/*
 * 
 * Here we Edit information User by id
 * 
 * @RequestMapping("productconsalantant/edit/{id}") public String
 * editconsalantant(@PathVariable Integer id, Model model, HttpServletRequest
 * req) {
 * 
 * Consaltantant consaltantant = consaltantservice.getProductById(id);
 * 
 * model.addAttribute("products", consaltantant);
 * 
 * return "Update_Consalantant";
 * 
 * return "Update _ConsalantantTwo";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to consalantant select by id for Edit
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Write code to update consalantant
	 *************************************************************************/
/*
 * 
 * String fileconversion;
 * 
 * @RequestMapping(value = "/consalantantupdate", method = RequestMethod.POST)
 * public String uploadConsaltantUpdate(HttpServletRequest req,
 * 
 * @RequestParam("uploadConsaltantImage") MultipartFile[] files) {
 * 
 * String id = req.getParameter("productId");
 * 
 * String path = null; String nameConsaltant =
 * req.getParameter("nameConsaltant"); String descriptionConsaltant =
 * req.getParameter("descriptionConsaltant"); int consalantant_id =
 * Integer.parseInt(id);
 * 
 * System.out.println("hi" + consalantant_id); System.err.println("Hi" +
 * consalantant_id); System.err.println(descriptionConsaltant);
 * System.out.println(nameConsaltant);
 * 
 * String abc = uploadDirectoryConsaltant + "/" + nameConsaltant; new
 * File(abc).mkdir();
 * 
 * StringBuilder fileNames = new StringBuilder(); for (MultipartFile file :
 * files) { Path fileNameAndPath = Paths.get(abc, file.getOriginalFilename());
 * fileNames.append(file.getOriginalFilename() + " ");
 * 
 * try { Files.write(fileNameAndPath, file.getBytes()); fileconversion =
 * fileNameAndPath.toString();
 * 
 * } catch (IOException e) { e.printStackTrace(); } }
 * 
 * String substring = fileconversion.substring(26);
 * 
 * String var = substring.toString(); System.out.println(var);
 * 
 * consaltantservice.UpdateConsalantant(descriptionConsaltant, nameConsaltant,
 * var, consalantant_id);
 * 
 * System.err.println(uploadDirectory);
 * 
 * return "Admin_Template";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End code update of consalantant
	 *************************************************************************/
/*

*//*****************************************************
	 * Here we write code for add Event
	 *************************************************************************/
/*
 * 
 * @RequestMapping("/addEvent") public String addEvent(HttpServletRequest req,
 * Model model) {
 * 
 * System.out.println(req.getParameter("eventname"));
 * 
 * String eventname = req.getParameter("eventname"); String date =
 * req.getParameter("date"); String description =
 * req.getParameter("description"); String venuename =
 * req.getParameter("venuename"); String contactperson =
 * req.getParameter("contactperson"); String contactnumber =
 * req.getParameter("contactnumber"); String email = req.getParameter("email");
 * 
 * System.out.println(eventname + "" + date + "" + description);
 * 
 * com.example.demo.Model.Event event1 = new com.example.demo.Model.Event();
 * 
 * event1.setEventname(eventname); event1.setDate(date);
 * event1.setDescription(description); event1.setVenuename(venuename);
 * event1.setContactperson(contactperson);
 * event1.setContactnumber(contactnumber); event1.setEmail(email);
 * model.addAttribute("msg", "Succefully Add Event");
 * 
 * userservice.save(event1);
 * 
 * return "addEvent";
 * 
 * }
 * 
 *//*****************************************************
	 * Here we end write code for add Event
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to show Event
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/show_Event", method = RequestMethod.GET) public
 * String showEvent(Model model) {
 * 
 * List<com.example.demo.Model.Event> name = eventService.findAll();
 * 
 * model.addAttribute("events", name);
 * 
 * return "Show_Event";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to show event
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to Event delete
	 *************************************************************************/
/*
 * 
 * @RequestMapping("event/delete/{id}")
 * 
 * public String deleteEvent(@PathVariable Integer id, Model model, ModelAndView
 * mv) {
 * 
 * eventService.deleteProduct(id);
 * 
 * return "redirect:/show_Event";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to Event delete
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Start Write code to Event select by id for Edit
	 *************************************************************************/
/*
 * 
 * Here we Edit information User by id
 * 
 * @RequestMapping("event/edit/{id}") public String editEvent(@PathVariable
 * Integer id, Model model, HttpServletRequest req) {
 * 
 * com.example.demo.Model.Event event = eventService.getProductById(id);
 * 
 * model.addAttribute("events", event);
 * 
 * return "Update_Event";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End Write code to Event select by id for Edit
	 *************************************************************************/
/*

*//*****************************************************
	 * Here Write code to update Event
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/eventUpdate", method = RequestMethod.POST) public
 * String eventUpdate(HttpServletRequest req) { String eventname =
 * req.getParameter("eventname"); String date = req.getParameter("date"); String
 * description = req.getParameter("description"); String venuename =
 * req.getParameter("venuename"); String contactperson =
 * req.getParameter("contactperson"); String contactnumber =
 * req.getParameter("contactnumber");
 * 
 * String email = req.getParameter("email");
 * 
 * String id_event = req.getParameter("eventId");
 * 
 * int id = Integer.parseInt(id_event);
 * 
 * eventService.UpdateEvent(eventname, date, description, venuename,
 * contactperson, contactnumber, email, id);
 * 
 * return "redirect:/show_Event";
 * 
 * }
 * 
 *//*****************************************************
	 * Here End code update of Event
	 *************************************************************************/
/*

*//*****************************************************
	 * Here we write code for mapping hibernate One To Many Relationship
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/category_laguage", method = RequestMethod.POST)
 * public String addcategoryLanguge(HttpServletRequest req, Model model,
 * 
 * @RequestParam(name = "language_select") List<String> language_select) {
 * 
 * {
 * 
 * String categoryName = req.getParameter("category");
 * System.err.println(categoryName);
 * 
 * List<CategorynNEW> local = new ArrayList<CategorynNEW>();
 * 
 * CategorynNEW data = new CategorynNEW(); data.setCategoryName(categoryName);
 * local.add(data);
 * 
 * Iterator<String> iter = language_select.iterator();
 * 
 * System.out.println("\nThe iterator values" + " of list are: "); for (String
 * temp : language_select) {
 * 
 * System.err.println(temp);
 * 
 * languageNew a1 = catlanservice.getProductById(Integer.parseInt(temp));
 * 
 * data.setLanNew(a1);
 * 
 * a1.getList().addAll(local);
 * 
 * languagNewDao.save(a1);
 * 
 * } model.addAttribute("msg", "Successfully upload File");
 * 
 * return "Admin_Template";
 * 
 * }
 * 
 * }
 * 
 *//*****************************************************
	 * Here End write code for mapping hibernate One To Many Relationship
	 *************************************************************************/
/*

*//*****************************************************
	 * Here access value form languageNew table
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/languageShow", method = RequestMethod.GET)
 * 
 * public String showlanguage(Model model) {
 * 
 * List<languageNew> name = (List<languageNew>) LanguageService.findAll();
 * 
 * for (languageNew a : name) { System.out.println(a.getLanguageName()); }
 * model.addAttribute("languages", name);
 * 
 * return "addcategoryLanguage";
 * 
 * }
 * 
 *//*****************************************************
	 * Here end access value form languageNew table
	 *************************************************************************/
/*

*//*****************************************************
	 * Here we access value from language table
	 *************************************************************************/
/*
 * 
 * @RequestMapping(value = "/tutorialShow", method = RequestMethod.GET) public
 * String tutorialShow(Model model) {
 * 
 * List<languageNew> name = (List<languageNew>) LanguageService.findAll();
 * 
 * List<CategorynNEW> categoryName = (List<CategorynNEW>)
 * categoryNewDao.findAll();
 * 
 * for (languageNew a : name) { System.out.println(a.getLanguageName());
 * 
 * System.err.println(a.getList());
 * 
 * } model.addAttribute("languages", name); model.addAttribute("categorys",
 * categoryName);
 * 
 * return "adduploadTutorial";
 * 
 * }
 * 
 *//*****************************************************
	 * Here we access value from language tab
	 *************************************************************************/
/*

*//*****************************************************
	 * Here we access value from language table by categorr name
	 *************************************************************************/
/*
 * 
 * 
 * 
 * 
 * @RequestMapping(value = "/showTutorialLanguageDemo",method =
 * RequestMethod.GET) public String tutorialShowDemo(Model
 * model,HttpServletRequest request) {
 * 
 * 
 * String selectedValue=request.getParameter("classSelected");
 * 
 * 
 * List<String> topicName=new ArrayList<String>();
 * 
 * Boolean
 * categoryNewName=categoryNewService.findCategoryNewName(selectedValue);
 * 
 * 
 * 
 * return selectedValue;
 * 
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 *//*****************************************************
	 * Here we access value from language table by categorr name
	 *************************************************************************/
/*
 * 
 * 
 * @RequestMapping(value = "/showTutorialLanguageDemo",method =
 * RequestMethod.POST) public @ResponseBody List<String>
 * showTutorialLanguage(@Valid @RequestBody categorNewyAjaxQueryResolver
 * categoryNewSelect) {
 * 
 * System.out.println("adashdgashgdhas"); List<String> data=new
 * ArrayList<String>();
 * 
 * List<CategorynNEW>
 * categoryNewName=categoryNewService.findByCategoryNewName(categoryNewSelect.
 * getCategoryNewName());
 * 
 * for(CategorynNEW local:categoryNewName){
 * 
 * 
 * System.err.println("develop language"+local.getLanNew().getLanguageName());
 * 
 * 
 * }
 * 
 * return data;
 * 
 * 
 * 
 * }
 * 
 *//*************************************************
	 * Only Role******************************
	 *//*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * }
		 */