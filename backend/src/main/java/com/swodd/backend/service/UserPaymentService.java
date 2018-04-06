package com.swodd.backend.service;

import com.swodd.backend.domain.UserPayment;

public interface UserPaymentService {
    UserPayment findById(Long id);

    void removeById(Long id);
}
