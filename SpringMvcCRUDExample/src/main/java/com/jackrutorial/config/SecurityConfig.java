package com.jackrutorial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jackrutorial.dao.InicioSecionReq;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
@ComponentScan(basePackageClasses = SecurityConfig.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private InicioSecionReq inicioSesion;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
		.antMatchers("/customLogin.jsp").permitAll()
		.antMatchers("/index/**").hasRole("ADMIN")
		.antMatchers("/userRole/**").hasRole("USER")
		.and().formLogin()  //login configuration
        .loginPage("/customLogin.jsp")
        .loginProcessingUrl("/appLogin")
        .usernameParameter("app_username")
        .passwordParameter("app_password")
        .defaultSuccessUrl("/dafult/defaultAuth")
		.and().logout()    //logout configuration
		.logoutUrl("/appLogout") 
		.logoutSuccessUrl("/customLogin.jsp")
		.and().exceptionHandling(); //exception handling configuration
		//.accessDeniedPage("access-denied.jsp");
	} 
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inicioSesion).passwordEncoder(passwordEncoder());
	}
    @Bean
    public PasswordEncoder passwordEncoder() {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	return passwordEncoder;
    }
}  


