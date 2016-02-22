package com.akifbatur.blog.persist.service.impl;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.akifbatur.blog.entity.Category;
import com.akifbatur.blog.persist.repository.CategoryRepository;
import com.akifbatur.blog.persist.service.CategoryService;

/**
 * @author Akif Batur
 * 
 * Service implementation class for Service: CategoryService
 * 
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService
{
    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void saveCategory(Category category)
    {
        categoryRepository.saveCategory(category);
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("CategoryService initialized.");
    }
}