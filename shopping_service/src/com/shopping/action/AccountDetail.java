package com.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.AccountActive;
import com.shopping.bean.Factory;

import net.sf.json.JSONArray;

public class AccountDetail {

	private String cust_acct;
	private String pay_type;
	private Float pay_money;
	private Float balance;
	private List<AccountActive> accountlist = new ArrayList();
	private JSONArray accountact = new JSONArray();
	private InputStream inputstream;
	
	public String selectAccountDetail() throws Exception{
		    ResultSet rs;
			String sql22="SELECT account_acct,pay_type,pay_money,pay_date,balance "
					+ "FROM shopping_account_detail where account_acct= "+cust_acct+" ORDER BY pay_date DESC";
			Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			rs=st.executeQuery(sql22);
			while (rs.next()){
			AccountActive acc= new AccountActive();
			acc.setCust_acct(rs.getLong("account_acct"));
			acc.setPay_type(rs.getString("pay_type"));
			acc.setPay_money(rs.getFloat("pay_money"));
			acc.setPay_date(rs.getString("pay_date"));
			acc.setBalance(rs.getFloat("balance"));
			accountlist.add(acc);
			}
			accountact = JSONArray.fromObject(accountlist);
			return "success";
	}
	
	public String insertAccountDetail() throws Exception{
		String sql="";
		if(pay_type.equals("提现")){
			sql="INSERT INTO shopping_account_detail(account_acct,pay_type,pay_money,balance,action) "
	        		+ "VALUES ("+"\'"+cust_acct+"\'"+","+"\'"+pay_type+"\'"+","
				    +pay_money+","+balance+","+"\'待处理\'"+")";
		}else {
			sql="INSERT INTO shopping_account_detail(account_acct,pay_type,pay_money,balance) "
	        		+ "VALUES ("+"\'"+cust_acct+"\'"+","+"\'"+pay_type+"\'"+","
				    +pay_money+","+balance+")";
		}
		System.out.println(sql);
		System.out.println(pay_type);
		
	 Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "success";
	}
	
	public String getAccountBalance() throws Exception{
		ResultSet rs;
		String sql22="SELECT balance FROM shopping_account_detail "
				+ "WHERE account_acct="+cust_acct+"  ORDER BY pay_date DESC LIMIT 1";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql22);
		if (rs.next()){
			Float bal = rs.getFloat("balance");
			inputstream=new ByteArrayInputStream(bal.toString().getBytes("UTF-8"));
		}else{
			inputstream=new ByteArrayInputStream("0".getBytes("UTF-8"));
		}
		return "success";
	}
	
	public InputStream getInputstream() {
		return inputstream;
	}

	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}

	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public void setPay_money(Float pay_money) {
		this.pay_money = pay_money;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public List<AccountActive> getAccountlist() {
		return accountlist;
	}
	public JSONArray getAccountact() {
		return accountact;
	}
	
}
