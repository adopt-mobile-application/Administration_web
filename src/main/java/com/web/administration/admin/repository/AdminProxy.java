package com.web.administration.admin.repository;
import com.web.administration.admin.CustomProperties;
import com.web.administration.admin.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class AdminProxy {

    @Autowired
    private CustomProperties props;

    public String logIn(User u) {
        String baseApiUrl = props.getApiUrl1();
        String createLoginUrl = baseApiUrl + "/api/admin-login";

        Map<String, Object > userMap = new HashMap<>();
        userMap.put("email",u.getEmail());
        userMap.put("password",u.getPassword());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Map<String,Object>> request = new HttpEntity<Map<String,Object>>(userMap);
        ResponseEntity<String> response = restTemplate.exchange(
                createLoginUrl,
                HttpMethod.POST,
                request,
                String.class);


        return (String) response.getBody();
    }

}