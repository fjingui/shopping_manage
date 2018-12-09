package com.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;

public class NewCust {

	private int cust_id;
	private String cust_name;
	private String cust_address;
	private String cust_contact_nbr;
	private String cust_acct;
	private int checkflag=1;
	private InputStream inputstream;
	
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}
	public void setCust_contact_nbr(String cust_contact_nbr) {
		this.cust_contact_nbr = cust_contact_nbr;
	}
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}
	
	public String updateCust() throws Exception{
        String sql="UPDATE shopping_cust  SET cust_contact_nbr="+cust_contact_nbr+","
        		+ "cust_address="+"\'"+cust_address+"\'"+","
        		+ "cust_name="+"\'"+cust_name+"\'"+ "WHERE cust_id="+cust_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		return "success";
	}
	public String insertCust() throws Exception{
		String sql1="UPDATE shopping_cust SET checked=0 where cust_acct="+cust_acct;
		String sql2="INSERT INTO shopping_cust(cust_name,cust_address,cust_acct,cust_contact_nbr,checked) "
	        		+ "VALUES ("+"\'"+cust_name+"\'"+","+"\'"+cust_address+"\'"+","+cust_acct+
	        		","+cust_contact_nbr+","+checkflag+")";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql1);
		st.executeUpdate(sql2);
		MySqlConn.realseConn(conn, st);
		return "success";
	}
	public String updateCustStatus() throws Exception{
		String sql1="UPDATE shopping_cust SET checked=0 where cust_acct="+cust_acct;
		String sql2="UPDATE shopping_cust SET checked=1 WHERE cust_id="+cust_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql1);
		st.executeUpdate(sql2);
		MySqlConn.realseConn(conn, st);
		return "success";

	}
	public String delCustAddress() throws Exception{
		String sql="DELETE FROM shopping_cust  WHERE cust_id="+cust_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "success";
		
	}
	public String execute() throws Exception{
		
			insertCust();
		return "success";
	}

	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
	
}
