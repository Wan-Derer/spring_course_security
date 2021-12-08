package com.zaurtregulov.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

    auth.inMemoryAuthentication()
      .withUser(userBuilder.username("admin").password("admin").roles("ADMIN"))
      .withUser(userBuilder.username("zaur").password("zaur").roles("EMPLOYEE"))
      .withUser(userBuilder.username("elena").password("elena").roles("HR"))
      .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER", "HR"))
    ;


  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
      .antMatchers("/").hasAnyRole("ADMIN", "EMPLOYEE", "HR", "MANAGER")
      .antMatchers("/hr_info").hasAnyRole("ADMIN", "HR")
      .antMatchers("/manager_info/**").hasAnyRole("ADMIN", "MANAGER")
      .and().formLogin().permitAll();

  }
}





