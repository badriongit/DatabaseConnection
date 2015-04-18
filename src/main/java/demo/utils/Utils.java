package demo.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import demo.services.UserRepositoryUserDetailsService.UserRepositoryUserDetails;
import demo.model.Usertable;

public class Utils {
	public static Usertable getCurrentUserDetails() {
		Authentication a = SecurityContextHolder.getContext()
				.getAuthentication();
		return ((UserRepositoryUserDetails) a.getPrincipal());
	}
	
}
