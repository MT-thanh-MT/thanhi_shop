package com.thanhi.repository;

import com.thanhi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.username =:username")
    public Account getAccountByUsername(@Param("username") String username);
    Optional<Account> findAccountByUsername(String username);

}