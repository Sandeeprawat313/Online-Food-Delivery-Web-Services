package com.foodexpress.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
@NoArgsConstructor
@AllArgsConstructor
public class Restaurants
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer restaurantId;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Restaurent name should 3 to 10")
	private String restaurantName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Restaurent Manager Name name should 3 to 10")
	private String managerName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 10, max = 10, message = "Contact Number should 3 to 10")
	private String contactNumber;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password length should be 3 to 10")
	private String password;

	@Embedded
	private Address address;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Items> itemList = new ArrayList<>();

}
