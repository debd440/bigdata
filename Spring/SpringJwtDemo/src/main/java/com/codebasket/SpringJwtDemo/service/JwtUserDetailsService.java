package com.codebasket.SpringJwtDemo.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Inside Service Class Fr username:"+username);
		if ("codebasket".equals(username)) {
			return new User(username, "$2y$12$sNHkgxuJaKHEvWM4gboOK.E7ioqjcC.ZX/GHtzaRaBXkvyGASC9Cm",
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}