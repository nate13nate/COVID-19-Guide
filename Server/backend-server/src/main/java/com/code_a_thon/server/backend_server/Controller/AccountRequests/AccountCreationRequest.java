package com.code_a_thon.server.backend_server.Controller.AccountRequests;

import com.code_a_thon.server.backend_server.Entity.UserType;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountCreationRequest {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
       this.userType = UserType.valueOf(userType);
    }

    @Email
    private String email;
    @Size(min=8, max=30)
    private String password;
    @NotNull
    private UserType userType;

    public AccountCreationRequest() { }

    //TODO: Creating password validation & hashing function
}
