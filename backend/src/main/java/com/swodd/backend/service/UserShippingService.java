package com.swodd.backend.service;

import com.swodd.backend.domain.UserShipping;

public interface UserShippingService {

    UserShipping findById(Long id);

    void removeById(Long id);
}
