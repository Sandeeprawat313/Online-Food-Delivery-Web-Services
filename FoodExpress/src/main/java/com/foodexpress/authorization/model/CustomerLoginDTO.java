package com.foodexpress.authorization.model;

import lombok.Data;

@Data
public class CustomerLoginDTO {
	private String mobileNo;
	private String password;
}
