package com.swodd.backend.repository;

import com.swodd.backend.domain.UserPayment;
import org.springframework.data.repository.CrudRepository;

public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {
}
