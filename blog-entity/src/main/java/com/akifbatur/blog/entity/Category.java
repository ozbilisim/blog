package com.akifbatur.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Akif Batur
 * 
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@Table(name = "CATEGORY", catalog = "BLOG")
public class Category implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Category()
    {
        super();
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "CATEGORY_TITLE", unique = true, nullable = false)
    private String categoryTitle;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Column(name = "EDIT_DATE", nullable = false)
    private Date editDate;

    @OneToMany(mappedBy = "category")
    private List<Blog> blogs = new ArrayList<Blog>();

    @ManyToOne
    @JoinTable(name = "CATEGORY_USER", joinColumns =
    { @JoinColumn(name = "CATEGORY_ID") }, inverseJoinColumns =
    { @JoinColumn(name = "USER_ID") })
    private User user;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCategoryTitle()
    {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle)
    {
        this.categoryTitle = categoryTitle;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public Date getEditDate()
    {
        return editDate;
    }

    public void setEditDate(Date editDate)
    {
        this.editDate = editDate;
    }

    public List<Blog> getBlogs()
    {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs)
    {
        this.blogs = blogs;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
