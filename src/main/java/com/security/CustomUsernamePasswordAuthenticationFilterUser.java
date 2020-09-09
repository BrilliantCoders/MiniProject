package com.security;

import com.helper.GlobalVariables;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomUsernamePasswordAuthenticationFilterUser extends UsernamePasswordAuthenticationFilter {

    public CustomUsernamePasswordAuthenticationFilterUser(){
        this.setFilterProcessesUrl("/user/loginTest");

    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String languageParam = request.getParameter("course");
        request.getSession().setAttribute("course", languageParam);
        request.getSession().setAttribute("type", "user");
        GlobalVariables.setCourse(languageParam);
        GlobalVariables.setRegNo(request.getParameter("username"));
        System.out.println("UserFilter" + languageParam);
        // You can do your stuff here
        return super.attemptAuthentication(request, response);
    }
}