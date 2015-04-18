package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.model.Usertable;
import demo.services.UserService;
import demo.utils.Utils;

@RestController
@RequestMapping("/user")
public class UserDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsController.class);

	@Autowired
	UserService userService;

	@Autowired
	ApplicationContext appContext;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Usertable findOne(
			@RequestParam(value = "fields", defaultValue = "all") String fields,
			@RequestParam(value = "view", defaultValue = "") String view,
			@RequestParam(value = "nameWith", defaultValue = "") String nameWith) throws Exception {
		logger.debug("Inside UserDetailsController /user GET");
		if (nameWith.equals("")) {
			logger.debug("nameWith is EMPTY");
			return Utils.getCurrentUserDetails();
		} else {
			Usertable user = userService.findByUserId(nameWith);
			return user;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
    public @ResponseBody String insertUser(
    		@RequestParam(value = "id") String id,
    		@RequestParam(value = "pwd") String pwd){
    	String userid="";
    	Usertable user = new Usertable();
    	user.setUserid(id);
    	user.setPasswd(pwd);
    	try{
    	userid = userService.insertUser(user);
    	} catch(Exception e){
    		return e.getMessage();
    	}
    	return userid + " inserted";
    }

}
