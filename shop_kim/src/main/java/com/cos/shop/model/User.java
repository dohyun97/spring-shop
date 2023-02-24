package com.cos.shop.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@Entity 
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id; 
	 
	@NotBlank(message="Please type username")
	@Column(nullable = false, length = 30, unique = true) 
	private String username; 
	
	@NotBlank(message="Please type password")
	@Length(min=7,message="Password should be longer than 7")
	@Column(nullable = false, length = 100) 
	private String password;
	
	@NotBlank(message="Please type email")
	@Column(nullable = false, length = 50)
	private String email; 
	
	@NotBlank(message="Please type address")
	@Column(nullable=false)
	private String address;

	@Enumerated(EnumType.STRING)
	private RoleType role; 
	
	
	@CreationTimestamp
	private Timestamp createDate;


	
	
}