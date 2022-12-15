package com.foodexpress.authorization.model;

import lombok.Data;

@Data
public class CustomerLoginDTO {
	private String mobileNumber;
	private String password;
}
