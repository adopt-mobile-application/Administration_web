package com.web.administration.admin.service;


import com.web.administration.admin.model.Account;
import com.web.administration.admin.repository.AccountProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AccountService {

    @Autowired
    private AccountProxy accountProxy;



    public Iterable<Account> getAccounts(String auth_token) {
        return accountProxy.getAccounts(auth_token);
    }

    public String deleteAccount(String auth_token,long id) {
        return accountProxy.deleteAccount(auth_token,id);
    }

}
