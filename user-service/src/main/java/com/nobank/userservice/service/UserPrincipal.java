package com.nobank.userservice.service;

import com.nobank.userservice.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

    private User user;

    UserPrincipal(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities= new ArrayList<>();

        this.user.getRoles().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+r);
            grantedAuthorities.add(authority);
        });

//        this.user.getPermissions().forEach(p -> {
//            GrantedAuthority authority = new SimpleGrantedAuthority(p);
//            grantedAuthorities.add(authority);
//        });

        return grantedAuthorities;
    }

    @Override
    public String getPassword() throws NullPointerException {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return this.user.getActive() == 1;
        return true;
    }
}
