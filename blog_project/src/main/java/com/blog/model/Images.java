package com.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="images")
public class Images {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="image_id")
	private long imageId;
	
	@Column(name="image_name")
	private String imageName;
	
	@NotNull
	@Column(name="image_url")
	private String imageUrl;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="blog_id", referencedColumnName="blog_id")
	private Blogs blogId;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;

	public Images() {}	
	public Images(long imageId, String imageName, String imageUrl, Blogs blogId, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageUrl = imageUrl;
		this.blogId = blogId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getImageId() {
		return imageId;
	}
	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Blogs getBlogId() {
		return blogId;
	}
	public void setBlogId(Blogs blogId) {
		this.blogId = blogId;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	

}
