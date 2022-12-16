package com.foodexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodexpress.model.Items;

public interface ItemsDao extends JpaRepository<Items, Integer>
{

	public List<Items> findByItemName(String itemName);

}
