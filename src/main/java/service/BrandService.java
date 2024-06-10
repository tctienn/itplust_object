package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.MyConnection;
import model.BrandModel;

public class BrandService {
	private Connection connection;
	private static final String FIND_BY_IDPRODUCT= "SELECT b.id, b.name , b.img \r\n"
			+ "FROM brands b\r\n"
			+ "JOIN product p ON b.id = p.brand\r\n"
			+ "WHERE p.id = ?;";
	public BrandService() {
		connection = MyConnection.getConnection();
	}
	
	
	public BrandModel findByIdProduct(Integer idProduct){
		BrandModel brand = new BrandModel();
		connection = MyConnection.getConnection();
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_IDPRODUCT);) {
			preparedStatement.setInt(1, idProduct);
			ResultSet rs = preparedStatement.executeQuery();			
			if (rs.next()) { 
	             Integer id = rs.getInt("id");
	             String name = rs.getString("name");
	             String img = rs.getString("img");
	             brand = new BrandModel(id, name, img);
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return brand;
	}
	
}
