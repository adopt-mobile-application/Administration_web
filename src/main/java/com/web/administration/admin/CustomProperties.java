package com.web.administration.admin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="com.web.administration.admin")
public class CustomProperties {

	private String apiUrl1;
	private String apiUrl2;
	
}

