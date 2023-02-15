package com.hari.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name ="Order_Details")
public class Orders {
	
	@Id
//	@SEQUENCEGENERATOR(NAME = "GEN2",SEQUENCENAME = "ORDER_SEQ", INITIALVALUE = 1000,ALLOCATIONSIZE = 1)
//	@GeneratedValue(generator = "gen2",strategy = GenerationType.SEQUENCE)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer customerId;
	private List<String> itemsList;
	private List<Integer> quantityList;
	private Double totalAmount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public List<String> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<String> itemsList) {
		this.itemsList = itemsList;
	}
	public List<Integer> getQuantityList() {
		return quantityList;
	}
	public void setQuantityList(List<Integer> quantityList) {
		this.quantityList = quantityList;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerId=" + customerId + ", itemsList=" + itemsList + ", quantityList="
				+ quantityList + ", totalAmount=" + totalAmount + "]";
	}
	
	
	
}
