package com.code_a_thon.server.backend_server.Repository;

import com.code_a_thon.server.backend_server.Entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long>
{
    public Optional<Account> findByEmail(String email);
    public Optional<Account> findByHash(String hash);
}
