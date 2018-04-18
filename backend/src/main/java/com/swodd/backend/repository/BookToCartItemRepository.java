package com.swodd.backend.repository;

import com.swodd.backend.domain.BookToCartItem;
import com.swodd.backend.domain.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface BookToCartItemRepository extends CrudRepository<BookToCartItem, Long> {
    void deleteByCartItem(CartItem cartItem);
}
