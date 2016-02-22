package com.akifbatur.blog.persist.repository.impl;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akifbatur.blog.entity.Tag;
import com.akifbatur.blog.persist.repository.TagRepository;

/**
 * @author Akif Batur
 * 
 * Repository implementation class for Repository: TagRepository
 * 
 */
@Repository("tagRepository")
public class TagRepositoryImpl implements TagRepository
{
    private static final Logger logger = LoggerFactory.getLogger(TagRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveTag(Tag tag)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(tag);
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("TagRepository initialized.");
    }
}