package com.foodexpress.model;

import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Getter
@Setter
public class OrderDetails {
	
	@Id
	private Integer orderId;
	
	private LocalTime orderDate;
	
	private String orderStatus;
	
	@OneToOne(cascade=CascadeType.ALL)
	public FoodCart cart;
	
	
	

}
