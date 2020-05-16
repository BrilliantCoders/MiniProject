package com.security;

import com.helper.GlobalVariables;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomUsernamePasswordAuthenticationFilter(){
        this.setFilterProcessesUrl("/admin/loginTest");

    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final String languageParam = request.getParameter("course");
        request.getSession().setAttribute("course", languageParam);
        request.getSession().setAttribute("type", "admin");
        GlobalVariables.course=languageParam;
        System.out.println("Filter" + languageParam);
        // You can do your stuff here

        return super.attemptAuthentication(request, response);
    }
}