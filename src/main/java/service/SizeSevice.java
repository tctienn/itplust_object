package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.MyConnection;
import model.SizeModel;

public class SizeSevice {
	private Connection connection;
	private static final String FIND_BY_IDPRODUCT=  "SELECT c.id, c.name  \r\n"
			+ "FROM size c\r\n"
			+ "JOIN product_size pc ON c.id = pc.id_size\r\n"
			+ "WHERE pc.id_product = ?;\r\n";
	public SizeSevice() {
//		connection = MyConnection.getConnection();
	}
	
	public List<SizeModel> findByIdProduct(Integer idProduct){
		List<SizeModel> sizes = new ArrayList<>();
		connection = MyConnection.getConnection();
		
		try (Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_IDPRODUCT);) {
			preparedStatement.setInt(1, idProduct);
			ResultSet rs = preparedStatement.executeQuery();			
			while (rs.next()) {
				 Integer id = rs.getInt("id");
				 String name = rs.getString("name");
				 sizes.add(new SizeModel(id, name));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sizes;
	}
	
	
}
