package com.akifbatur.blog.web.component;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author Akif Batur
 * 
 * Custom AuthenticationSuccessHandler implementation class.
 *
 */
@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException
    {
        // Log user details
        logger.info("User " + authentication.getName() + " is successfully logged-in.");
        logger.info(authentication.getDetails().toString());
        logger.info(authentication.getPrincipal().toString());
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("./");
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("CustomAuthenticationSuccessHandler initialized");
    }
}
