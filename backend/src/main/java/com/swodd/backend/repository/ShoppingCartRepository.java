package com.swodd.backend.repository;

import com.swodd.backend.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {

}

