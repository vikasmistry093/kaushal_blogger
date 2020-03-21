package com.blog.model;

import org.springframework.web.multipart.MultipartFile;

public class WriteBlogs {
	
	private long updateBlogId;

	private String title;

	private String category;

	private String description;

	private MultipartFile images;

	public WriteBlogs() {
	}

	public WriteBlogs(long updateBlogId, String title, String category, String description, MultipartFile images) {
		super();
		this.updateBlogId = updateBlogId;
		this.title = title;
		this.category = category;
		this.description = description;
		this.images = images;
	}

	public long getUpdateBlogId() {
		return updateBlogId;
	}

	public void setUpdateBlogId(long updateBlogId) {
		this.updateBlogId = updateBlogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MultipartFile getImages() {
		return images;
	}

	public void setImages(MultipartFile images) {
		this.images = images;
	}
	
	
}
