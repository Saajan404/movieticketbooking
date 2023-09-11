package com.mtb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtb.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
