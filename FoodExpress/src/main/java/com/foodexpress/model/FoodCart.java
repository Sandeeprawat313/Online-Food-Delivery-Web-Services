package com.foodexpress.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FoodCart {
	
	@Id
	private Integer cartId;

	@OneToOne
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	public List<Items> itemList=new ArrayList<>();
	
	
	
	

}
