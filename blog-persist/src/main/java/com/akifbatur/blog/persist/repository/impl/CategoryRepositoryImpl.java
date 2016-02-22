package com.akifbatur.blog.persist.repository.impl;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.akifbatur.blog.entity.Category;
import com.akifbatur.blog.persist.repository.CategoryRepository;

/**
 * @author Akif Batur
 * 
 * Repository implementation class for Repository: CategoryRepository
 * 
 */
@Repository("categoryRepository")
public class CategoryRepositoryImpl implements CategoryRepository
{
    private static final Logger logger = LoggerFactory.getLogger(CategoryRepositoryImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCategory(Category category)
    {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(category);
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("CategoryRepository initialized.");
    }
}