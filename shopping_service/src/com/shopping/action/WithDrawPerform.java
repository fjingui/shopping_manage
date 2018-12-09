package com.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.AccountActive;

public class WithDrawPerform {

	private List<AccountActive> performlist = new ArrayList();
	private int account_detail_id;
	private String paytype ="提现";
	private String perform ="待处理";
	private String perform02 ="已完成";
	private InputStream inputstream;
	private JSONArray performjson = new JSONArray();
	
	public String selectWithPerform() throws Exception{
	    ResultSet rs;
		String sql="SELECT account_detail_id,account_acct,pay_type,pay_money,pay_date,balance,action "
				+ "FROM shopping_account_detail where pay_type= \'"+paytype+"\' and action= \'"+perform+"\' ORDER BY pay_date";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql);
		while (rs.next()){
		AccountActive acc= new AccountActive();
		acc.setAccount_detail_id(rs.getInt("account_detail_id"));
		acc.setCust_acct(rs.getLong("account_acct"));
		acc.setPay_type(rs.getString("pay_type"));
		acc.setPay_money(rs.getFloat("pay_money"));
		acc.setPay_date(rs.getString("pay_date"));
		acc.setBalance(rs.getFloat("balance"));
		acc.setAction(rs.getString("action"));
		performlist.add(acc);
		}
		performjson = JSONArray.fromObject(performlist);
		return "success";
}
	public String updateWithPerform() throws Exception{
		
		String sql="UPDATE shopping_account_detail  SET action=\'"+perform02+"\'"
						+ "  WHERE account_detail_id="+account_detail_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		inputstream=new ByteArrayInputStream("更新成功".getBytes("UTF-8"));
		MySqlConn.realseConn(conn, st);
		return "success";
	}

	public void setAccount_detail_id(int account_detail_id) {
		this.account_detail_id = account_detail_id;
	}
	public JSONArray getPerformjson() {
		return performjson;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
}
