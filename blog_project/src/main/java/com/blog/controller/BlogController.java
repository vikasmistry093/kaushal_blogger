package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.Blogs;
import com.blog.model.ModelFormData;
import com.blog.model.Users;
import com.blog.model.WriteBlogs;
import com.blog.service.BlogService;

@Controller
public class BlogController<ViewBlogs> {

	@Autowired
	private BlogService blogService;

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("home");
		Users user = (Users) request.getSession().getAttribute("user");

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
		System.out.println("View blog is loaded" + id);
		Users user = (Users) request.getSession().getAttribute("user");
		ModelAndView model = new ModelAndView("viewblog");
		Blogs blog = blogService.getBlogById(id);
		model.addObject("blog", blog);
		model.addObject("user", user);

		return model;
	}

	// When Submit is tapped on Write Blog page (To Create new blog)
	@RequestMapping(value = { "/createNewBlog" }, method = RequestMethod.POST)
	public ModelAndView createNewBlog(@ModelAttribute("WriteBlogs") WriteBlogs writeBlog) {
		System.out.println("createNewblog function is called");
		ModelAndView model = new ModelAndView("writeblog");
		blogService.createNewBlog(writeBlog);
		model = new ModelAndView("redirect:/home");

		return model;
	}

	@RequestMapping(value = { "/setting" }, method = RequestMethod.GET)
	public ModelAndView settingPage() {
		System.out.println("Setting page is Loaded");
		ModelAndView model = new ModelAndView("setting");
		Users user = new Users();
		model.addObject("Users", user);
		return model;
	}

	@RequestMapping("/contact")
	public ModelAndView contactPage() {
		ModelAndView model = new ModelAndView("contact");
		return model;
	}

	@RequestMapping("/errors")
	public ModelAndView errorPage() {
		ModelAndView model = new ModelAndView("error");
		return model;
	}

	@RequestMapping("/forgotpassword")
	public String forgotpasswordPage() {
		return "forgotpassword";
	}

	@RequestMapping("/blog_success")
	public ModelAndView blog_successpage() {
		ModelAndView model = new ModelAndView("blog_success");
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

	@RequestMapping("/changeemail")
	public ModelAndView changeemailpage() {
		ModelAndView model = new ModelAndView("changeemail");

		return model;
	}

	@RequestMapping(value = { "/changepassword" }, method = RequestMethod.GET)
	public ModelAndView changepasswordpage() {

		System.out.println("Inside Chnage Password Page");
		ModelAndView model = new ModelAndView("changepassword");
		ModelFormData formData = new ModelFormData();
		model.addObject("formData", formData);
		return model;
	}

	@RequestMapping(value = { "/updatePassword" }, method = RequestMethod.GET)
	public ModelAndView updatePassword(@ModelAttribute("formData") ModelFormData formData, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		Users user = (Users) request.getSession().getAttribute("user");
		
		if (user != null) {
			model = new ModelAndView("changepassword");
			System.out.println("Inside change password with new password " + formData.getCurrentPassword());
			System.out.println("Inside change password with new password " + formData.getNewPassword());
			model.addObject("User", formData);
		}
		return model;
	}

}
