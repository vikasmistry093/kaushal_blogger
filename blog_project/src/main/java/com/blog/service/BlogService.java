package com.blog.service;

import java.util.List;

import com.blog.model.Blogs;
import com.blog.model.Users;
import com.blog.model.WriteBlogs;

public interface BlogService {
	
	public List<Blogs> getAllBlogs();

	public Users validateUser(Users user);

	public void createNewUser(Users user);
	
	public void createNewBlog(WriteBlogs writeBlogs);

	public Users validateUserForSign(Users user);
	
	public Blogs getBlogById(int id);

}
