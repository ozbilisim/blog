package com.akifbatur.blog.persist.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akifbatur.blog.entity.User;
import com.akifbatur.blog.persist.repository.UserRepository;
import com.akifbatur.blog.persist.service.UserService;

/**
 * @author Akif Batur
 * 
 * Service implementation class for Service: UserService
 * 
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void saveUser(User user)
    {
        userRepository.saveUser(user);
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("UserService initialized.");
    }
}