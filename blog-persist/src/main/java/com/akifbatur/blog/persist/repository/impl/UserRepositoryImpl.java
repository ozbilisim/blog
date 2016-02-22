package com.akifbatur.blog.persist.repository.impl;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akifbatur.blog.entity.User;
import com.akifbatur.blog.persist.repository.UserRepository;

/**
 * @author Akif Batur
 * 
 * Repository implementation class for Repository: UserRepository
 * 
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository
{
    private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("UserRepository initialized.");
    }

    @Override
    public User getUserByUsername(String username)
    {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where USERNAME = :username");
        query.setString("username", username);
        if (query.list().size() > 0)
        {
            User user = (User) query.list().get(0);
            return user;
        }
        else
        {
            return null;
        }
    }
}