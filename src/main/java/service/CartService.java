package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.CartItemDTO;
import config.MyConnection;
import model.CartModel;

public class CartService {
	private static final String FIND_CART_BY_USER= "SELECT * FROM cart where id_user = ? ";
	private static final String CREATE_CART = "INSERT INTO cart (id_user) VALUES (?);";
	private static final String FIND_CARTITEM_BY_USER= "SELECT * FROM cart_item where id_cart = ? ";
	private static final String UPDATE_CARTITEM = "INSERT INTO cart_item ( id_cart, id_product, quantity, price) VALUES (?, ?, ?, ?);";	
	private static final String UINSERT_CARTITEM = "INSERT INTO cart_item ( id_cart, id_product, quantity, price) VALUES (?, ?, ?, ?);";	
	
	private void createCart(Integer idUser) {
		try (Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(CREATE_CART);) {
			preparedStatement.setInt(1, idUser);
			
			preparedStatement.executeUpdate();		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public CartModel getCart(Integer idUser) {
	    CartModel cart = new CartModel();
	    try (Connection connection = MyConnection.getConnection()) {
	        PreparedStatement preparedStatement = connection.prepareStatement(FIND_CART_BY_USER);
	        preparedStatement.setInt(1, idUser);
	        ResultSet rs = preparedStatement.executeQuery();			
	        if (rs.next()) { 
	            cart = new CartModel(rs.getInt("id"), rs.getInt("id_user"));
	        } else {
	            createCart(idUser);
	            preparedStatement = connection.prepareStatement(FIND_CART_BY_USER);
	            preparedStatement.setInt(1, idUser);
	            rs = preparedStatement.executeQuery();
	            if (rs.next()) {
	                cart = new CartModel(rs.getInt("id"), rs.getInt("id_user"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return cart;
	}

	public List<CartItemDTO> getCartItems(Integer idUser){
		List<CartItemDTO> CartItemDTO = new ArrayList<CartItemDTO>();
		try (Connection connection = MyConnection.getConnection();
			    PreparedStatement preparedStatement = connection.prepareStatement(FIND_CARTITEM_BY_USER)) {
			 	preparedStatement.setInt(1, getCart(idUser).getId());
				ResultSet rs = preparedStatement.executeQuery();		
				while (rs.next()) {
					Integer id = rs.getInt("id");
					Integer idCart = rs.getInt("id_cart");
					Integer idProduct = rs.getInt("id_product");
					int quantity = rs.getInt("quantity");
					Float price = rs.getFloat("price");
					ProductService produtService = new ProductService();
					CartItemDTO.add(new CartItemDTO(idProduct, idCart, produtService.findByid(idProduct), quantity, price));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		return CartItemDTO;
		
	}
	
	
	
	
}
