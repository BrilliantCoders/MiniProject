package com.security;


import com.helper.GlobalVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true,proxyTargetClass=true)
@Configuration

@Order(999)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    DriverManagerDataSource dataSource;



    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/portaldb");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("root");
        return driverManagerDataSource;
    }



    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
       // ds_mca_second_student
        auth.getDefaultUserDetailsService();
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select UserName as username,Password as password,Active as enabled from adminLogin " +
                                "where UserName=?")

                .authoritiesByUsernameQuery(
                        "select UserName as username,Role as role from adminLogin where UserName=?");
    }

    @Bean
    public CustomUsernamePasswordAuthenticationFilter exUsernamePasswordAuthenticationFilter()
            throws Exception {
        CustomUsernamePasswordAuthenticationFilter exUsernamePasswordAuthenticationFilter = new CustomUsernamePasswordAuthenticationFilter();
        exUsernamePasswordAuthenticationFilter
                .setAuthenticationManager(authenticationManagerBean());

        return exUsernamePasswordAuthenticationFilter;
    }

    @Bean(name = "manager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }



    @Override
    public void configure(HttpSecurity http) throws Exception {
        http

                .antMatcher("/admin/**")
                .authorizeRequests()
                .anyRequest()
                .access("hasRole('ROLE_ADMIN')")
                //.authenticated()
                //.hasRole("ROLE_ADMIN")

                .and()
                .formLogin()
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin/dashboard", true)
                .permitAll()
                .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login")
                .and()
                .addFilterBefore(exUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);



        http.csrf().disable();




    }
}