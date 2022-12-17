package com.foodexpress.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address
{
	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 15, message = "Building name should 4 to 15")
	private String buildingName;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 1, message = "Please enter valid street Number")
	private String streetNo;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 10, message = "Area name should 4 to 10")
	private String area;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 10, message = "City name should 4 to 10")
	private String city;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 4, max = 15, message = "State name should 4 to 15")
	private String State;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 6, max = 6, message = "Building name should 6")
	private String pincode;

}
