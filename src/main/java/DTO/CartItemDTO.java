package DTO;

import model.ProductModel;

public class CartItemDTO {
	private Integer id;
	private Integer idCart;
	private ProductModel product;
	private int quantity;
	private Float price;
	public CartItemDTO(Integer id, Integer idCart, ProductModel product, int quantity, Float price) {
		super();
		this.id = id;
		this.idCart = idCart;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	public CartItemDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCart() {
		return idCart;
	}
	public void setIdCart(Integer idCart) {
		this.idCart = idCart;
	}
	public ProductModel getProduct() {
		return product;
	}
	public void setProduct(ProductModel product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	
	
}
