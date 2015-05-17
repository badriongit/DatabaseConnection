package demo.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import demo.repository.UserRepository;
import demo.repository.UserTableSpecification;
import demo.model.Usertable;

@Component
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;  
	
	@PersistenceContext(unitName = "application")
	private EntityManager em;
	
	public Usertable findByUserId(String nameWith) throws Exception{
		
		
		
		

    	Usertable example = new Usertable();
    	example.setUserid("badri");
    	example.setPasswd("pass");
    	//example.setLastName("James");
    	//example.setEmployed(true);
    	UserTableSpecification personSpec = new UserTableSpecification(example);
    	List<Usertable> persons = userRepository.findAll(personSpec);
    	
    	//return persons;
		
		
		
		logger.debug("Inside findByUserName Service");
		Usertable users = userRepository.findOne(nameWith);
		
		if (users == null)
		{
			logger.error("NOT_FOUND: No matching user found");
		}			
		
		return users;
	}

	public String insertUser(Usertable user) {
	   user = userRepository.save(user);
	   return user.getUserid();
	}

}
