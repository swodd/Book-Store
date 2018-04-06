/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.service;

import com.swodd.backend.domain.User;
import com.swodd.backend.domain.UserBilling;
import com.swodd.backend.domain.UserPayment;
import com.swodd.backend.domain.security.UserRole;
import java.util.Set;

/**
 *
 * @author User
 */
public interface UserService {
    
    User createUser(User user, Set<UserRole> userRoles);
    User findByUsername(String username);
    User findByEmail(String email);
    User save(User user);
    User findById(Long id);
    void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);
    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
    void setUserDefaultPayment(Long userPaymentId, User user);
}
