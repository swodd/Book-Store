/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.repository;

import com.swodd.backend.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author User
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
    
}
