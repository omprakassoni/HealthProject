package com.health.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Question;
import com.health.model.Tutorial;
import com.health.model.User;
import com.health.model.contributor_Role;
import com.health.model.language;
import com.health.model.topic;
import com.health.repository.CategoryDao;
import com.health.repository.RoleRepository;
import com.health.repository.TutorialDao;
import com.health.repository.UserRepository;
import com.health.repository.UserRoleRepositary;
import com.health.repository.contributor_RoleDao;
import com.health.repository.languagedao;
import com.health.repository.topicRepositary;
import com.health.service.categoryService;
import com.health.service.tutorialService;

@Controller
public class controllerContributer {

	@Autowired
	private languagedao languageDao;

	@Autowired
	private UserRepository userRepositorydao;

	@Autowired
	private TutorialDao tutorialDao;

	@Autowired
	private CategoryDao CategoryDao;

	@Autowired
	private topicRepositary topicRepositarydao;
	
	
	@Autowired
	private RoleRepository rolerespositary;
	
	@Autowired
	private UserRoleRepositary  userRoleRepositary;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private categoryService categoryService;
	
	@Autowired
	private topicRepositary topicRepositaryDao;
	
	@Autowired
	private contributor_RoleDao contributor_RoleDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping("/addContributerLanguage")
	public String RevokeRequest(Model model) 
	{

		List<language> language = (List<com.health.model.language>) languageDao.findAll();

		model.addAttribute("lan", language);
		
		return "AddContributerLanguage";
		
	}

	/* show languages */
	@RequestMapping("/rovekeRequest")
	public String  revokelanguage(Model model,Authentication authentication)
	{
	
		int status=1;	
		User user=userRepository.findByUsername(authentication.getName());
		
		List<UserRole> userRole=(List<UserRole>)userRoleRepositary.findByStatusAndUser(status,user);	
		
		model.addAttribute("languages",userRole);
		
		return "revokeLanguages";	
	}	
	
	@RequestMapping("/revokeSubmition")
	public String revokeSubmition(Model model,Authentication authentications,@RequestParam(name="languageName") String languagename)
	{
		
		language language=languageDao.findBylanguageName(languagename);
		
		User user = userRepository.findByUsername(authentications.getName());
		

		int status =0 ;

		UserRole userRole = userRoleRepositary.findByLanguageAnduser(user,language);

		userRole.setStatus(status);

		userRoleRepositary.save(userRole);

		/* return "showContributer"; */
		
		return "revokeLanguages";	
	}
	
	@RequestMapping("/addScript")
	public String addScript(Model model, Authentication authentication, HttpServletRequest request) 
	{

		return "addContent";

	}

	@RequestMapping(value = "/addkeyword", method = RequestMethod.POST)
	public String addkeyword(Model model, Authentication authentication, HttpServletRequest request) {

		String keywordArea = request.getParameter("keywordArea");

		System.err.println(keywordArea);
		String autheticationName = authentication.getName();
		User user = userRepositorydao.findByUsername(autheticationName);

		

		return "addContent";

	}

	@RequestMapping("/outline")
	public @ResponseBody List<String> getTopicByCategory(@RequestParam(value = "id") String id,
			HttpServletRequest request) {

		System.err.println(id);

		List<String> topicName = new ArrayList<String>();
		/*
		 * List<String> topicName=new ArrayList<String>();
		 * 
		 * String outline=request.getParameter("editor"); System.err.println(outline);
		 * 
		 * Tutorial tutorialresoureses=new Tutorial();
		 * tutorialresoureses.setOutlin("outline");
		 */
		return topicName;

	}

		  @RequestMapping("/keyword")
		  public @ResponseBody List<String>
		  getTopicByKeyword(@RequestParam(value = "id") String keywordMessgae,
				  @RequestParam(value = "categorname") String categorname,
				  @RequestParam(value = "topicid") String topicid,
				  @RequestParam(value = "lanId") String lanId,Model model,Authentication authentication)
		 {
				  
			System.err.println(categorname+"sdfsdfs"+topicid);
	
			  List<String> topicName = new ArrayList<String>();
			  
			  String autheticationName = authentication.getName();
			  
			  User user = userRepositorydao.findByUsername(autheticationName);
			  
			  int status = 1;
			  
			  Tutorial tutorial = new Tutorial(keywordMessgae, status, user.getId());
			
			  tutorialDao.save(tutorial);
			  
			  if (tutorial.getKeywordStatusSet() == 1) {
			  
			  topicName.add("Save data Succefully");
			  
			  	}			  
			  return topicName;
			  
			  }
			/*
			 * Access the topic according to category  */
			
				  
			@RequestMapping("/loadTopicByCategoryContributor")
			public @ResponseBody  List<String> getTopicByCategoryContributor(@RequestParam(value="id") String categoryname )
			{  
		
				
			    List<String> topicName=new ArrayList<String>();
				
			    
				Category category=categoryService.findBycategoryname(categoryname);

				List<contributor_Role> contributor=contributor_RoleDao.findByContributorTopic(category);

				  for(contributor_Role s:contributor) 
				  {
					  
					  topicName.add(s.getTopic().getTopicname());
								  
				  }
					return topicName;  
		
			}
				
			@RequestMapping("/loadLanguageByTopicId")
			public @ResponseBody  List<String> getLanguageByTopic(@RequestParam(value="id") String TopicName )
			{  
		
				
			    List<String> topicName=new ArrayList<String>();
			    
			    topic topic=topicRepositarydao.findBytopicname(TopicName);
			    
				List<contributor_Role> contributor=contributor_RoleDao.findByContributorLanguage(topic);

				 for(contributor_Role s:contributor) 
				  {
					  
					  topicName.add(s.getLan().getLanguageName());
								  
				  }  
				
			
				return topicName;  
		
			}
			
			
			/* Tutorial index page redirected to upload individual content page */

		@RequestMapping("/submitTutorial")
		public String submitTutorial(Model model,@RequestParam(value="categoryName") String categoryId,@RequestParam(name="inputTopic") String inputTopic,@RequestParam(name="inputLanguage") String inputLanguage,Authentication authetication)
		{
						
				System.err.println(categoryId+"asdasd");
							
				Category catgory=categoryDao.findBycategoryname(categoryId);
				
				topic topic=topicRepositarydao.findBytopicname(inputTopic);
				
				com.health.model.language language=languageDao.findBylanguageName(inputLanguage);
				
				List<Tutorial> tutorial= (List<Tutorial>) tutorialDao.findAll();


				model.addAttribute("tutorials",tutorial);
						
				model.addAttribute("categoryName",catgory);
				
				model.addAttribute("inputTopic",topic);
				
				model.addAttribute("inputLanguage",language);
				
				String authticationName=authetication.getName();
				
				User user=userRepository.findByUsername(authticationName);
		
				return "addContent";
			
				
			}




}
