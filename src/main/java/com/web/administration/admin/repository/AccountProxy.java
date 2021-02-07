package com.web.administration.admin.repository;

import com.web.administration.admin.CustomProperties;
import com.web.administration.admin.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Slf4j
@Component
public class AccountProxy {

    @Autowired
    private CustomProperties props;

    public Iterable<Account> getAccounts(String auth_token) {
        String baseApiUrl = props.getApiUrl1();
        String getAccountUrl = baseApiUrl + "/api/account/all";

        RestTemplate restTemplate = new RestTemplate();
        //to set the Authorization token
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException, IOException {
                request.getHeaders().set("Authorization", auth_token);//Set the header for each request
                return execution.execute(request, body);
            }
        });

        ResponseEntity<Iterable<Account>> response = restTemplate.exchange(
                getAccountUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Account>>() {}
                );
        return response.getBody();
    }

    public String deleteAccount(String auth_token,long id) {
        String baseApiUrl = props.getApiUrl1();
        String deleteAccountUrl = baseApiUrl + "/api/account/delete/"+id;

        RestTemplate restTemplate = new RestTemplate();

        //to set the Authorization token
        restTemplate.getInterceptors().add(new ClientHttpRequestInterceptor(){
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException, IOException {
                request.getHeaders().set("Authorization", auth_token);//Set the header for each request
                return execution.execute(request, body);
            }
        });

        ResponseEntity<String> response = restTemplate.exchange(
                deleteAccountUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<String>() {}
        );

        return (String) response.getBody();
    }
}
