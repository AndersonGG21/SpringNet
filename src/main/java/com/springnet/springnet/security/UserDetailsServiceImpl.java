package com.springnet.springnet.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springnet.springnet.models.User;
import com.springnet.springnet.repositories.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findOneByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email: " + email + " no existe."));
                    
        return new UserDetailsImpl(user);
    }

}
