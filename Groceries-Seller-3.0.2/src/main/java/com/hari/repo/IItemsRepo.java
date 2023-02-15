package com.hari.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hari.entity.Items;

public interface IItemsRepo extends JpaRepository<Items, Integer> {
	
	List<Items> findByNameLike(String name);

}
