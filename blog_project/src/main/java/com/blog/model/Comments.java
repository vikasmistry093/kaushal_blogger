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
@Table(name="comments")
public class Comments {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="comment_id")
	private long commentId;
	
	@NotNull
	@Column(name="description")
	private String description;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="blog_id", referencedColumnName="blog_id")
	private Blogs blogId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id", referencedColumnName="user_id")
	private Users userId;
	
	public Comments() {}
	
	public Comments(long commentId, String description, Timestamp createdAt, Timestamp updatedAt, Blogs blogId,
			Users userId) {
		super();
		this.commentId = commentId;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.blogId = blogId;
		this.userId = userId;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Blogs getBlogId() {
		return blogId;
	}
	public void setBlogId(Blogs blogId) {
		this.blogId = blogId;
	}
	public Users getUserId() {
		return userId;
	}
	public void setUserId(Users userId) {
		this.userId = userId;
	}
	
	

}
