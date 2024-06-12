package model;

public class CartModel {
	private Integer id;
	private Integer idUser;
	public CartModel(Integer id, Integer idUser) {
		super();
		this.id = id;
		this.idUser = idUser;
	}
	public CartModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	
	
}
