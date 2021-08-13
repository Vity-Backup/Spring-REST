package com.example.demo;

public class Product {

	private int id;
	private String pName;
	private String batchNo;
	private double price;
	private int noOfProduct;

	public Product() {

	}

	public Product(int id, String pName, String batchNo, double price, int noOfProduct) {
		super();
		this.id = id;
		this.pName = pName;
		this.batchNo = batchNo;
		this.price = price;
		this.noOfProduct = noOfProduct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoOfProduct() {
		return noOfProduct;
	}

	public void setNoOfProduct(int noOfProduct) {
		this.noOfProduct = noOfProduct;
	}

}
