/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.service.impl;

import com.swodd.backend.domain.User;
import com.swodd.backend.domain.UserPayment;
import com.swodd.backend.domain.security.UserRole;
import com.swodd.backend.repository.RoleRepository;
import com.swodd.backend.repository.UserRepository;
import com.swodd.backend.service.UserService;

import java.util.ArrayList;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class UserServiceImpl implements UserService{
	
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
    @Autowired
    private UserRepository userRepository;
	
    @Autowired
    private RoleRepository roleRepository;
	
    @Transactional
    public User createUser(User user, Set<UserRole> userRoles) {
	User localUser = userRepository.findByUsername(user.getUsername());
		
	if(localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
	} else {
            for (UserRole ur : userRoles) {
		roleRepository.save(ur.getRole());
	}
			
	user.getUserRoles().addAll(userRoles);
    user.setUserPaymentList(new ArrayList<UserPayment>());
			
	localUser = userRepository.save(user);
		}
		
	return localUser;
	}

	@Override
	public User save(User user){
    	return userRepository.save(user);
	}

	@Override
	public User findById(Long id){
    	return userRepository.findOne(id);
	}

	@Override
	public User findByUsername(String username){
    	return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email){
    	return userRepository.findByEmail(email);
	}
}
