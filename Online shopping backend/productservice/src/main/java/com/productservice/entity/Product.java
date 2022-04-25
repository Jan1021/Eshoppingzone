package com.productservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.servlet.view.RedirectView;

@Document(collection = "product")
public class Product {
	@Id
	private int productid;
	private int productType;
	private int productprice;
	private String productName;
	private String category;
	private int rating;
	private int review;
	private String imageString;
	private String description;
	private String specification;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public int getProductType() {
		return productType;
	}

	public void setProductType(int productType) {
		this.productType = productType;
	}

	public int getProductprice() {
		return productprice;
	}

	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public String getImageString() {
		return imageString;
	}

	public void setImageString(String imageString) {
		this.imageString = imageString;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Product(int productid, int productType, int productprice, String productName, String category, int rating, int review, String imageString, String description, String specification) {
		this.productid = productid;
		this.productType = productType;
		this.productprice = productprice;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.imageString = imageString;
		this.description = description;
		this.specification = specification;
	}

	public Product() {
	}
}
