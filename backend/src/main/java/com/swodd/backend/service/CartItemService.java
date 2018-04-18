package com.swodd.backend.service;

import com.swodd.backend.domain.Book;
import com.swodd.backend.domain.CartItem;
import com.swodd.backend.domain.ShoppingCart;
import com.swodd.backend.domain.User;

import java.util.List;

public interface CartItemService {
    CartItem addBookToCartItem(Book book, User user, int qty);

    List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);

//	List<CartItem> findByOrder(Order order);

    CartItem updateCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    CartItem findById(Long id);

    CartItem save(CartItem cartItem);
}
