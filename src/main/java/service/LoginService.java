package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import config.MyConnection;
import jakarta.mail.MessagingException;
import model.UserModel;

public class LoginService {

	private static final String CHECK_LOGIN = "SELECT * FROM user where username = ? and password = ?";
	private static final String CREATE_USER = "INSERT INTO user ( username, password, sdt, role, create_time, gmail) VALUES ( ?, ?, ?, null, ?, ?);";
	private static final String CREATE_USER_TOKEN = "INSERT INTO token (user_id, token) VALUES (?, ?); ";
	private static final String FIND_USER_BY_TOKEN = "SELECT * from token where  user_id=? and token = ? ";
	private static final String UPDATE_ROLE_USER = "UPDATE user SET role = 'user' WHERE id = ?; ";

	
	public UserModel login(String userName , String passWord) {
		
		UserModel user = new UserModel();
		
		try (Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(CHECK_LOGIN);) {
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, passWord);
			ResultSet rs = preparedStatement.executeQuery();			
			if (rs.next()) { 
	             Integer id = rs.getInt("id");
	             String name = rs.getString("username");
	             String img = rs.getString("password");
	             int sdt = rs.getInt("sdt");
	             String role = rs.getString("role");
	             String gmail = rs.getString("Gmail");
	             user = new UserModel(id, userName, passWord, img, role, null, gmail);
	             

	        }
			else {
				user = null;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			
	       }
		
		return user;
	
		
	}


	  private String createUserToken(Integer userId, String token) {
	        try (Connection connection = MyConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER_TOKEN);) {
	            
	            preparedStatement.setInt(1, userId);
	            preparedStatement.setString(2, token);
	            
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return token;
	    }
	  public void updateUserToken(Integer userId, String token) {
	        try (Connection connection = MyConnection.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_TOKEN);) {
	            
	            preparedStatement.setInt(1, userId);
	            preparedStatement.setString(2, token);
	            
	            ResultSet rs = preparedStatement.executeQuery();	
	            if (rs.next()) { 
	            	updateUserRole(userId);
		        }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  private void updateUserRole(Integer idUser) {
		  try (Connection connection = MyConnection.getConnection();
		             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ROLE_USER);) {
		      
		            preparedStatement.setInt(1, idUser);
		            preparedStatement.executeUpdate();	
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
	  }
	  private  String randomToken() {
		  int length = 10;
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder result = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < length; i++) {
	            result.append(characters.charAt(random.nextInt(characters.length())));
	        }

	        return result.toString();
	    }
	
	public Integer createUser(UserModel user) {
		
		Integer idUser = null;
		try ( Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);) {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getSdt());
			preparedStatement.setDate(4, new java.sql.Date(System.currentTimeMillis()));
			preparedStatement.setString(5, user.getGmail());		
//			preparedStatement.executeUpdate();
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0) {
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                	idUser = generatedKeys.getInt(1);
	                	  String token=createUserToken(idUser, randomToken());
	                	  GmailService gmailService = new GmailService();
	                	  gmailService.sendEmail(user.getGmail(), "xác nhận gmail bằng cách ấn vào link", "http://localhost:8080/baocao/login?action=access&iduser="+idUser+"&token="+token);
	                	  
	                }
	            }
	        }
		}catch (MessagingException | SQLException e) {
			e.printStackTrace();
		}
		
		return idUser;
	}

}
