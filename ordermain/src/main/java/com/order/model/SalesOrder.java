package com.order.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales_order")
public class SalesOrder {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Date orderDate;

	
	@Column
	private long custId;
	@Column
	private String orderDesc;
	@Column
	private double totalPrice;
	public SalesOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesOrder(Long id, @NotNull Date orderDate, @NotNull long custId, String orderDesc, double totalPrice) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDesc = orderDesc;
		this.totalPrice = totalPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", orderDate=" + orderDate + ", custId=" + custId + ", orderDesc=" + orderDesc
				+ ", totalPrice=" + totalPrice + "]";
	}

	
}
