package com.akifbatur.blog.persist.repository;

import com.akifbatur.blog.entity.Category;

/**
 * @author Akif Batur
 * 
 * Repository interface for Repository: CategoryRepositoryImpl
 * 
 */
public interface CategoryRepository
{
    public void saveCategory(Category category);
}
