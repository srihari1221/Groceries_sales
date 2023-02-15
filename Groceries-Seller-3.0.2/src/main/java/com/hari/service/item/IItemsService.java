package com.hari.service.item;

import java.util.List;

import com.hari.entity.Items;

public interface IItemsService  {
	public Items insertItem(Items item);
	public List<Items> getAllItems();
	public List<Items> getByNameLike(String nameLike);
	
}
