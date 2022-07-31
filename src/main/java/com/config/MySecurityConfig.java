package com.config;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.entity.CustomerDetail;
import com.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().antMatchers("/public/**").permitAll().anyRequest().authenticated().and().httpBasic();//for basic authentication
		
		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().authorizeRequests().antMatchers("/verify").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER").antMatchers("/public/**").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/public/signin").loginProcessingUrl("/verify").defaultSuccessUrl("/user/home");//add custom roles
		//formLogin().loginPage("/public/signin").loginProcessingUrl("/verify");//for custom login page
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("admin").password(this.getEncodedPassword().encode("admin1234")).roles("ADMIN");
		//auth.inMemoryAuthentication().withUser("user").password(this.getEncodedPassword().encode("user1234")).roles("USER");
		auth.userDetailsService(customUserDetailService).passwordEncoder(getEncodedPassword());
	}
	
//	@Bean
//	public PasswordEncoder getEncodedPassword() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	@Bean
	public BCryptPasswordEncoder getEncodedPassword() {
		return new BCryptPasswordEncoder();
	}
} 	 	
