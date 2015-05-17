package demo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.model.Usertable;
import demo.repository.UserRepository;
import demo.repository.UserTableSpecification;

@Controller
public class DatabaseController {
	
	@Autowired
	UserRepository userRepo;
	
	
    
    static Logger log = Logger.getLogger(DatabaseController.class);
    
    @RequestMapping(value="/usertable", method=RequestMethod.GET)
    public @ResponseBody List<Usertable> getUser(HttpServletResponse response) {
    	log.info("user table");
    	
//    	CriteriaBuilder builder = em.getCriteriaBuilder();
//    	CriteriaQuery<Usertable> query = builder.createQuery(Usertable.class);
//    	Root<Usertable> root = query.from(Usertable.class);
//
//    	Predicate hasBirthday = builder.equal(root.get(Customer_.birthday), today);
    	return (List<Usertable>) userRepo.findAll();
    }
    
}
