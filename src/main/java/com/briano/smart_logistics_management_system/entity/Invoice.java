package com.briano.smart_logistics_management_system.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "factures")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
	private List<Package> packages;
	
	@Column(nullable = true)
	private LocalDateTime issueDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus;
	
	@Column(nullable = false)
	private LocalDateTime paymenDateTime;
	
	@Column(nullable = false)
	private String pdfFile;
}
