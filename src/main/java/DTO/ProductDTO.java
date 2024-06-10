package DTO;

import java.sql.Date;
import java.util.List;

import model.BrandModel;
import model.CatergoryModel;
import model.ImagesModel;
import model.SizeModel;

public class ProductDTO {

	private Integer id;
	private String alisa;
	private String name;
	private String mota;
	private String motaNgan;
	
	private Float cost;
	private Float price;
	private String mainImg;
	private Date createAt;
	private int Start;
	private Date updateAt;
	private int enable;
	private int inStock;
	
	
	private BrandModel brand;
	private List<CatergoryModel> catergorys;
	private List<ImagesModel> images;
	private List<SizeModel> sizes;
	public ProductDTO(Integer id, String alisa, String name, String mota, String motaNgan, Float cost, Float price,
			String mainImg, Date createAt, int start, Date updateAt, int enable, int inStock, BrandModel brand,
			List<CatergoryModel> catergorys, List<ImagesModel> images, List<SizeModel> sizes) {
		super();
		this.id = id;
		this.alisa = alisa;
		this.name = name;
		this.mota = mota;
		this.motaNgan = motaNgan;
		this.cost = cost;
		this.price = price;
		this.mainImg = mainImg;
		this.createAt = createAt;
		this.Start = start;
		this.updateAt = updateAt;
		this.enable = enable;
		this.inStock = inStock;
		this.brand = brand;
		this.catergorys = catergorys;
		this.images = images;
		this.sizes = sizes;
	}
	public ProductDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAlisa() {
		return alisa;
	}
	public void setAlisa(String alisa) {
		this.alisa = alisa;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getMotaNgan() {
		return motaNgan;
	}
	public void setMotaNgan(String motaNgan) {
		this.motaNgan = motaNgan;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getMainImg() {
		return mainImg;
	}
	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public int getStart() {
		return Start;
	}
	public void setStart(int start) {
		Start = start;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getInStock() {
		return inStock;
	}
	public void setInStock(int inStock) {
		this.inStock = inStock;
	}
	public BrandModel getBrand() {
		return brand;
	}
	public void setBrand(BrandModel brand) {
		this.brand = brand;
	}
	public List<CatergoryModel> getCatergorys() {
		return catergorys;
	}
	public void setCatergorys(List<CatergoryModel> catergorys) {
		this.catergorys = catergorys;
	}
	public List<ImagesModel> getImages() {
		return images;
	}
	public void setImages(List<ImagesModel> images) {
		this.images = images;
	}
	public List<SizeModel> getSizes() {
		return sizes;
	}
	public void setSizes(List<SizeModel> sizes) {
		this.sizes = sizes;
	}
	
	
}
