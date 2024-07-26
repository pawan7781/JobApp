package com.rest.springrest.Service;


import com.rest.springrest.Repository.UserRepo;
import com.rest.springrest.model.User;
import com.rest.springrest.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= repo.findByUsername( username);
       if(user==null)
       {
           System.out.println("user not found");
           throw new UsernameNotFoundException("404 not found");
       }
        return new UserPrinciple(user);
    }
}
