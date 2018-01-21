package com.shopping.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seller {
	
	private int factory_id;
	private String factory_name;
	private String factory_addr;
	private Long fac_contact_nbr;
	private String join_date;
	private String factory_log;
	private String comment;
	private int product_id;
	private String product_name;
	private Float product_price;
	private String price_unit;
	private String product_desc ;
	private List<ProImg> pro_imgs=new ArrayList<ProImg>();
	
	public int getFactory_id() {
		return factory_id;
	}
	public void setFactory_id(int factory_id) {
		this.factory_id = factory_id;
	}
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}
	public String getFactory_addr() {
		return factory_addr;
	}
	public void setFactory_addr(String factory_addr) {
		this.factory_addr = factory_addr;
	}
	public Long getFac_contact_nbr() {
		return fac_contact_nbr;
	}
	public void setFac_contact_nbr(Long fac_contact_nbr) {
		this.fac_contact_nbr = fac_contact_nbr;
	}
	public String getJoin_date() {
		return join_date;
	}
	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}
	public String getFactory_log() {
		return factory_log;
	}
	public void setFactory_log(String factory_log) {
		this.factory_log = factory_log;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}
	public String getPrice_unit() {
		return price_unit;
	}
	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public List<ProImg> getPro_imgs() {
		return pro_imgs;
	}
	public void setPro_imgs(List<ProImg> pro_imgs) {
		this.pro_imgs = pro_imgs;
	}
	

}
