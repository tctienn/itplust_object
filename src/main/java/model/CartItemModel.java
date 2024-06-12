package model;

public class CartItemModel {

	private Integer id;
	private Integer idCart;
	private Integer idProduct;
	private int quantity;
	private Float price;
	public CartItemModel(Integer id, Integer idCart, Integer idProduct, int quantity, Float price) {
		super();
		this.id = id;
		this.idCart = idCart;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.price = price;
	}
	public CartItemModel() {
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
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
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
