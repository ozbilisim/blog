package com.akifbatur.blog.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Akif Batur
 * 
 * Entity implementation class for Entity: Role
 *
 */
@Entity
@Table(name = "ROLE", catalog = "BLOG")
public class Role implements Serializable
{
    private static final long serialVersionUID = 1L;

    public Role()
    {

    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ROLE_TITLE", unique = true, nullable = false)
    private String roleTitle;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<User>();

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getRoleTitle()
    {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle)
    {
        this.roleTitle = roleTitle;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }
}
