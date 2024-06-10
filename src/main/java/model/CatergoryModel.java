package model;

public class CatergoryModel {

	private Integer id;
	private String name;
	private String img;
	public CatergoryModel(Integer id, String name, String img) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
	}
	public CatergoryModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
	
}
