package com.codebasket.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.codebasket.security.RestAuthentication;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthentication restAuthentication;

	// Configure in memory authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		String username = "admin";
		auth.inMemoryAuthentication().withUser(username).password(encoder().encode("adminPass")).roles("ADMIN").and()
				.withUser("user").password(encoder().encode("userPass")).roles("USER");
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().and().exceptionHandling()
				.authenticationEntryPoint(restAuthentication).and().authorizeRequests()
				.antMatchers("/healthcheck").hasRole("ADMIN") // Place secure uri under this
				.antMatchers("/check").hasRole("USER") 
				.anyRequest().authenticated().and().formLogin()
				.successHandler(new SimpleUrlAuthenticationSuccessHandler())
				.failureHandler(new SimpleUrlAuthenticationFailureHandler()).and().httpBasic().and().logout();
	}
}
