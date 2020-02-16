package com.blog.service.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.dao.BlogDAO;
import com.blog.model.Blogs;
import com.blog.model.Category;
import com.blog.model.Images;
import com.blog.model.Users;
import com.blog.model.WriteBlogs;
import com.blog.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDAO blogDAO;

	@Override
	public List<Blogs> getAllBlogs() {
		return blogDAO.getAllBlogs();
	}

	@Override
	public Users validateUser(Users user) {
		System.out.println("Inide Blog Service Imp func - validate user");
		Users newUser = blogDAO.getUserByUser(user);
		
		if (newUser == null) {
			return null;
		} else {
			return newUser;
		}
	}

	@Override
	public void createNewUser(Users user) {
		System.out.println("Inside Blog Service Imp func - create New User");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setCreatedAt(timestamp);
		user.setUpdatedAt(timestamp);
		blogDAO.createNewUser(user);

	}

	@Override
	public void createNewBlog(WriteBlogs writeBlogs) {
		System.out.println("Inside Blog Servive Imp func - create New Blog");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		Blogs blog = new Blogs();
		
		Category category = getCategoryByName(writeBlogs.getCategory());
		List<Images> image = createNewImageByName(writeBlogs.getImages());
		
		blog.setCategory(category);
		blog.setDescription(writeBlogs.getDescription());
		blog.setImages(image);
		blog.setTitle(writeBlogs.getTitle());
		blog.setCreatedAt(timestamp);
		blog.setUpdatedAt(timestamp);
		
		
		
		blogDAO.createNewBlog(blog);
		
	}

	public List<Images> createNewImageByName(MultipartFile file) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		String imageFileName = timestamp.getTime() + file.getOriginalFilename(); 
		
		File filepath = new File("/home/kaushal/uploads/" + imageFileName); 
		try {
			file.transferTo(filepath);
		} catch (IOException e) {
			System.out.println("Exception while uploading file " + e.getMessage());
			e.printStackTrace();
		}
		
		Images image = new Images();
		image.setImageName(file.getName());
		image.setCreatedAt(timestamp);
		image.setUpdatedAt(timestamp);
		image.setImageUrl(filepath.getPath());
		
		System.out.println(filepath.getPath());
		
		List<Images> imageList = new ArrayList<Images>();
		imageList.add(image);
		
		return imageList;
	}

	public Category getCategoryByName(String categoryName) {
	 return blogDAO.getCategoryByName(categoryName);
	}

	@Override
	public Users validateUserForSign(Users user) {
		System.out.println("Inide Blog Service Imp func - validate user");
		Users newUser = blogDAO.getUserByUserForSignup(user);
		if (newUser == null) {
			return null;
		} else {
			return newUser;
		}
	}

	@Override
	public Blogs getBlogById(int id) {
		Blogs newBlog = blogDAO.getBlogById(id); 
		return newBlog;
	}
	
}
