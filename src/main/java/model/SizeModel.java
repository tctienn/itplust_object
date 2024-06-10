package model;

public class SizeModel {

	private Integer id;
	private String name;
	public SizeModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public SizeModel() {
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
	
	
}
