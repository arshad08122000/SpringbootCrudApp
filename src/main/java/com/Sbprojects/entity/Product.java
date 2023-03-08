package com.Sbprojects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name="product_tbll")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="Product_name")
	private String Name;
	
	private String Description;
	private String Price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String description, String price) {
		super();
		Name = name;
		Description = description;
		Price = price;
	}
	
	@Override
	public String toString() {
		return "Product [Id=" + Id + ", Name=" + Name + ", Description=" + Description + ", Price=" + Price + "]";
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
}
