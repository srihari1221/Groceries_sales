package com.hari.entity;

import java.sql.Blob;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Items {
	@Id
//	@SequenceGenerator(name = "gen3",sequenceName = "items_seq", initialValue = 1,allocationSize = 1)
//	@GeneratedValue(generator = "gen3",strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	/*		@Lob
			private Blob image;*/
	@Lob
	private byte[] image;
	private Double price;
	private String quantity;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}*/
	
	public Double getPrice() {
		return price;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Items [id=" + id + ", name=" + name + ", image=" + Arrays.toString(image) + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	

}
