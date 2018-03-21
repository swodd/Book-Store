/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.config;

import com.swodd.backend.service.UserSecurityService;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;


/**
 *
 * @author User
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private Environment env;
    
    @Autowired
    private UserSecurityService userSecurityService;
    
    private BCryptPasswordEncoder passwordEncoder(){
        return SecurityUtility.passwordEncoder();
    }
    
    private static final String[] PUBLIC_MATCHERS = {
        "/css/**",
        "/js/**",
        "/image/**",
        "/book/**",
        "/user/**"
    };
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public HttpSessionStrategy httpSessionStrategy(){
        return new HeaderHttpSessionStrategy();
    }
    
}
