package com.shop.model.service;

import com.shop.model.domain.Address;

public interface AddressManageInterface {
    public static String cacheName = "addressCache";

    void addAddress(Address address);
    Address getAddressById(Long addressId);
}
