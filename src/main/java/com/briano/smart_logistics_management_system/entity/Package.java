package com.briano.smart_logistics_management_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "packages")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Package {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private int weight;
	
	@Column(nullable = false)
	private double volume;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private PackageStatus status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sender_id", nullable = false)
	private User sender;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "receiver_id", nullable = false)
	private User receiver;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime depositDateTime;
	
	@Column(nullable = false)
	private LocalDateTime deliveryDatePlanned;
	
	@Column(nullable = false, updatable = false)
	private LocalDateTime deliveryDateTimeDone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "delivery_route_id", nullable = false)
	private DeliveryRoute deliveryRoute;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", nullable = false)
	private Invoice invoice;
}
