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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Akif Batur
 * 
 * Entity implementation class for Entity: Blog
 *
 */
@Entity
@Table(name = "BLOG", catalog = "BLOG")
public class Blog implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Blog()
    {

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "BLOG_TITLE", unique = true, nullable = false)
    private String blogTitle;

    @Column(name = "BLOG_BODY", unique = true, nullable = false)
    private String blogBody;

    @Column(name = "CREATE_DATE", nullable = false)
    private Date createDate;

    @Column(name = "EDIT_DATE", nullable = false)
    private Date editDate;

    @ManyToOne
    @JoinTable(name = "BLOG_CATEGORY", joinColumns =
    { @JoinColumn(name = "BLOG_ID") }, inverseJoinColumns =
    { @JoinColumn(name = "CATEGORY_ID") })
    private Category category;

    @ManyToMany
    @JoinTable(name = "BLOG_TAG", joinColumns = @JoinColumn(name = "BLOG_ID") , inverseJoinColumns = @JoinColumn(name = "TAG_ID") )
    private List<Tag> tags = new ArrayList<Tag>();

    @ManyToOne
    @JoinTable(name = "BLOG_USER", joinColumns =
    { @JoinColumn(name = "BLOG_ID") }, inverseJoinColumns =
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

    public String getBlogTitle()
    {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle)
    {
        this.blogTitle = blogTitle;
    }

    public String getBlogBody()
    {
        return blogBody;
    }

    public void setBlogBody(String blogBody)
    {
        this.blogBody = blogBody;
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

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public List<Tag> getTags()
    {
        return tags;
    }

    public void setTags(List<Tag> tags)
    {
        this.tags = tags;
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
