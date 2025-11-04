package org.lesson.java.spring.spring_la_mia_pizzeria_crud.security;

import java.util.Optional;

import org.lesson.java.spring.spring_la_mia_pizzeria_crud.model.User;
import org.lesson.java.spring.spring_la_mia_pizzeria_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DatabaseUserDetailsService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<User> userAttempt = userRepository.findByUsername(username);
        if(userAttempt.isEmpty()){
            throw new UsernameNotFoundException("There is no usere available with username" + username);
        }
        return new DatabaseUserDetails(userAttempt.get());
    }
    
}
