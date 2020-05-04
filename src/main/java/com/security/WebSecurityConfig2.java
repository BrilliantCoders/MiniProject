package com.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@Order(1000)
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {


    @Autowired
    DriverManagerDataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select RegNo as username,Password as password,Active as enabled from ds_mca_second_student " +
                                "where RegNo=?")

                .authoritiesByUsernameQuery(
                        "select RegNo as username,Role as role from ds_mca_second_student where RegNo=?");
    }

   /* @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER");
    }*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests().anyRequest()
                .access("hasRole('ROLE_USER')")//.authenticated()
                .and().formLogin().loginPage("/user/login")
                .defaultSuccessUrl("/user/dashboard", true)
                .permitAll()
                .and().logout().logoutSuccessUrl("/user/login");

        http.csrf().disable();
    }
}