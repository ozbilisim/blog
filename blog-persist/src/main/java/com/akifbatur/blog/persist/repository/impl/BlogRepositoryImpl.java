package com.akifbatur.blog.persist.repository.impl;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akifbatur.blog.entity.Blog;
import com.akifbatur.blog.persist.repository.BlogRepository;

/**
 * @author Akif Batur
 * 
 * Repository implementation class for Repository: BlogRepository
 * 
 */
@Repository("blogRepository")
public class BlogRepositoryImpl implements BlogRepository
{
    private static final Logger logger = LoggerFactory.getLogger(BlogRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveBlog(Blog blog)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(blog);
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("BlogRepository initialized.");
    }
}