package com.akifbatur.blog.web.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Akif Batur
 * 
 * Controller implementation class for Controller: WritePostController
 *
 */
@Controller(value = "writePostController")
public class WritePostController
{
    private static final Logger logger = LoggerFactory.getLogger(WritePostController.class);

    @RequestMapping(name="/post/write-post", method=RequestMethod.GET)
    public String getForm(ModelMap model)
    {
        model.addAttribute("activeTab", "write-post");
        return "write-post";
    }
    
    @RequestMapping(name="/post/write-post", method=RequestMethod.POST)
    public String doPost(ModelMap model, @RequestParam("tags") String tags)
    {
        System.out.println(tags);
        model.addAttribute("activeTab", "write-post");
        return "write-post";
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("WritePostController initialized.");
    }
}