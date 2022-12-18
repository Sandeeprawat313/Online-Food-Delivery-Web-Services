package com.foodexpress.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;

	@Size(min = 3, max = 10, message = "Item Name  should 3 to 20")
	private String itemName;

	@Size(min = 3, max = 10, message = "Category name should 3 to 20")
	private String category;

	private Integer quantity;

	private Integer costPerUnit;

	@JsonIgnore // for recurssion problem // but konse me use hoga kese pata 1:25:20
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "itemList") //
	private List<Restaurants> listOfRestaurants = new ArrayList<>();

}
