package org.lesson.java.spring.spring_la_mia_pizzeria_crud.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.Role;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DatabaseUserDetails implements UserDetails{

    private final Integer id;
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities;

    public DatabaseUserDetails(User user){
        this.id=user.getId();
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.authorities= new HashSet<GrantedAuthority>();
        for(Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }        
    }


    public Integer getId() {
        return this.id;
    }


    public Set<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }    
    public String getPassword() {
        return this.password;
    }    
    public String getUsername() {
        return this.username;
    }

    @Override 
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override 
    public boolean isAccountNonLocked(){
        return true;
    }
    @Override 
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override 
    public boolean isEnabled(){
        return true;
    }
    
}
