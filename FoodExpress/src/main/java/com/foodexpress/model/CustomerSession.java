package com.foodexpress.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CustomerSession {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique=true)
	private Integer customerId;
	private String uniqueId;
	private LocalDateTime timeStamp;
	
	public CustomerSession(Integer customerId, String uniqueId, LocalDateTime timeStamp) {
		super();
		this.customerId = customerId;
		this.uniqueId = uniqueId;
		this.timeStamp = timeStamp;
	}
	
	
	
}
