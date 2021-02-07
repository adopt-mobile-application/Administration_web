package com.web.administration.admin.controller;


import com.web.administration.admin.model.User;
import com.web.administration.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;



    @GetMapping("/login")
    public String logIn(HttpServletRequest request, Model model, User user) {
        HttpSession session = request.getSession();
        session.invalidate();
        model.addAttribute("user", user);
        return "index";
    }


    @PostMapping("/login")
    public String logInPost(HttpServletRequest request, Model model, @ModelAttribute User user) {
        HttpSession session = request.getSession();
        String result = adminService.logIn(user);

        if(result.contains("Bearer"))
        {
            session.setAttribute("token", result);
            model.addAttribute("message",  "Welcome");

            return "success";
        }
        else
        {
            model.addAttribute("message",  result);
            return "error";

        }
    }



}
