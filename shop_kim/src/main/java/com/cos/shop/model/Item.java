package com.cos.shop.model;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder 
@Entity 
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please type item name")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message="Please type item details")
	@Lob
	@Column(nullable = false)
	private String detail;
	
	@NotNull(message="Please type item price")
	@Column(nullable = false)
	private int price;
	
	@NotNull(message="Please type quantity of item")
	@Column(nullable = false)
	@ColumnDefault("0")
	private int amount;
	
	@Enumerated(EnumType.STRING)
	private SellStatus status; 
	

	
	@OneToMany(mappedBy = "item",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE) 
	@JsonIgnoreProperties({"item"}) 
	@OrderBy("id desc") 
	private List<Review> reviews;  
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User user; 
	
	@CreationTimestamp
	private Timestamp createDate; 
}
