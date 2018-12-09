package com.shopping.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RequestCust {

	private String cust_acct;
	private User user=new User();
	private JSONObject userjson= new JSONObject();
	private List<User> userlist=new ArrayList<User>();
	private JSONArray userlistjson=new JSONArray();
	
	public String queryCust() throws Exception{
		String sql="SELECT cust_id,cust_name,cust_address,cust_contact_nbr,cust_acct "
				+ "FROM shopping_cust  WHERE checked=1 AND cust_acct="+cust_acct +" order by cust_id DESC limit 1 ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()){
		user.setCust_acct(rs.getString("cust_acct"));
		user.setCust_name(rs.getString("cust_name"));
		user.setCust_id(rs.getInt("cust_id"));
		user.setCust_contact_nbr(rs.getString("cust_contact_nbr"));
		user.setCust_address(rs.getString("cust_address"));
		user.setChecked(1);
		}
		userjson=JSONObject.fromObject(user);
		return "cust";
	}
	
	public String queryCustList() throws Exception {
		String sql="SELECT cust_id,cust_name,cust_address,cust_contact_nbr,cust_acct,checked "
				+ "FROM shopping_cust WHERE cust_acct="+cust_acct;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()){
		User user= new User();
		user.setCust_acct(rs.getString("cust_acct"));
		user.setCust_name(rs.getString("cust_name"));
		user.setCust_id(rs.getInt("cust_id"));
		user.setCust_contact_nbr(rs.getString("cust_contact_nbr"));
		user.setCust_address(rs.getString("cust_address"));
		user.setChecked(rs.getInt("checked"));
		userlist.add(user);
		}
		userlistjson=JSONArray.fromObject(userlist);
		return "custlist";
	}

	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}

	public JSONObject getUserjson() {
		return userjson;
	}

	public void setUserjson(JSONObject userjson) {
		this.userjson = userjson;
	}

	public JSONArray getUserlistjson() {
		return userlistjson;
	}

	public void setUserlistjson(JSONArray userlistjson) {
		this.userlistjson = userlistjson;
	}
	
}
