package com.foodexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodexpress.model.Restaurants;

@Repository
public interface RestaurantDao extends JpaRepository<Restaurants, Integer>
{


	public Restaurants findByContactNumber(String contactNumber);

	///////////////////////////////////////////////////////////////

    @Query("select r from Restaurants r")
	public List<Restaurants> getRestByLocation();

	//////////////////////////////////////////////////////////////////

	public Restaurants findByRestaurantName(String restaurantName);

	@Query("select r from Restaurants r where r.restaurantName=?1")
	public Restaurants getResByName(String restaurantName);

}
 