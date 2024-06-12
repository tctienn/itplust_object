package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.ProductDTO;
import config.MyConnection;
import model.BrandModel;
import model.CatergoryModel;
import model.ImagesModel;
import model.ProductModel;
import model.SizeModel;

public class ProductService {

	private CatergoryService catergoryService = new CatergoryService();
	private BrandService brandService = new BrandService();
	private ImagesService imagesService = new ImagesService();
	private SizeSevice sizeService = new SizeSevice();
	private Connection connection;
	private static final String SELECT_ALL_PRODUCT_PAGE = "SELECT * FROM product LIMIT ?, ?";
	private static final String FIND_BY_ID = "SELECT * FROM product where id = ?";

	public ProductService() {
//		connection = MyConnection.getConnection();

		
	}
	public List<ProductDTO> getProductPage(int page, int size) {
		List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
		try ( Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_PAGE);) {
			preparedStatement.setInt(1, (page-1)*size);
			preparedStatement.setInt(2, size);
			ResultSet rs = preparedStatement.executeQuery();		
			while (rs.next()) {
				 Integer id = rs.getInt("id");
				 String alisa = rs.getString("alias");
				 String name = rs.getString("name");
				 String mota = rs.getString("mota");
				 String motaNgan= rs.getString("mota_ngan");
				 Integer idBrand = rs.getInt("brand");
				 Float cost = rs.getFloat("cost");
				 Float price = rs.getFloat("gia");
				 String mainImg = rs.getString("main_img");
				 Date createAt = rs.getDate("create_at");
				 int Start = rs.getInt("start");
				 Date updateAt = rs.getDate("update_at");
				 int enable = rs.getInt("enable");
				 int inStock = rs.getInt("in_stock");
				 List<CatergoryModel> catergorys = new ArrayList<CatergoryModel>();
				 if(catergoryService.findByIdProduct(id) != null) {
					 catergorys=(catergoryService.findByIdProduct(id));
				 }
				 BrandModel brand = brandService.findByIdProduct(id);
				 List<ImagesModel> images = new ArrayList<ImagesModel>();
				 if(imagesService.findByIdProduct(id) != null) {
					 images = imagesService.findByIdProduct(id);
				 }
				 List<SizeModel> sizes = new ArrayList<SizeModel>();
				 if(sizeService.findByIdProduct(id) != null) {
					 sizes = sizeService.findByIdProduct(id);
				 }
				productDTOs.add(new ProductDTO(idBrand, alisa, name, mota, motaNgan, cost, price, mainImg, createAt, Start, updateAt, enable, inStock, brand, catergorys, images, sizes));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return productDTOs;
	}
	
	public ProductModel findByid(Integer idProduct) {
		
		ProductModel product = new ProductModel();
		try (Connection connection = MyConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);) {
			preparedStatement.setInt(1, idProduct);
			ResultSet rs = preparedStatement.executeQuery();			
			if (rs.next()) { 
				Integer id = rs.getInt("id");
				 String alisa = rs.getString("alias");
				 String name = rs.getString("name");
				 String mota = rs.getString("mota");
				 String motaNgan= rs.getString("mota_ngan");
				 Integer idBrand = rs.getInt("brand");
				 Float cost = rs.getFloat("cost");
				 Float price = rs.getFloat("gia");
				 String mainImg = rs.getString("main_img");
				 Date createAt = rs.getDate("create_at");
				 int Start = rs.getInt("start");
				 Date updateAt = rs.getDate("update_at");
				 int enable = rs.getInt("enable");
				 int inStock = rs.getInt("in_stock");
	             product = new ProductModel(id, alisa, name, mota, motaNgan, idBrand, cost, price, mainImg, createAt, Start, updateAt, enable, inStock);
	        }
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
	       }
		
		return product;
		
	}
	
}
