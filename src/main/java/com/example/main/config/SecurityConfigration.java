package com.example.main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebSecurity
@Configuration
public class SecurityConfigration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure (HttpSecurity httpsecurity) {
		try {
			//use it with out no authentication
			httpsecurity.authorizeRequests().anyRequest().permitAll().and().httpBasic();
			//only authorize /hello
			//httpsecurity.authorizeRequests().antMatchers("**/hello").hasRole("USER").anyRequest().permitAll().and().httpBasic();
			
			//httpsecurity.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
			httpsecurity.csrf().disable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("nathan").password("123456").roles("USER").and().withUser("natan").password("123456").roles("ADMIN");	
	}

}
