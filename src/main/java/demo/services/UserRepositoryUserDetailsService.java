package demo.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.model.Usertable;
import demo.repository.UserRepository;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

//	
//	public UserRepositoryUserDetailsService(UserRepository userRepository) {
//		System.out.println("Inside Constructor...");
//		this.userRepository = userRepository;
//	}
//	
	

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usertable user = null;

		
			user = userRepository.findOne(userName);
			System.out.println("Getting " + userName + " bean : "
					+ userRepository.findOne(userName).getUserid());
		

		if (user == null) {
			System.out.println("user is null...");
			
		}
		System.out.println("Returning value...");
		return new UserRepositoryUserDetails(user);
	}

	public final static class UserRepositoryUserDetails extends Usertable
			implements UserDetails {
		//private UserT tempUserT = null;

		private UserRepositoryUserDetails(Usertable user) {
			super(user);
			//tempUserT = user;
		}
		
		

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
		    return null;
			//authlist.add(new GrantedAuthorityImpl("ROLE_AUTHORIZED_USER"));
		}

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return getUserid();
		}
		
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return getPasswd();
		}
		
	

//		@Override
//		public String getUserId() {
//			return getUserId();
//		}
//
//		
//
//		@Override
//		public String getSupervisorUserId() {
//			// TODO Auto-generated method stub
//			return tempUserT.getSupervisorUserId();
//		}
//
//		@Override
//		public String getSupervisorUserName() {
//			// TODO Auto-generated method stub
//			return tempUserT.getSupervisorUserName();
//		}
//
//		@Override
//		public String getTempPassword() {
//			// TODO Auto-generated method stub
//			return tempUserT.getTempPassword();
//		}
//
//		@Override
//		public String getUserEmailId() {
//			// TODO Auto-generated method stub
//			return tempUserT.getUserEmailId();
//		}
//
//		@Override
//		public String getUserGeography() {
//			// TODO Auto-generated method stub
//			return tempUserT.getUserGeography();
//		}
//
//		@Override
//		public String getUserTelephone() {
//			// TODO Auto-generated method stub
//			return tempUserT.getUserTelephone();
//		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
		
	}
}
