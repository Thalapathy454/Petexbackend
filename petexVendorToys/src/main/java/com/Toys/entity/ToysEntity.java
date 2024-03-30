package com.Toys.entity;


import jakarta.persistence.*;
@Entity
	public class ToysEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String productName;
	    private int stock;
	    private int price;
	    private boolean inStock;
	    @Lob
		@Column(columnDefinition = "LONGBLOB")
		private byte[] image;
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public boolean isInStock() {
			return inStock;
		}
		public void setInStock(boolean inStock) {
			this.inStock = inStock;
		}
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}

	}


