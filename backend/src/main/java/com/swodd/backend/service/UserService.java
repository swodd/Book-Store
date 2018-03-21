/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.service;

import com.swodd.backend.domain.User;
import com.swodd.backend.domain.security.UserRole;
import java.util.Set;

/**
 *
 * @author User
 */
public interface UserService {
    
    User createUser(User user, Set<UserRole> userRoles);
    
}
