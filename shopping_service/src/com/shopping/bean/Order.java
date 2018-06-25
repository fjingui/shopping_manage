package com.shopping.bean;

public class Order {

	private String cust_order_id;
	private String product_name;
	private String factory_name;
	private int product_id;
	private float product_price;
	private String factory_log;
    private int order_amount;
    private float order_money;
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
	public String getCust_order_id() {
		return cust_order_id;
	}
	public void setCust_order_id(String cust_order_id) {
		this.cust_order_id = cust_order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "Order [cust_order_id=" + cust_order_id + ", product_name="
				+ product_name + ", factory_name=" + factory_name
				+ ", product_id=" + product_id + ", product_price="
				+ product_price + ", factory_log=" + factory_log
				+ ", order_amount=" + order_amount + ", order_money="
				+ order_money + "]";
	}
    
       
}
