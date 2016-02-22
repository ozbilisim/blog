package com.akifbatur.blog.persist.repository;

import com.akifbatur.blog.entity.Blog;

/**
 * @author Akif Batur
 * 
 * Repository interface for Repository: BlogRepositoryImpl
 * 
 */
public interface BlogRepository
{
    public void saveBlog(Blog blog);
}
