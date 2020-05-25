package com.lxisoft.mockExamSpringBoot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("adarsh").password("123456").roles("USER");
	}
	
//	public void configure(HttpSecurity http) throws Exception {
//		
//	}
}
