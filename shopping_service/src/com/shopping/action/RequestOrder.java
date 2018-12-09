package com.shopping.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.Order;

public class RequestOrder {
	private String cust_acct;
	private String orderstatus=""; 
	
	private List<Order> orderlist = new ArrayList<Order>();
	private JSONArray orderjson = new JSONArray();
	
	//消费者购买订单，根据消费者在订单表cust_acct
	public String queryOrder() throws Exception {
		ResultSet rs;
		String sql = "SELECT b.product_name,b.product_price,b.product_unit,b.product_stor,a.cust_acct,a.product_id,a.cust_order_id,a.order_amount,a.order_status,a.order_money,c.factory_name,"
				+ "a.express_chrg,a.discount_chrg, c.factory_log,c.saler_cust_acct FROM shopping_orders a LEFT JOIN shopping_sales b ON (a.product_id=b.product_id) "
				+ "LEFT JOIN shopping_salers c ON (b.factory_id=c.factory_id) WHERE a.order_status in "
				+ "("+orderstatus+")" + " AND a.cust_acct=" + cust_acct;
		Connection conn = MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs = st.executeQuery(sql);
		while (rs.next()) {
			Order order = new Order();
			order.setCust_order_id(rs.getString("cust_order_id"));
			order.setCust_acct(rs.getString("cust_acct"));
			order.setFactory_log(rs.getString("factory_log"));
			order.setFactory_name(rs.getString("factory_name"));
			order.setProduct_id(rs.getInt("product_id"));
			order.setProduct_name(rs.getString("product_name"));
			order.setProduct_price(rs.getFloat("product_price"));
			order.setProduct_unit(rs.getString("product_unit"));
			order.setProduct_stor(rs.getInt("product_stor"));
			order.setOrder_amount(rs.getInt("order_amount"));
			order.setOrder_money(rs.getFloat("order_money"));
			order.setOrder_status(rs.getString("order_status"));
			order.setSaler_cust_acct(rs.getString("saler_cust_acct"));
			order.setExpress_chrg(rs.getFloat("express_chrg"));
			order.setDiscount_chrg(rs.getFloat("discount_chrg"));
			orderlist.add(order);
		}
		MySqlConn.realseConn(conn, st);
		orderjson = JSONArray.fromObject(orderlist);
		return "success";
	}

	//销售者销售订单，根据销售商表cust_acct
public String querySalerOrders() throws Exception{
	String sql = "SELECT b.product_name,b.product_price,b.product_unit,b.product_stor,c.cust_acct,c.product_id,c.cust_order_id,c.order_status,c.order_amount,c.order_money,a.factory_name,"
			+ "c.express_chrg,c.discount_chrg,a.factory_log,a.saler_cust_acct FROM shopping_salers a inner JOIN shopping_sales b ON (a.factory_id=b.factory_id) "
			+ "inner JOIN shopping_orders c ON (b.product_id=c.product_id) WHERE c.order_status in "
			+ "("+orderstatus+")" + " AND a.saler_cust_acct=" + cust_acct;
	Connection conn = MySqlConn.getConnection();
	Statement st = (Statement) conn.createStatement();
	ResultSet rs = st.executeQuery(sql); 
	while (rs.next()) {
		Order order = new Order();
		order.setCust_order_id(rs.getString("cust_order_id"));
		order.setFactory_log(rs.getString("factory_log"));
		order.setFactory_name(rs.getString("factory_name"));
		order.setProduct_id(rs.getInt("product_id"));
		order.setProduct_name(rs.getString("product_name"));
		order.setProduct_price(rs.getFloat("product_price"));
		order.setProduct_unit(rs.getString("product_unit"));
		order.setProduct_stor(rs.getInt("product_stor"));
		order.setOrder_amount(rs.getInt("order_amount"));
		order.setOrder_money(rs.getFloat("order_money"));
		order.setCust_acct(rs.getString("cust_acct"));
		order.setOrder_status(rs.getString("order_status"));
		order.setSaler_cust_acct(rs.getString("saler_cust_acct"));
		order.setExpress_chrg(rs.getFloat("express_chrg"));
		order.setDiscount_chrg(rs.getFloat("discount_chrg"));
		orderlist.add(order);
	}
	MySqlConn.realseConn(conn, st);
	orderjson = JSONArray.fromObject(orderlist);
	return "success";
}

	public JSONArray getOrderjson() {
		return orderjson;
	}

	public void setOrderjson(JSONArray orderjson) {
		this.orderjson = orderjson;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}

}
