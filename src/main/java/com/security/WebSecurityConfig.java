package com.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true,proxyTargetClass=true)
@Configuration

@Order(999)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   /* @Autowired
    DriverManagerDataSource ds;
*/
   /* @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select RegNo as username,Password as password from ds_mca_second_student where RegNo=?");
    }*/


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}password").roles("ADMIN");
       */ /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select RegNo as username,Password as password from ds_mca_second_student where RegNo=?");*/






/*
        final String findUserQuery = "select RegNo as username,Password as password from ds_mca_second_student where RegNo=?";
        final String findRoles = "select username,role " + "from Roles "
                + "where username = ?";

        auth.jdbcAuthentication().dataSource(ds)
                .usersByUsernameQuery(findUserQuery)
                .authoritiesByUsernameQuery(findRoles);*/
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/admin/**")
                .authorizeRequests().anyRequest().authenticated()
                .and().formLogin().loginPage("/admin/login")
                .defaultSuccessUrl("/admin/dashboard", true)
                .permitAll()
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login");
        http.csrf().disable();

    }
}