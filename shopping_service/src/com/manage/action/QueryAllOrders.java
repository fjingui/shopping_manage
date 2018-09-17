package com.manage.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.Order;
import com.shopping.bean.WholeOrder;

public class QueryAllOrders {
	
	private List<WholeOrder> allorders=new ArrayList<WholeOrder>();
	private JSONArray allorderjson=new JSONArray();
	private String begindate;
	private String enddate;
	
//	public String queryAllOrders() throws Exception{
//		String begindate2=begindate.replaceAll("-", "");
//		String enddate2=enddate.replaceAll("-", "");
//		String sql = "SELECT d.cust_acct,d.cust_name,d.cust_address,d.cust_contact_nbr,c.factory_log,a.cust_order_id,"
//				+ "c.factory_name,c.factory_addr,b.product_name,b.product_price,b.price_unit,a.order_amount,a.order_money ,a.order_time "
//				+"FROM 订单 a LEFT JOIN 商品 b ON (a.product_id=b.product_id) LEFT JOIN 商家 c ON (b.factory_id=c.factory_id) LEFT JOIN "
//                +"(SELECT * FROM 客户 WHERE checked=1 ) d ON (a.cust_acct=d.cust_acct) "
//                + "WHERE a.order_status='已验收' AND DATE_FORMAT(a.order_time,'%Y%m%d') BETWEEN " + begindate2 +" AND "+ enddate2 ;
//		Connection conn = MySqlConn.getConnection();
//		Statement st = (Statement) conn.createStatement();
//		ResultSet rs = st.executeQuery(sql); 
//		while (rs.next()) {
//			WholeOrder order = new WholeOrder();
//			order.setCust_acct(rs.getString("cust_acct"));
//			order.setCust_name(rs.getString("cust_name"));
//			order.setCust_address(rs.getString("cust_address"));
//			order.setCust_contact_nbr(rs.getLong("cust_contact_nbr"));
//			order.setFactory_log(rs.getString("factory_log"));
//			order.setFactory_addr(rs.getString("factory_addr"));
//			order.setFactory_name(rs.getString("factory_name"));
//			order.setProduct_name(rs.getString("product_name"));
//			order.setProduct_price(rs.getFloat("product_price"));
//			order.setPrice_unit(rs.getString("price_unit"));
//			order.set
//			order.setOrder_amount(rs.getInt("order_amount"));
//			order.setOrder_money(rs.getFloat("order_money"));
//			order.setOrder_time(rs.getString("order_time"));
//			allorders.add(order);
//		}
//		allorderjson = JSONArray.fromObject(allorders);
//		System.out.println(allorderjson.toString());
//		MySqlConn.realseConn(conn, st);
//		return "success";
//	}

	public JSONArray getAllorderjson() {
		return allorderjson;
	}

	public void setAllorderjson(JSONArray allorderjson) {
		this.allorderjson = allorderjson;
	}

	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
}
