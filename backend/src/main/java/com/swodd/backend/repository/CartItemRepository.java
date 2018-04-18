package com.swodd.backend.repository;

import com.swodd.backend.domain.CartItem;
import com.swodd.backend.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CartItemRepository extends CrudRepository<CartItem, Long>{
    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
    //	List<CartItem> findByOrder(Order order);
}
