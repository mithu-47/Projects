/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 *
 * @author LENOVO
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ADMIN").password("").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("DEVELOPER").password("").roles("DEVELOPER");
        auth.inMemoryAuthentication().withUser("BUSINESS_EXECUTIVE").password("").roles("BUSINESS_EXECUTIVE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.csrf().disable().authorizeRequests().antMatchers("/getUserList").hasRole("ADMIN").and().httpBasic().authenticationEntryPoint(authEntryPoint);    
         http.csrf().disable().authorizeRequests().antMatchers("/getMyTransactions","/insertMyTransaction").hasRole("DEVELOPER").and().httpBasic().authenticationEntryPoint(authEntryPoint);    
         http.csrf().disable().authorizeRequests().antMatchers("/getMyReport").hasRole("BUSINESS_EXECUTIVE").and().httpBasic().authenticationEntryPoint(authEntryPoint);    
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
