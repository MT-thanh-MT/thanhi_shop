package com.thanhi.service.impl;

import com.thanhi.model.Account;
import com.thanhi.repository.AccountRepository;
import com.thanhi.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Optional<Account> findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
