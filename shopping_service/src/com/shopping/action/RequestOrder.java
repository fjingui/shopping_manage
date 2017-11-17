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
	private String orderstatus;
	private List<Order> orderlist = new ArrayList<Order>();
	private JSONArray orderjson = new JSONArray();

	public String queryOrder() throws Exception {
		String sql = "SELECT b.product_name,b.product_price,a.cust_order_id,a.order_amount,a.order_money,c.factory_name,"
				+ "c.factory_log FROM 订单 a LEFT JOIN 商品 b ON (a.product_id=b.product_id) "
				+ "LEFT JOIN 商家 c ON (b.factory_id=c.factory_id) WHERE a.order_status="
				+ "\""+orderstatus+"\"" + " AND cust_acct=" + cust_acct;
		Connection conn = MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		ResultSet rs = st.executeQuery(sql); 
		while (rs.next()) {
			Order order = new Order();
			order.setCust_order_id(rs.getInt("cust_order_id"));
			order.setFactory_log(rs.getString("factory_log"));
			order.setFactory_name(rs.getString("factory_name"));
			order.setProduct_name(rs.getString("product_name"));
			order.setProduct_price(rs.getFloat("product_price"));
			order.setOrder_amount(rs.getInt("order_amount"));
			order.setOrder_money(rs.getFloat("order_money"));
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
