package com.hari.service.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hari.entity.Items;
import com.hari.repo.IItemsRepo;
@Service
public class ItemsServiceImps implements IItemsService{

	@Autowired
	private IItemsRepo itemRepo;
	@Override
	public Items insertItem(Items item) {
		return itemRepo.save(item);
	}
	@Override
	public List<Items> getAllItems() {
		System.out.println("All items are returned");
		return itemRepo.findAll();
	}
	@Override
	public List<Items> getByNameLike(String nameLike) {
		
		return itemRepo.findByNameLike(nameLike);
	}
	


}
