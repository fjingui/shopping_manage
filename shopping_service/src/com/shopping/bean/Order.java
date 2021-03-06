package com.shopping.bean;

public class Order {

	private String cust_acct;
	private String cust_order_id;
	private String product_name;
	private String factory_name;
	private int product_id;
	private float product_price;
	private String product_unit;
	private int product_stor;
	private String factory_log;
    private int order_amount;
    private float order_money;
    private String order_status;
    private String saler_cust_acct;
    private float express_chrg;
    private float discount_chrg;
    
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
	
	public int getProduct_stor() {
		return product_stor;
	}
	public void setProduct_stor(int product_stor) {
		this.product_stor = product_stor;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
	public String getCust_acct() {
		return cust_acct;
	}
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}
	
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	public String getProduct_unit() {
		return product_unit;
	}
	public void setProduct_unit(String product_unit) {
		this.product_unit = product_unit;
	}
	
	public String getSaler_cust_acct() {
		return saler_cust_acct;
	}
	public void setSaler_cust_acct(String saler_cust_acct) {
		this.saler_cust_acct = saler_cust_acct;
	}
	
	
	public float getExpress_chrg() {
		return express_chrg;
	}
	public void setExpress_chrg(float express_chrg) {
		this.express_chrg = express_chrg;
	}
	public float getDiscount_chrg() {
		return discount_chrg;
	}
	public void setDiscount_chrg(float discount_chrg) {
		this.discount_chrg = discount_chrg;
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
