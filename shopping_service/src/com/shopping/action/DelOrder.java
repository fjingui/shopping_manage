package com.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;

public class DelOrder {

	private String orderid;
	private String cust_acct;
	private InputStream inputstream;
	
	public String deleteOrder() throws Exception{
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		String sql="DELETE FROM ���� WHERE order_status='���ﳵ' and cust_order_id="+orderid+" and cust_acct="+cust_acct;
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		inputstream=new ByteArrayInputStream("�ɹ�"  
                .getBytes("UTF-8"));
		return "success";
		
	}
	public String delallorder() throws Exception{
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		String sql="DELETE FROM ���� WHERE order_status='���ﳵ' and cust_acct="+cust_acct;
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		inputstream=new ByteArrayInputStream("�ɹ�"  
                .getBytes("UTF-8"));
		return "success";
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
}
