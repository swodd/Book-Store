package com.swodd.backend.service.impl;

import com.swodd.backend.domain.UserShipping;
import com.swodd.backend.repository.UserShippingRepository;
import com.swodd.backend.service.UserShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserShippingServiceImpl implements UserShippingService {
    @Autowired
    private UserShippingRepository userShippingRepository;

    public UserShipping findById(Long id){
        return userShippingRepository.findOne(id);
    }

    public void removeById(Long id){
        userShippingRepository.delete(id);
    }
}
