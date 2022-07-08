package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.format.annotation.NumberFormat;

public class ShoppingCart implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	private double price; 
	private String plan;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User usr;


	@ManyToMany(mappedBy = "shopping cart",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private List<Plans> allPlans =  new ArrayList<Plans>();
	
	
	public ShoppingCart(Integer id, String plan, double price , List<Plans> allPlans) {
		
		this.id = id;
		this.plan = plan;
		this.price = price;
		this.allPlans = allPlans;
	}
	


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getPlans() {
		return this.plan;
	}

	

	public void setPrice(double price) {
		this.price = price;
	}


	public List<Plans> getAllPlans() {
		return allPlans;
	}


	public void setAllPlans(List<Plans> allPlans) {
		this.allPlans = allPlans;
	}
	
	public void addPlans(Plans plan) {
		this.allPlans.add(plan);
	}
	
	@JsonIgnore
	@JsonProperty(value = "shoppingcart")
	public List<ShoppingCart> getShoppingCart() {
		return cart;
	}
	@JsonIgnore
	public void setCart(List<ShoppingCart> carts) {
		this.cart = carts;
	}
	@Override
	public String toString() {
		return "Cart [shopping_cart_id=" + id + ", plan=" + plan + ", price=" + price + ", =" 
				+ ", allPlans=" + "]";
	}
	
}
