package com.blog.service;

import java.util.List;

import com.blog.model.Blogs;
import com.blog.model.ModelFormData;
import com.blog.model.Users;
import com.blog.model.WriteBlogs;

public interface BlogService {
	
	public List<Blogs> getAllBlogs();

	public Users validateUser(Users user);

	public void createNewUser(Users user);
	
	public void createNewBlog(WriteBlogs writeBlogs);

	public Users validateUserForSign(Users user);
	
	public Blogs getBlogById(int id);

	public Users newPassword(Users user);

	public boolean isCheckCurrentPassword(Users user,ModelFormData formData);

	public boolean isnewEmailUpdated(Users currentUser, Users user);

	public List<Blogs> searchBlog(String query);

	public List<Blogs> categoryByName(String string);

	public boolean isBlogUpdated(Blogs blogToBeUpdated, WriteBlogs updatedBlog);

	public List<Blogs> getNextPageBlogs(int currentPage);

	public List<Blogs> getPreviousPageBlogs(int currentPage);

	


}
