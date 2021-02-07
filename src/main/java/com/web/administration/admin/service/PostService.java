package com.web.administration.admin.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.web.administration.admin.model.Post;
import com.web.administration.admin.repository.PostProxy;

import lombok.Data;

@Data
@Service
public class PostService {

	@Autowired
	private PostProxy postproxy;
	public Iterable<Post> getPosts(String auth_token) {
		return postproxy.getPosts(auth_token);
	}
	
	public void deletePost(String auth_token,final int id) {
		postproxy.deletePost(auth_token,id);
	}
	public void accepterPost(String auth_token,final int id) {
		postproxy.accepter(auth_token,id);
	}
	
	
}
