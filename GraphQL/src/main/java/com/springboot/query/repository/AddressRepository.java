package com.springboot.query.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.query.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}