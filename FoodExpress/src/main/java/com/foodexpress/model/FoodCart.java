package com.foodexpress.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Integer custumerId;

	@Embedded
	@ElementCollection(fetch = FetchType.EAGER)
	private List<Items> itemList = new ArrayList<>();

}
