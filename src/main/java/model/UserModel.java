package model;

import java.sql.Date;

public class UserModel {
	private Integer id;
	private String userName;
	private String password;
	private String sdt;
	private String role;
	private Date createTime;
	private String gmail;
	public UserModel(Integer id, String userName, String password, String sdt, String role, Date createTime,
			String gmail) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.sdt = sdt;
		this.role = role;
		this.createTime = createTime;
		this.gmail = gmail;
	}
	public UserModel() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
	
	
	
}
