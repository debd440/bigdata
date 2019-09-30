package com.codebasket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

	String username = "B2C";
	String password = "Password";

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		return http.csrf().disable().authorizeExchange().pathMatchers("/").permitAll().anyExchange().authenticated()
				.and().httpBasic().and().formLogin().disable().build();
	}

	@Bean
	public MapReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.builder().username(username).password(encoder().encode(password)).roles("USER").build();
		return new MapReactiveUserDetailsService(user);
	}
}
