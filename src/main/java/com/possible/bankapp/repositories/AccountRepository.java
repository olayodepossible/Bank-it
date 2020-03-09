package com.possible.bankapp.repositories;

import com.possible.bankapp.models.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
