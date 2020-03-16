package com.blog.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.blog.dao.BlogDAO;
import com.blog.model.Blogs;
import com.blog.model.Category;
import com.blog.model.Users;

@Repository
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Blogs> getAllBlogs() {
		Session session = sessionFactory.openSession();
		List<Blogs> list= session.createCriteria(Blogs.class).list().subList(0, 13);
        return list;
	}

	@Override		
	public Users getUserByUser(Users user) {
		System.out.println("Inside DAO func - validate user");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users where emailId = :email and userPassword = :password");
		query.setString("email", user.getEmailId());
		query.setString("password", user.getUserPassword());
		
		Users newUser = (Users) query.uniqueResult();
		return newUser;
	}

	@Override
	public void createNewUser(Users user) {
		System.out.println("Inside DAO func - create New User");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		
		tx.commit();
	}

	@Override
	public void createNewBlog(Blogs blog) {
		
		System.out.println("Inside DAO func - create New Blog");
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(blog);
		
		tx.commit();
	}

	@Override
	public Category getCategoryByName(String categoryName) {
		System.out.println("In Get CategoryByName DAO");
		
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category where categoryName = :categoryName");
		query.setString("categoryName", categoryName);
		
		Category category = (Category) query.uniqueResult();
		
		return category;
		
	}

	@Override
	public Users getUserByUserForSignup(Users user) {
		System.out.println("Inside DAO func - validate user");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users where emailId = :email");
		query.setString("email", user.getEmailId());
		
		Users newUser = (Users) query.uniqueResult();
		return newUser;
	}

	@Override
	public Blogs getBlogById(int id) {
		System.out.println("Inside DAO func - getBlogById " + id);
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Blogs where blogId = :id");
		query.setInteger("id", id);
		
		Blogs blog = (Blogs) query.uniqueResult();
		
		return blog;
	}

	@Override
	public Users getNewPassword(Users user) {
		System.out.println("Inside DAO func - getNewPassword" + user);
				
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users where  userPassword = :password");
		query.setString("password", user.getUserPassword());

		Users newPassword = (Users) query.uniqueResult();
		return newPassword;
	}

	@Override
	public Users isCheckCurrentPassword(String emailId, String currentPassword) {
		System.out.println("Inside DAO for checkCurrentPassword");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users where emailId = :email and userPassword = :password");
		query.setString("email", emailId);
		query.setString("password", currentPassword);
		Users currentUser = (Users) query.uniqueResult();
		System.out.println(currentUser);
		
		return currentUser;
		
	}

	@Override
	public void updateNewPassword(Users user) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		
		tx.commit();
		
	}

	@Override
	public Users getUserByEmail(String emailId) {
		System.out.println("Inside DAO for newEmail");
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Users where emailId = :email");
		query.setString("email", emailId);
		Users userByEmail = (Users) query.uniqueResult();
		System.out.println(userByEmail); //always should be null
		
		return userByEmail;
		
		
	}

	@Override
	public void updateNewEmail(Users user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		
	}




}
