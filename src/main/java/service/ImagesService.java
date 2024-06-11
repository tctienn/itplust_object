package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.MyConnection;
import model.ImagesModel;

public class ImagesService {

	private Connection connection;
	private static final String FIND_BY_IDPRODUCT= "SELECT * from images where id_product = ? ";
	public ImagesService() {
//		connection = MyConnection.getConnection();
	}
	
	public List<ImagesModel> findByIdProduct(Integer idParam){
		List<ImagesModel> images = new ArrayList<>();
		connection = MyConnection.getConnection();
		
		try (Connection connection = MyConnection.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_IDPRODUCT);) {
			preparedStatement.setInt(1, idParam);
			ResultSet rs = preparedStatement.executeQuery();			
			while (rs.next()) {
				 Integer id = rs.getInt("id");
				  Integer idProduct = rs.getInt("id_product");
				 String url = rs.getString("url");
				 images.add( new ImagesModel(id, idProduct, url));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return images;
	}
	
}
