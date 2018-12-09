package com.manage.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sf.json.JSONObject;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.UserAcct;

public class RegesteUser {

	private String cust_acct;
	private String acct_nbr;
	private String passw;
	private String status;
	private String acct_name;
	private UserAcct useracc;
	private JSONObject userobj = new JSONObject();
	private InputStream inputstream;
	
	public String regesteAcct() throws Exception {
		ResultSet rs_select;
		String qur_sql="select cust_acct,acct_nbr,passwd,status,acct_name"
				+ " FROM cust_account  WHERE cust_acct ="+cust_acct +" and status='在用' ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs_select = st.executeQuery(qur_sql);
		boolean b_ts =rs_select.next();
		
		String sql = "INSERT INTO cust_account(cust_acct,acct_nbr,passwd,status,acct_name) "
        		+ "VALUES ("+cust_acct+","+acct_nbr+","+passw+",\""+status+"\""+",\""+acct_name+"\")";
		if (b_ts){
			inputstream=new ByteArrayInputStream("0".getBytes("UTF-8"));
		}else {
			st.executeUpdate(sql);
			inputstream=new ByteArrayInputStream("1".getBytes("UTF-8"));  
		}              
		
		MySqlConn.realseConn(conn, st);
		return "success";
	}
	public String getUserName() throws Exception{
		ResultSet rs;
		String sql="select cust_acct,acct_nbr,passwd,status,acct_name"
				+ " FROM cust_account  WHERE cust_acct ="+cust_acct +" and status='在用' ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql);
		while (rs.next()){
			useracc = new UserAcct();
			useracc.setAcct_name(rs.getString("acct_name"));
			useracc.setAcct_nbr(rs.getString("acct_nbr"));
			useracc.setCust_acct(rs.getString("cust_acct"));
			useracc.setPassw(rs.getString("passwd"));
		}
		userobj = JSONObject.fromObject(useracc);
		return "success";
	}
	
	public InputStream getInputstream() {
		return inputstream;
	}
	
	public JSONObject getUserobj() {
		return userobj;
	}
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}

	public void setAcct_nbr(String acct_nbr) {
		this.acct_nbr = acct_nbr;
	}

	public void setPassw(String passw) {
		this.passw = passw;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	
}
