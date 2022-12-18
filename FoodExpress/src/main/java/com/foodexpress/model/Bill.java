package com.foodexpress.model;

import java.time.LocalDateTime;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;

	@NonNull
	@NotBlank
	@NotEmpty
	@Size(min = 3, max = 10, message = "customerName name should 3 to 10")
	private String customerName;

	@NonNull
	@NotBlank
	@NotEmpty
	private LocalDateTime billDate;

	private Double totalCost;

	private Integer totalItem;

	@Embedded
	Address cAddress;

}
