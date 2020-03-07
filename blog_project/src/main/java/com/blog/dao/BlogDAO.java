package com.blog.dao;

import java.util.List;

import com.blog.model.Blogs;
import com.blog.model.Category;
import com.blog.model.Users;

public interface BlogDAO {
	
	public List<Blogs> getAllBlogs();

	public Users getUserByUser(Users user);

	public void createNewUser(Users user);

	public void createNewBlog(Blogs blog);

	public Category getCategoryByName(String categoryName);

	public Users getUserByUserForSignup(Users user);

	public Blogs getBlogById(int id);

	public Users getNewPassword(Users user);

	public Users isCheckCurrentPassword(String emailId, String currentPassword);

	public void updateNewPassword(Users user);

	public Users isEmailUpdated(String emailId);

	public void updatedEmail(Users newUser);


}
