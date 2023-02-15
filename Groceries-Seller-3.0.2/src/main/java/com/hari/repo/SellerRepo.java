package com.hari.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.entity.Seller;

public interface SellerRepo extends JpaRepository<Seller, Integer> {

}
