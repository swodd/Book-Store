/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swodd.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.swodd.backend.domain.security.Authority;
import com.swodd.backend.domain.security.UserRole;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author User
 */
@Entity
public class User implements UserDetails, Serializable{
    
    private static final long serialVersionUID = 934875L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id",nullable=false, updatable=false)
    private Long id;
    
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    private String email;
    private String phone;
    private boolean enabled = true;
    
    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
    private List<UserPayment> userPaymentList;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "user")
    private List<UserShipping> userShippingList;

    @OneToOne(cascade=CascadeType.ALL, mappedBy = "user")
    private ShoppingCart shoppingCart;

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<UserShipping> getUserShippingList() {
        return userShippingList;
    }

    public void setUserShippingList(List<UserShipping> userShippingList) {
        this.userShippingList = userShippingList;
    }

    public List<UserPayment> getUserPaymentList() {
        return userPaymentList;
    }

    public void setUserPaymentList(List<UserPayment> userPaymentList) {
        this.userPaymentList = userPaymentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
}
