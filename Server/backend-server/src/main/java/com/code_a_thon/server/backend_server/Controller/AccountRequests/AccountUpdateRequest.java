package com.code_a_thon.server.backend_server.Controller.AccountRequests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class AccountUpdateRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull
    Long id;
    @Email
    String email;

    String password;

    public AccountUpdateRequest() {

    }
}
