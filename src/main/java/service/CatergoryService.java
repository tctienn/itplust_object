package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.MyConnection;
import model.CatergoryModel;

public class CatergoryService {

	private Connection connection;
	private static final String SELECT_ALL_CATERGORY = "select * from category";
	private static final String FIND_BY_ID = "select * from category where id = ?";
	private static final String FIND_BY_IDPRODUCT = "SELECT c.id, c.name , c.img \r\n"
			+ "FROM category c\r\n"
			+ "JOIN product_catergory pc ON c.id = pc.id_catergory\r\n"
			+ "WHERE pc.id_product = ?;\r\n";
			
	public CatergoryService() {
		
	}
	
	public List<CatergoryModel> getCatergorys(){
		List<CatergoryModel> catergorys = new ArrayList<>();
		
		// Sử dụng try-with-resources cho Connection và PreparedStatement
		try (Connection connection = MyConnection.getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATERGORY)) {
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String img = rs.getString("img");
				
				catergorys.add(new CatergoryModel(id, name, img));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return catergorys;
	}
	
	public List<CatergoryModel> findByIdProduct(Integer idProduct ){
		List<CatergoryModel> catergorys = new ArrayList<>();

		
		try (Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_IDPRODUCT);) {
			preparedStatement.setInt(1, idProduct);
			ResultSet rs = preparedStatement.executeQuery();			
			while (rs.next()) {
				 Integer id = rs.getInt("id");
				 String name = rs.getString("name");
				 String img = rs.getString("img");
				 catergorys.add(new CatergoryModel(id, name, img));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return catergorys;
	}

	
	
}
