/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.service;

import com.swodd.backend.domain.User;
import com.swodd.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */

@Service
public class UserSecurityService implements UserDetailsService{
    private static final Logger LOG = LoggerFactory.getLogger(UserSecurityService.class);
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(null==user){
            LOG.warn("Username {} not found ", username);
            throw new UsernameNotFoundException("Username " + username + " not found");
            
        }
        return user;
    }
}
