package com.rest.springrest.Service;

import com.rest.springrest.Repository.UserRepo;
import com.rest.springrest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    public User saveUser(User user) {
       user.setPassword( encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
