package com.akifbatur.blog.persist.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.transaction.annotation.Transactional;

import com.akifbatur.blog.entity.User;
import com.akifbatur.blog.persist.repository.UserRepository;
import com.akifbatur.blog.persist.service.LoginService;
import com.akifbatur.blog.entity.Role;

/**
 * @author Akif Batur
 * 
 * Service implementation class for Service: LoginService
 * 
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService, UserDetailsService
{
    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        logger.info("User "+ username +" is trying to login.");
        User user = userRepository.getUserByUsername(username);
        if (user == null)
        {
            logger.error("User "+ username +" is not found.");
            throw new UsernameNotFoundException("Username not found.");
        }
        else
        {
            List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        }
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities)
    {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> roles)
    {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        roles.forEach(role -> setAuths.add(new SimpleGrantedAuthority(role.getRoleTitle())));
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("LoginService initialized.");
    }
}