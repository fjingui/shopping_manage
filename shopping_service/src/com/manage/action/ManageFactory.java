package com.manage.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.bean.Factory;
import com.shopping.bean.User;

public class ManageFactory  {  //implements ModelDriven<Factory>
	
//	private Factory fac=new Factory();
	private int factory_id;
	private String cust_acct;
	private String factory_name;
	private String factory_addr;
	private Long fac_contact_nbr;
	private String factory_log;
	private String comment;
	private Factory facobj=new Factory();
	private List<Factory> faclist = new ArrayList<Factory>();
	private JSONObject facjson=new JSONObject();
	private JSONArray faclistjson = new JSONArray();
	private InputStream inputstream;
	
//	@Override
//	public Factory getModel() {
//		// TODO Auto-generated method stub
//		return fac;
//	}

	public String selectFactory() throws Exception{
	    ResultSet rs=null;
		String sql11="SELECT distinct factory_id,saler_cust_acct,factory_name,factory_addr,fac_contact_nbr,"
				+ "factory_log,comment FROM shopping_salers  "
				+ "WHERE saler_cust_acct = "+cust_acct;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		if(cust_acct!=null){
		 rs=st.executeQuery(sql11);
		}
		while (rs.next()){
			facobj.setFactory_id(rs.getInt("factory_id"));
			facobj.setSaler_cust_acct(rs.getString("saler_cust_acct"));
			facobj.setFactory_name(rs.getString("factory_name"));
			facobj.setFactory_addr(rs.getString("factory_addr"));
			facobj.setFac_contact_nbr(rs.getString("fac_contact_nbr"));
			facobj.setFactory_log(rs.getString("factory_log"));
			facobj.setComment(rs.getString("comment"));
		}
		facjson=JSONObject.fromObject(facobj);
		return "success";
	}
	public String selectAllFactory() throws Exception{
	    ResultSet rs;
		String sql22="SELECT distinct factory_id,saler_cust_acct,factory_name,factory_addr,fac_contact_nbr,"
				+ "factory_log,comment FROM shopping_salers  ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql22);
		while (rs.next()){
		Factory fac= new Factory();
		fac.setFactory_id(rs.getInt("factory_id"));
		fac.setSaler_cust_acct(rs.getString("saler_cust_acct"));
		fac.setFactory_name(rs.getString("factory_name"));
		fac.setFactory_addr(rs.getString("factory_addr"));
		fac.setFac_contact_nbr(rs.getString("fac_contact_nbr"));
		fac.setFactory_log(rs.getString("factory_log"));
		fac.setComment(rs.getString("comment"));
		faclist.add(fac);
		}
		faclistjson=JSONArray.fromObject(faclist);
		return "success";
	}
	public String insertFactory() throws Exception{
		 String sql="INSERT INTO shopping_salers(factory_name,factory_addr,fac_contact_nbr,factory_log,comment,saler_cust_acct) "
	        		+ "VALUES ("+"\'"+factory_name+"\'"+","+"\'"+factory_addr+"\'"+","
				 +fac_contact_nbr+","+"\'"+factory_log+"\'"+","+"\'"+comment+"\'"+","+cust_acct+")";
		 Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
		return "success";
	}
	public String updateFactory() throws Exception{

		String sql="UPDATE shopping_salers  SET factory_name=\'"+factory_name+"\',"+"factory_addr=\'"+factory_addr+"\',"
				+ "fac_contact_nbr="+fac_contact_nbr+","+"COMMENT=\'"+comment+"\',"+"factory_log=\'"+factory_log
						+ "\'  WHERE factory_id="+factory_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "success";
	}
	public String delFactory() throws Exception{

		String sql="delete from shopping_salers    WHERE factory_id="+factory_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		inputstream=new ByteArrayInputStream("³É¹¦"  
                .getBytes("UTF-8"));
		return "success";
	}
	
	public InputStream getInputstream() {
		return inputstream;
	}
	public JSONObject getFacjson() {
		return facjson;
	}

	public JSONArray getFaclistjson() {
		return faclistjson;
	}

	public void setFactory_id(int factory_id) {
		this.factory_id = factory_id;
	}
	public void setfactory_name(String factory_name) {
		this.factory_name = factory_name;
	}

	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}

	public void setFactory_addr(String factory_addr) {
		this.factory_addr = factory_addr;
	}

	public void setFac_contact_nbr(Long fac_contact_nbr) {
		this.fac_contact_nbr = fac_contact_nbr;
	}

	public void setFactory_log(String factory_log) {
		this.factory_log = factory_log;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
