package com.manage.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.bean.Factory;
import com.shopping.bean.User;

public class ManageFactory implements ModelDriven<Factory> {
	
	private Factory fac;
	private String facname;
	private List<Factory> faclist=new ArrayList<Factory>();
	private JSONArray faclistjson=new JSONArray();
	
	@Override
	public Factory getModel() {
		// TODO Auto-generated method stub
		return fac;
	}

	public String selectFactory() throws Exception{
	    ResultSet rs;
		String sql1="SELECT factory_id,factory_acct,factory_name,factory_addr,fac_contact_nbr,join_date,"
				+ "factory_log,COMMENT FROM �̼�  "
				+ "WHERE factory_name LIKE  "+"\'%"+facname+"%\'";
		String sql2="SELECT factory_id,factory_acct,factory_name,factory_addr,fac_contact_nbr,join_date,"
				+ "factory_log,COMMENT FROM �̼�  ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		if (facname!=null){
		 rs=st.executeQuery(sql1);
		}else {
		 rs=st.executeQuery(sql2);
		}
		while (rs.next()){
		Factory fac= new Factory();
		fac.setFactory_id(rs.getInt("factory_id"));
		fac.setFactory_acct(rs.getInt("factory_acct"));
		fac.setFactory_name(rs.getString("factory_name"));
		fac.setFactory_addr(rs.getString("factory_addr"));
		fac.setFac_contact_nbr(rs.getLong("fac_contact_nbr"));
		fac.setJoin_date(rs.getDate("join_date"));
		fac.setFactory_log(rs.getString("factory_log"));
		fac.setComment(rs.getString("COMMENT"));
		faclist.add(fac);
		}
		faclistjson=JSONArray.fromObject(faclist);
		
		return "select";
	}
	public String insertFactory() throws Exception{
		 String sql="INSERT INTO �̼�(factory_name,factory_addr,fac_contact_nbr,factory_log,COMMENT,factory_acct) "
	        		+ "VALUES ("+fac.getFactory_name()+","+fac.getFactory_addr()+","
				 +fac.getFac_contact_nbr()+","+fac.getFactory_log()+","+fac.getComment()+","+fac.getFactory_acct()+")";
			Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
			
		return "success";
	}
	public String updateFactory() throws Exception{
		String sql="UPDATE �̼� SET factory_name="+fac.getFactory_name()+","+"factory_addr="+fac.getFactory_addr()+","
				+ "fac_contact_nbr="+fac.getFac_contact_nbr()+","+"COMMENT="+fac.getComment()+","+"factory_log="+fac.getFactory_log()
						+ " WHERE factory_id="+fac.getFactory_id();
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "success";
	}

	public JSONArray getFaclistjson() {
		return faclistjson;
	}

	public void setFaclistjson(JSONArray faclistjson) {
		this.faclistjson = faclistjson;
	}

	public void setFacname(String facname) {
		this.facname = facname;
	}
	
}