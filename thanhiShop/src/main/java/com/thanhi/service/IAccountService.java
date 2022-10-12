package com.thanhi.service;

import com.thanhi.model.Account;

import java.util.Optional;

public interface IAccountService {
    Account findById(Long id);
    Optional<Account> findAccountByUsername(String username);
}
