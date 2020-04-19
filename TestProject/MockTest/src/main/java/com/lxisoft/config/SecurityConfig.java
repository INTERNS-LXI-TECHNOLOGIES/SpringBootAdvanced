package com.lxisoft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("adarsh").password("123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/home").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
			.antMatchers("/user").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			.and().formLogin()
			.and()
			.httpBasic()
			.and()
			.logout()
			.logoutUrl("/j_spring_security_logout")
			.logoutSuccessUrl("/");
		
	}

}
