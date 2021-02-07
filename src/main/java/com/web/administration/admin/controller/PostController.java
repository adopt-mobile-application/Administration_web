package com.web.administration.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.web.administration.admin.model.Post;
import com.web.administration.admin.service.PostService;

import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Data
@Controller
public class PostController {
	@Autowired
	private PostService postservice;
	
	@GetMapping("/")
	public String index(Model model) {

		return "index";
	}
	
	@GetMapping("/posts")
	public String posts(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("token");
		Iterable<Post> listPosts = postservice.getPosts(token);
		model.addAttribute("posts", listPosts);
		return "posts";
	}
	

	@GetMapping("/deletePost/{id}")
	public ModelAndView deletePost(HttpServletRequest request,@PathVariable("id") final int id) {
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("token");
		postservice.deletePost(token,id);
		return new ModelAndView("redirect:/posts");		
	}
	@GetMapping("/acceptPost/{id}")
	public ModelAndView updatePost(HttpServletRequest request,@PathVariable("id") final int id, Model model) {
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("token");
		
		postservice.accepterPost(token,id);
		return new ModelAndView("redirect:/posts");			
		
	}

	
}
