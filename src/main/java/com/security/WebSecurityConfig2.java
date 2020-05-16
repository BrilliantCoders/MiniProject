package com.security;


import com.helper.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@Configuration
@Order(1000)
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {


    @Autowired
    DriverManagerDataSource dataSource;

    @Autowired
    AuthenticationManager manager;


    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("Courses user "+GlobalVariables.course);

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select RegNo as username,Password as password,Active as enabled from  "
                                +"ds_mca_second_student where RegNo=?")

                .authoritiesByUsernameQuery(
                        "select RegNo as username,Role as role from ds_mca_second_student where RegNo=?");
    }

    @Bean
    public CustomUsernamePasswordAuthenticationFilterUser exUsernamePasswordAuthenticationFilterUser()
            throws Exception {
        CustomUsernamePasswordAuthenticationFilterUser exUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilterUser();
        exUsernamePasswordAuthenticationFilter
                .setAuthenticationManager(manager);

        return exUsernamePasswordAuthenticationFilter;
    }






    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/user/**")
                .authorizeRequests().anyRequest()
                .access("hasRole('ROLE_USER')")//.authenticated()
                .and().formLogin().loginPage("/user/login")
                .defaultSuccessUrl("/user/dashboard", true)
                .permitAll()
                .and().logout().logoutSuccessUrl("/user/login")
                 .and()
                .addFilterBefore(exUsernamePasswordAuthenticationFilterUser(), UsernamePasswordAuthenticationFilter.class);;



        http.csrf().disable();
    }
}