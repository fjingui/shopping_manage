package com.shopping.bean;

public class Pro_Img {
	
	private int product_id;
	private int pro_img_id;
	private String pro_Img_Addr;
	private String pro_Img_Desc;
	public String getPro_Img_Addr() {
		return pro_Img_Addr;
	}
	public void setPro_Img_Addr(String pro_Img_Addr) {
		this.pro_Img_Addr = pro_Img_Addr;
	}
	public String getPro_Img_Desc() {
		return pro_Img_Desc;
	}
	public void setPro_Img_Desc(String pro_Img_Desc) {
		this.pro_Img_Desc = pro_Img_Desc;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getPro_img_id() {
		return pro_img_id;
	}
	public void setPro_img_id(int pro_img_id) {
		this.pro_img_id = pro_img_id;
	}
	public Pro_Img(String pro_Img_Addr, String pro_Img_Desc) {
		super();
		this.pro_Img_Addr = pro_Img_Addr;
		this.pro_Img_Desc = pro_Img_Desc;
	}
	public Pro_Img() {
		super();
	}

	
	

}
