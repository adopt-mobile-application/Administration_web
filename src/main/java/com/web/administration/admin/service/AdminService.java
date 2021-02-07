package com.web.administration.admin.service;


import com.web.administration.admin.model.User;
import com.web.administration.admin.repository.AdminProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AdminService {

    @Autowired
    private AdminProxy adminProxy;

    public String logIn(User user) {
        return  adminProxy.logIn(user);

    }



}