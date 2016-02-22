package com.akifbatur.blog.web.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Akif Batur
 * 
 * Controller implementation class for Controller: IndexController
 *
 */
@Controller(value = "indexController")
public class IndexController
{
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String getIndex(ModelMap model)
    {
        model.addAttribute("activeTab", "index");
        return "index";
    }
    
    @PostConstruct
    public void init()
    {
        logger.info("IndexController initialized.");
    }
}
