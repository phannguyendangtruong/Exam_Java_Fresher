package com.dangtruong.entity;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employeeId")
	private Integer id;
	private String firstName;
	private String lastName;
	private Double salaryMonthly;
	
}
