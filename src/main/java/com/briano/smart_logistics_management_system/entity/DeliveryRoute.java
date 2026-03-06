package com.briano.smart_logistics_management_system.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "delivery_route")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryRoute {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private LocalDate deliveryDate;
	
	@Column(nullable = false)
	private String zone;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private DeliveryRouteStatus status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "driver_id", nullable = false)
	private Driver driver;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vehicle_id", nullable = false)
	private Vehicle vehicle;
	
	@OneToMany(mappedBy = "deliveryRoute", cascade = CascadeType.ALL)
	private List<Package> packages;
	
	
	
}
