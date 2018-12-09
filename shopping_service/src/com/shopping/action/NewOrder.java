package com.shopping.action;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;

public class NewOrder {
	
    private String cust_acct;
    private String cust_order_id;
    private int product_id;
    private String order_status;
    private int order_amount;
    private float order_money;
    private float express_chrg;
    private float discount_chrg;
	
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}
	public void setOrder_money(float order_money) {
		this.order_money = order_money;
	}
	
	public void setCust_order_id(String cust_order_id) {
		this.cust_order_id = cust_order_id;
	}
	public void setExpress_chrg(float express_chrg) {
		this.express_chrg = express_chrg;
	}
	public void setDiscount_chrg(float discount_chrg) {
		this.discount_chrg = discount_chrg;
	}
	public void insertOrder() throws Exception{
        String sql="INSERT INTO shopping_orders(cust_acct,cust_order_id,product_id,order_money,order_status,order_amount) "
        		+ "VALUES ("+cust_acct+","+cust_order_id+","+product_id+","+order_money+",\""+order_status+"\","+
        		order_amount+")";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
	}
	public void updateOrder() throws Exception{
        String sql="UPDATE shopping_orders SET order_money="+ order_money +
        		 " express_chrg="+express_chrg+" discount_chrg="+ discount_chrg +" WHERE cust_order_id="+cust_order_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
	}
	public void updateOrderStatus() throws Exception{
        String sql="UPDATE shopping_orders SET order_status= \'"+ order_status +"\' WHERE cust_order_id="+cust_order_id;
        Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
	}
	public String execute() throws Exception{
		insertOrder();
		return "success";
	}
	
}
