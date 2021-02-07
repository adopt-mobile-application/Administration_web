package com.web.administration.admin.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

import com.web.administration.admin.CustomProperties;
import com.web.administration.admin.model.Post;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class PostProxy {
	@Autowired
	private CustomProperties props;

	public Iterable<Post> getPosts(String auth_token) {

		String baseApiUrl = props.getApiUrl1();
		String getPostUrl = baseApiUrl + "/api/admin/uconfirmed_post";
		RestTemplate restTemplate = new RestTemplate();
		//to set the Authorization token
		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException, IOException {
				request.getHeaders().set("Authorization", auth_token);//Set the header for each request
				return execution.execute(request, body);
			}
		});
		ResponseEntity<Iterable<Post>> response = restTemplate.exchange(
				getPostUrl, 
				HttpMethod.GET, 
				null,
				new ParameterizedTypeReference<Iterable<Post>>() {}
			);
		return response.getBody();
	}
	
	public void deletePost(String auth_token,int id) {
		String baseApiUrl = props.getApiUrl2();
		String deletePostUrl = baseApiUrl + "/api/post/" + id;
		RestTemplate restTemplate = new RestTemplate();
		//to set the Authorization token
		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException, IOException {
				request.getHeaders().set("Authorization", auth_token);//Set the header for each request
				return execution.execute(request, body);
			}
		});
		ResponseEntity<Object> response = restTemplate.exchange(
				deletePostUrl, 
				HttpMethod.DELETE, 
				null, 
				Object.class);
		log.debug("Delete Post call " + response.getStatusCode().toString());
	}
	//	@PutMapping("api/admin/confirm_post/{id}")
	public void accepter(String auth_token,int id) {
		String baseApiUrl = props.getApiUrl1();
		String deletePostUrl = baseApiUrl + "/api/admin/confirm_post/" + id;
		RestTemplate restTemplate = new RestTemplate();
		//to set the Authorization token
		restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){
			@Override
			public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException, IOException {
				request.getHeaders().set("Authorization", auth_token);//Set the header for each request
				return execution.execute(request, body);
			}
		});
		ResponseEntity<Post> response = restTemplate.exchange(
				deletePostUrl, 
				HttpMethod.PUT, 
				null, 
				Post.class);
		log.debug("accept Post call " + response.getStatusCode().toString());
	}
		
	
}
