package com.web.administration.admin.controller;
import com.web.administration.admin.model.Account;
import com.web.administration.admin.service.AccountService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Data
@Controller
public class AccountController {

    @Autowired
    AccountService accountService;


    @GetMapping("/accounts")
    public String getAllAccounts(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        Iterable<Account> accountList = accountService.getAccounts(token);
        model.addAttribute("accounts", accountList);
        return "accounts";
    }

    @GetMapping("/delete-account/{id}")
    public String deleteAccount(HttpServletRequest request,Model model,@PathVariable("id") final Long id) {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");
        String result = accountService.deleteAccount(token,id);
        model.addAttribute("message", result);
        if(!result.contains("Error"))
            return "success";
        else
            return "error";
    }

}
