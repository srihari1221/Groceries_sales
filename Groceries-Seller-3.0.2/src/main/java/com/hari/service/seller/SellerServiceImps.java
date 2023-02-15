package com.hari.service.seller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.entity.Seller;
import com.hari.repo.SellerRepo;

@Service
public class SellerServiceImps implements ISellerService {
	
	@Autowired
	private SellerRepo sellerRepo;
	
	@Override
	public List<Seller> getAllSellers() {
		return sellerRepo.findAll();
	}
	

}
