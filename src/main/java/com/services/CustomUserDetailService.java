package com.services;

import org.apache.catalina.realm.AuthenticatedUserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.entity.CustomerDetail;
import com.entity.UserBean;
import com.repository.JPARepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	JPARepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean user = userRepo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException(username);
		}
		return new CustomerDetail(user);
	}

}
