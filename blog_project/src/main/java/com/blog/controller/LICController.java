package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blog.service.BlogService;

@Controller
public class LICController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/")
	public String indexPage() {
		System.out.println("Blogs" + blogService.getAllBlogs().size());
		return "index";
	}

}
