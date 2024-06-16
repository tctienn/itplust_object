package model;

public class TokenModel {

	private Integer id;
	private Integer idUser;
	private String token;
	public TokenModel(Integer id, Integer idUser, String token) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.token = token;
	}
	public TokenModel() {
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
