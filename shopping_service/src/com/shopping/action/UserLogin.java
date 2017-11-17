package com.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.bean.UserAcct;

public class UserLogin extends ActionSupport implements ModelDriven<UserAcct> {

	private UserAcct useracct;
	private String mphone;
	private String mpassword;
	private InputStream inputstream;
	
	@Override
	public UserAcct getModel() {
		return useracct;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	
	public String checkUser() throws Exception{
		String sql="SELECT count(*) rows FROM cust_acct_login WHERE cust_acct="+mphone+
				" and passwd ="+mpassword;
		System.out.println(sql);
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		if(rs.next()){
		System.out.println(rs.getInt("rows"));
		if (rs.getInt("rows")>0) {
			inputstream=new ByteArrayInputStream("true".getBytes("UTF-8"));
		} else {
			inputstream=new ByteArrayInputStream("false".getBytes("UTF-8"));
		}
		}
		return "success";
	}
}
