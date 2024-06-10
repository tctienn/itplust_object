package model;

public class ImagesModel {
	private Integer id;
	private Integer idProduct;
	private String url;
	public ImagesModel(Integer id, Integer idProduct, String url) {
		super();
		this.id = id;
		this.idProduct = idProduct;
		this.url = url;
	}
	public ImagesModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
