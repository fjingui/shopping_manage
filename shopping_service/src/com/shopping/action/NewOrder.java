package com.shopping.action;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;

public class NewOrder {

    private String cust_acct;
    private int product_id;
    private String order_status;
    private int order_amount;
    private float order_money;
	
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
	
	public void updateOrder() throws Exception{
        String sql="INSERT INTO ����(cust_acct,product_id,order_money,order_status,order_amount) "
        		+ "VALUES ("+cust_acct+","+product_id+","+order_money+",\""+order_status+"\","+
        		order_amount+")";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
	}
	public String execute() throws Exception{
		updateOrder();
		return "success";
	}
}
