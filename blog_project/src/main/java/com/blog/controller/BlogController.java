package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.Blogs;
import com.blog.model.ModelFormData;
import com.blog.model.Users;
import com.blog.model.WriteBlogs;
import com.blog.service.BlogService;

@Controller
public class BlogController<ViewBlogs> {

	private static int pageNumber = 0;
	private static final String String = null;
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("home");
		Users user = (Users) request.getSession().getAttribute("user");
		//set page number in session
		request.getSession().setAttribute("pageNo", pageNumber);

		List<Blogs> blogs = blogService.getAllBlogs();
		model.addObject("user", user);
		model.addObject("blogs", blogs);
		return model;
	}

	// When login page is loaded
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		System.out.println("Login Page is loaded");
		ModelAndView model = new ModelAndView("login");
		Users user = new Users();
		model.addObject("user", user);
		return model;
	}

	// To validate user while login after tapping SUBMIT button
	@RequestMapping(value = { "/validateUser" }, method = RequestMethod.GET)
	public ModelAndView validateUser(@ModelAttribute("user") Users user, HttpServletRequest request) {
		System.out.println("validateUser method is called");
		ModelAndView model = new ModelAndView("login");
		if (user.getEmailId() != null) {
			// validate user flow is remaining
			Users isValidUSers = blogService.validateUser(user);

			if (isValidUSers != null) {
				model = new ModelAndView("redirect:/home");
				request.getSession().setAttribute("user", isValidUSers);
			}
		}
		return model;
	}

	// When sign up page is loaded
	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public ModelAndView signUp() {
		System.out.println("Sign Up page is loaded");
		ModelAndView model = new ModelAndView("signup");
		Users user = new Users();
		model.addObject("user", user);
		return model;
	}

	// When Submit is tapped on Sign up page (To Create new user)
	@RequestMapping(value = { "/createNewUser" }, method = RequestMethod.POST)
	public ModelAndView createNewUser(@ModelAttribute("user") Users user, HttpServletRequest request) {
		System.out.println("createNewUser function is called");
		ModelAndView model = new ModelAndView("redirect:/login");
		if (user != null) {
			Users isValidUser = blogService.validateUserForSign(user);
			if (isValidUser == null) {
				blogService.createNewUser(user);
				model = new ModelAndView("success");
			} else {
				model = new ModelAndView("redirect:/signup");
			}
		}
		return model;
	}

	// when success page is loaded
	@RequestMapping(value = { "/success" }, method = RequestMethod.GET)
	public ModelAndView success() {
		System.out.println("success page is loaded");
		ModelAndView model = new ModelAndView("login");
		model = new ModelAndView("login");
		return model;
	}

	// when WriteBlog Page is loaded
	@RequestMapping(value = { "/writeblog" }, method = RequestMethod.GET)
	public ModelAndView writeblogPage() {
		System.out.println("write blog is loaded");
		ModelAndView model = new ModelAndView("writeblog");
		WriteBlogs writeblogs = new WriteBlogs();
		model.addObject("WriteBlogs", writeblogs);
		return model;
	}

	// when WriteBlog Page is loaded
	@RequestMapping(value = { "/viewblog/{id}" }, method = RequestMethod.GET)
	public ModelAndView viewBlogPage(@PathVariable("id") int id, HttpServletRequest request) {
		System.out.println("View blog is loaded " + id);
		WriteBlogs updateBlog = new WriteBlogs();
		
		
		Users user = (Users) request.getSession().getAttribute("user");
		ModelAndView model = new ModelAndView("viewblog");
		Blogs blog = blogService.getBlogById(id);
		updateBlog.setDescription(blog.getDescription());
		updateBlog.setCategory(blog.getCategory().getCategoryName());
		updateBlog.setTitle(blog.getTitle());
		updateBlog.setUpdateBlogId(blog.getBlogId());

		model.addObject("blog", blog);
		model.addObject("user", user);
		model.addObject("WriteBlogs",updateBlog);

		return model;
	}

	// When Submit is tapped on Write Blog page (To Create new blog)
	@RequestMapping(value = { "/createNewBlog" }, method = RequestMethod.POST)
	public ModelAndView createNewBlog(@ModelAttribute("WriteBlogs") WriteBlogs writeBlog) {
		System.out.println("createNewblog function is called");
		ModelAndView model = new ModelAndView("writeblog");
		blogService.createNewBlog(writeBlog);
		model = new ModelAndView("redirect:/blogsuccess");

		return model;
	}
	
	
	@RequestMapping(value = { "/viewblog/updateBlog" }, method = RequestMethod.POST)
	public ModelAndView updateBlog(@ModelAttribute("WriteBlogs") WriteBlogs updatedBlog) {
		System.out.println("Updated Blog function is called");
		ModelAndView model = new ModelAndView("home");
		
		Blogs blogToBeUpdated = blogService.getBlogById((int)updatedBlog.getUpdateBlogId());
		boolean isBlogUpdated = blogService.isBlogUpdated(blogToBeUpdated, updatedBlog);
		
		if(isBlogUpdated == true) {
			String successMsg = "SUCCESSFULLY UPDATED YOUR BLOG";
			model = new ModelAndView("blogsuccess");
			model.addObject("successMsg", successMsg);
		}
		return model;
	}

	// When Setting page is loaded
	@RequestMapping(value = { "/setting" }, method = RequestMethod.GET)
	public ModelAndView settingPage() {
		System.out.println("Setting page is Loaded");
		ModelAndView model = new ModelAndView("setting");
		Users user = new Users();
		model.addObject("Users", user);
		return model;
	}

	// When contact page is loaded
	@RequestMapping("/contact")
	public ModelAndView contactPage() {
		ModelAndView model = new ModelAndView("contact");
		return model;
	}

	// When Error page is loaded
	@RequestMapping(value = { "/errorPage" }, method = RequestMethod.GET)
	public ModelAndView errorPage() {
		ModelAndView model = new ModelAndView("errorPage");
		return model;
	}
	
	// When User Click On Forgot Password page
	@RequestMapping(value = { "/passwordRequest" }, method = RequestMethod.GET)
	public ModelAndView passwordRequest() {
		ModelAndView model = new ModelAndView("passwordRequest");
		return model;
	}

	// When Forgot Password page is loaded
	@RequestMapping("/forgotpassword")
	public String forgotpasswordPage() {
		return "forgotpassword";
	}

	// When Successfully posted your blog  page is loaded
	@RequestMapping("/blogsuccess")
	public ModelAndView blog_successpage() {
		ModelAndView model = new ModelAndView("blogsuccess");
		Users user = new Users();
		model.addObject("User", user);
		return model;
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request) {
		System.out.println("Login Page is loaded");
		ModelAndView model = new ModelAndView("login");
		request.getSession().removeAttribute("user");
		Users user = new Users();
		model.addObject("Users", user);
		return model;
	}

	// When Change Password page is loaded
	@RequestMapping(value = { "/changepassword" }, method = RequestMethod.GET)
	public ModelAndView changepasswordpage() {

		System.out.println("Inside Chnage Password Page");
		ModelAndView model = new ModelAndView("changepassword");
		ModelFormData formData = new ModelFormData();
		model.addObject("formData", formData);
		return model;
	}
	
	//When Change Password Success page is loaded
	@RequestMapping(value = { "/changePsswdSucces" }, method = RequestMethod.GET)
	public ModelAndView changePsswdSucces() {
		System.out.println("Change Password Success Page is loaded");
		ModelAndView model = new ModelAndView("changePsswdSucces");
		return model;
	}

	// When Submit is tapped on Change Password Page (To Create new password) 
	@RequestMapping(value = { "/updatePassword" }, method = RequestMethod.GET)
	public ModelAndView updatePassword(@ModelAttribute("formData") ModelFormData formData, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		Users user = (Users) request.getSession().getAttribute("user");
		if (user != null) {
			model = new ModelAndView("changepassword");
			boolean isCheckCurrentPassword  = blogService.isCheckCurrentPassword(user,formData);
			if(isCheckCurrentPassword == true) {
				model = new ModelAndView("changePsswdSucces");
			}else {
				model = new ModelAndView("errorPage");
			}
		}
		return model;
	}
	
	// When Change Email Page is loaded
	@RequestMapping(value = { "/changeemail" }, method = RequestMethod.GET)
	public ModelAndView changeemailpage() {
		System.out.println("Inside Change Email Page");
		ModelAndView model = new ModelAndView("changeemail");
		Users user = new Users();
		model.addObject("user", user);
		return model;
	}
	
	//When Change Email Success Page is loaded
	@RequestMapping(value = { "/changeEmailSucces" }, method = RequestMethod.GET)
	public ModelAndView changeEmailSucces() {
		System.out.println("Change Email Success Page is loaded");
		ModelAndView model = new ModelAndView("changeEmailSucces");
		return model;
	}
	
	// When Submit is tapped on Change Email Page (To Create new Email)
	@RequestMapping(value = { "/updateEmail" }, method = RequestMethod.GET)
	public ModelAndView updateEmail(@ModelAttribute("user") Users user, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		Users currentUser = (Users) request.getSession().getAttribute("user");
		if (currentUser != null) {
			model = new ModelAndView("changeemail");
			boolean isnewEmailUpdated  = blogService.isnewEmailUpdated(currentUser,user);
			if(isnewEmailUpdated == true) {
				model = new ModelAndView("changeEmailSucces");
			}else {
				model = new ModelAndView("errorPage");
			}
		}
		return model;
	}
	
	@RequestMapping (value = { "/search" })
	public ModelAndView search (@RequestParam("searchquery") String query, HttpServletRequest request) {
		System.out.println("Inside search controller");
		ModelAndView model = new ModelAndView("home");
		Users user = (Users) request.getSession().getAttribute("user");
		
		System.out.println(user);
		List<Blogs> blogList = blogService.searchBlog(query);
		
		System.out.println(blogList);
		if(user != null)
			model.addObject("user", user);
		
		model.addObject("blogs", blogList);
		
		return model;
	}
	
	
	@RequestMapping(value = {"/nextpage"})
	public ModelAndView nextpage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("home");
		Users user = (Users) request.getSession().getAttribute("user");
		
		pageNumber ++;
		request.getSession().setAttribute("pageNo", pageNumber);
		
		int currentPage = (Integer) request.getSession().getAttribute("pageNo");
		
		List<Blogs> blogs = blogService.getNextPageBlogs(currentPage);
		
		System.out.println("Counts of blogs = "+blogs.size());
		model.addObject("user", user);
		model.addObject("blogs", blogs);
		
		
		
		System.out.println("Inside Next page " + currentPage);
		System.out.println("New Page NUmnber = " + request.getSession().getAttribute("pageNo"));
		return model;
	}
	
	@RequestMapping(value = {"/previouspage"})
	public ModelAndView previouspage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("home");
		Users user = (Users) request.getSession().getAttribute("user");
		model.addObject("user", user);
		int currentPage = (Integer) request.getSession().getAttribute("pageNo");
		
		if(currentPage > 0) {			
		pageNumber --;
		request.getSession().setAttribute("pageNo", pageNumber);
		
		List<Blogs> blogs = blogService.getPreviousPageBlogs(currentPage);
		System.out.println("Counts of blogs = "+blogs.size());
		model.addObject("blogs", blogs);
		
		System.out.println("Inside Next page " + currentPage);
		System.out.println("New Page NUmnber = " + request.getSession().getAttribute("pageNo"));
		}else {
			List<Blogs> blogs = blogService.getAllBlogs();
			model.addObject("blogs", blogs);
		}
		return model;
	}
	
	@RequestMapping (value = { "/category" }, method = RequestMethod.GET)
	public ModelAndView category() {
		ModelAndView model = new ModelAndView("home");
		@SuppressWarnings("unused")
		List<Blogs> blogCategory = blogService.categoryByName(String);
		return model;
	}
	
}
