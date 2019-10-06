package com.codebasket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class AppConfiguration {

	String username = "user";
	String password = "userPass";

	String adminName = "admin";
	String adminPass = "adminPass";

	String user = "USER";
	String admin = "ADMIN";

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http.csrf().disable().authorizeExchange().pathMatchers(HttpMethod.POST, "/api/v2/react/multi-value")
				.hasAuthority("ROLE_" + admin).pathMatchers("/api/v2/react/header").hasAuthority("ROLE_" + user)
				.anyExchange().authenticated().and().httpBasic().and().formLogin().disable().build();
	}

	@Bean
	public MapReactiveUserDetailsService userDetailsService() {

		UserDetails userD = User.builder().username(username).password(encoder().encode(password)).roles(user)
				.build();
		UserDetails adminD = User.builder().username(adminName).password(encoder().encode(adminPass)).roles(admin)
				.build();
		return new MapReactiveUserDetailsService(userD, adminD);
	}
}
