package com.health.service;

import java.util.Set;


import com.health.domain.security.UserRole;
import com.health.model.Category;
import com.health.model.Consultant;
import com.health.model.ContributorAssignedTutorial;
import com.health.model.Event;
import com.health.model.Language;
import com.health.model.Question;
import com.health.model.Testimonial;
import com.health.model.Topic;
import com.health.model.User;
import com.health.model.UserIndianLanguageMapping;


public interface UserService {
	
	
	User findBytoken(String token);
	
	User findByUsername(String username);   // in use
	
	User findByEmail (String email);         // in use
	
	User createUser(User user, Set<UserRole> userRoles) throws Exception;    // in use 
	
	User save(User user);      // in use
	
	long getNewId();            // in use
	
	User addUserToCategory(User usr,Set<Category> categories);   // in use
	
	User addUserToTopic(User usr,Set<Topic> topics);              // in use
	
	User addUserToLanguage(User usr,Set<Language> languages);       // in use
	
	User addUserToQuestion(User usr,Set<Question> questions);     // in use
	
	User addUserToEvent(User usr,Set<Event> events);     // in use
	
	User addUserToConsultant(User usr,Set<Consultant> consultant);     // in use
	
	User addUserToTestimonial(User usr,Set<Testimonial> testi);     // in use
	
	User addUserToContributorTutorial(User usr,Set<ContributorAssignedTutorial> testi);     // in use
	
	User addUserToUserIndianMapping(User usr,Set<UserIndianLanguageMapping> userMapping);  

	
}
