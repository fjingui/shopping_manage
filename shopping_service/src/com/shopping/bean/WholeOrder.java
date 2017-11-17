package com.shopping.bean;

import java.util.Date;

public class WholeOrder {

	private String cust_acct;
	private String cust_name;
	private String cust_address;
	private Long cust_contact_nbr;
	private int cust_order_id;
	private String product_name;
	private String factory_name;
	private String factory_addr;
	private float product_price;
	private String price_unit;
	private String factory_log;
    private int order_amount;
    private float order_money;
    private String order_time;
	public String getCust_acct() {
		return cust_acct;
	}
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_address() {
		return cust_address;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public Long getCust_contact_nbr() {
		return cust_contact_nbr;
	}
	public void setCust_contact_nbr(Long cust_contact_nbr) {
		this.cust_contact_nbr = cust_contact_nbr;
	}
	public int getCust_order_id() {
		return cust_order_id;
	}
	public void setCust_order_id(int cust_order_id) {
		this.cust_order_id = cust_order_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	public float getProduct_price() {
		return product_price;
	}
	public void setProduct_price(float product_price) {
		this.product_price = product_price;
	}
	public String getFactory_log() {
		return factory_log;
	}
	public void setFactory_log(String factory_log) {
		this.factory_log = factory_log;
	}
	public int getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public float getOrder_money() {
		return order_money;
	}
	public void setOrder_money(float order_money) {
		this.order_money = order_money;
	}

	
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getPrice_unit() {
		return price_unit;
	}
	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
	}
	@Override
	public String toString() {
		return "WholeOrder [cust_acct=" + cust_acct + ", cust_name="
				+ cust_name + ", cust_address=" + cust_address
				+ ", cust_contact_nbr=" + cust_contact_nbr + ", cust_order_id="
				+ cust_order_id + ", product_name=" + product_name
				+ ", factory_name=" + factory_name + ", factory_addr="
				+ factory_addr + ", product_price=" + product_price
				+ ", price_unit=" + price_unit + ", factory_log=" + factory_log
				+ ", order_amount=" + order_amount + ", order_money="
				+ order_money + ", order_time=" + order_time + "]";
	}

    
}
