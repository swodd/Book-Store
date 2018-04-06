package com.swodd.backend.service.impl;

import com.swodd.backend.domain.UserPayment;
import com.swodd.backend.repository.UserPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPaymentServiceImpl {
    @Autowired
    private UserPaymentRepository userPaymentRepository;

    public UserPayment findById(Long id) {
        return userPaymentRepository.findOne(id);
    }

    public void removeById(Long id) {
        userPaymentRepository.delete(id);
    }

}
