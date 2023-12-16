package com.example.demo.authentication;

import java.util.List;
import java.util.Collection;
import java.util.ArrayList;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserAuthentication implements Authentication {

    private final String authority;

    public String getAuthorityString() {
        return authority;
    }

    public UserAuthentication(String authority) {
        this.authority = authority;
    }

    @Override
    public String getName() {
        return "Name";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = () -> {
            return authority;
        };
        authorities.add(grantedAuthority);
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return "Credentials";
    }
    @Override
    public Object getDetails() {
        return "Details";
    }

    @Override
    public Object getPrincipal() {
        return "Principal";
     }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }
    
}
