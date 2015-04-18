package demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.model.Usertable;
import demo.repository.UserRepository;

@Controller
public class DatabaseController {
	
	@Autowired
	UserRepository userRepo;
    
    static Logger log = Logger.getLogger(DatabaseController.class);
    
    @RequestMapping(value="/usertable", method=RequestMethod.GET)
    public @ResponseBody List<Usertable> getUser(HttpServletResponse response) {
    	log.info("user table");
    	return (List<Usertable>) userRepo.findAll();
    }
    
}
