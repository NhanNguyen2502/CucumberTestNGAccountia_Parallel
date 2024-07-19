package com.erp.com.models;

public class CredentialLogin {
    private String username;
    private String password;
    public CredentialLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
