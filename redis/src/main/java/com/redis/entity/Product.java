package com.redis.entity;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
	int id;
	String name;
	int qty;
	int price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product(int id, String name, int qty, int price) {
		super();
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}

}
