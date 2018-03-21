/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.repository;

import com.swodd.backend.domain.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByUsername(String username);
    User findByEmail(String email);
    List<User>findAll();
    
}
