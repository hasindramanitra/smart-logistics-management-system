package com.briano.smart_logistics_management_system.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String plateNumber;
	
	@Column(nullable = false)
	private double capacityWeight;
	
	@Column(nullable = false)
	private double capacityVolume;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private VehicleStatus status;
}
