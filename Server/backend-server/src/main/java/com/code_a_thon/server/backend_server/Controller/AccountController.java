package com.code_a_thon.server.backend_server.Controller;

import com.code_a_thon.server.backend_server.Controller.AccountRequests.AccountCreationRequest;
import com.code_a_thon.server.backend_server.Controller.AccountRequests.AccountUpdateRequest;
import com.code_a_thon.server.backend_server.Repository.AccountRepository;
import com.code_a_thon.server.backend_server.Entity.Account;
import com.code_a_thon.server.backend_server.Repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/account")
public class AccountController
{
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    BusinessRepository businessRepository;

    @GetMapping("/")
    public List<Account> getAllAccounts()
    {
        return (List<Account>) accountRepository.findAll();
    }


    @GetMapping("/findByEmail")
    public Optional<Account> getAccountByEmail(@RequestParam("email") String email)
    {
        return accountRepository.findByEmail(email);
    }
    @GetMapping("/findByHash")
    public Optional<Account> getAccountByHash(@RequestParam("hash") String hash)
    {
        return accountRepository.findByHash(hash);
    }
    @GetMapping("/findById")
    public Optional<Account> getAccountById(@RequestParam("id") long id)
    {
        return accountRepository.findById(id);
    }

    @PostMapping("/")
    public void createAccount(@RequestBody @Valid AccountCreationRequest req) { accountRepository.save(new Account(req));}

    @PutMapping("/")
    public void updateAccount(@RequestBody @Valid AccountUpdateRequest req) {
        Optional<Account> accountOptional = accountRepository.findById(req.getId());

        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();

            if(req.getEmail() != null) {
                account.setEmail(req.getEmail());
            }
            if(req.getPassword() != null) {
                account.setHash(req.getPassword());
            }

            accountRepository.save(account);
        }
    }
    
    @GetMapping("/validate")
    public boolean validatePassword(@RequestParam("email") String email, @RequestParam("hash") String password) {
    	Optional<Account> account = accountRepository.findByEmail(email);
    	
    	if(account.isPresent()) {
    		if(password.equals(account.get().getHash())) {
    			return true;
    		}
    		return false;
    	}
    	
    	return false;
    }

    @DeleteMapping("/")
    public void deleteAccount(@RequestParam("id") long id)
    {
        accountRepository.deleteById(id);
    }
}
