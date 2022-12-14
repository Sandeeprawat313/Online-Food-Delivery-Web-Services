package com.foodexpress.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private String category;
	private Integer quantity;
	private Integer costPerUnit;

	public Items(Integer itemId, String itemName, String category, Integer quantity, Integer costPerUnit,
			List<Restaurants> listOfRestaurants) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.category = category;
		this.quantity = quantity;
		this.costPerUnit = costPerUnit;
		this.listOfRestaurants = listOfRestaurants;
	}

	@JsonIgnore// for recurssion problem // but konse me use hoga kese pata 1:25:20
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "itemList")
	private List<Restaurants> listOfRestaurants = new ArrayList<>();

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCostPerUnit() {
		return costPerUnit;
	}

	public void setCostPerUnit(Integer costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public List<Restaurants> getListOfRestaurants() {
		return listOfRestaurants;
	}

	public void setListOfRestaurants(List<Restaurants> listOfRestaurants) {
		this.listOfRestaurants = listOfRestaurants;
	}

}
