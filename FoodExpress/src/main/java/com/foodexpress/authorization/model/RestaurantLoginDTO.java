package com.foodexpress.authorization.model;

import lombok.Data;

@Data
public class RestaurantLoginDTO {
	private String mobileNo;
	private String password;
}
