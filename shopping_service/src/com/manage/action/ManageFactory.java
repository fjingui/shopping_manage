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
	
	private Factory fac=new Factory();
	private String facname;
	private String facacct;
	private List<Factory> faclist=new ArrayList<Factory>();
	private JSONArray faclistjson=new JSONArray();
	
	@Override
	public Factory getModel() {
		// TODO Auto-generated method stub
		return fac;
	}

	public String selectFactory() throws Exception{
	    ResultSet rs=null;
		String sql11="SELECT distinct factory_id,factory_acct,factory_name,factory_addr,fac_contact_nbr,"
				+ "factory_log,comment FROM 商家  "
				+ "WHERE factory_acct = "+facacct;
		String sql12="SELECT distinct factory_id,factory_acct,factory_name,factory_addr,fac_contact_nbr,"
				+ "factory_log,comment FROM 商家  "
				+ "WHERE factory_name = "+"\""+facname+"\"";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		
		if (facname!=null){
		 rs=st.executeQuery(sql12);
		}else if(facacct!=null){
		 rs=st.executeQuery(sql11);
		}
		
		while (rs.next()){
		Factory fac= new Factory();
		fac.setFactory_id(rs.getInt("factory_id"));
		fac.setFactory_acct(rs.getLong("factory_acct"));
		fac.setFactory_name(rs.getString("factory_name"));
		fac.setFactory_addr(rs.getString("factory_addr"));
		fac.setFac_contact_nbr(rs.getLong("fac_contact_nbr"));
		fac.setFactory_log(rs.getString("factory_log"));
		fac.setComment(rs.getString("comment"));
		faclist.add(fac);
		}
		faclistjson=JSONArray.fromObject(faclist);
		return "success";
	}
	public String selectAllFactory() throws Exception{
	    ResultSet rs;
		String sql21="SELECT distinct factory_id,factory_acct,factory_name,factory_addr,fac_contact_nbr,"
				+ "factory_log,comment FROM 商家  "
				+ "WHERE factory_name like "+"\"%"+facname+"%\"";
		String sql22="SELECT distinct factory_id,factory_acct,factory_name,factory_addr,fac_contact_nbr,"
				+ "factory_log,comment FROM 商家  ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();

		if (facname!=null){
			 rs=st.executeQuery(sql21);
			}else {
			 rs=st.executeQuery(sql22);
			}
		
		while (rs.next()){
		Factory fac= new Factory();
		fac.setFactory_id(rs.getInt("factory_id"));
		fac.setFactory_acct(rs.getLong("factory_acct"));
		fac.setFactory_name(rs.getString("factory_name"));
		fac.setFactory_addr(rs.getString("factory_addr"));
		fac.setFac_contact_nbr(rs.getLong("fac_contact_nbr"));
		fac.setFactory_log(rs.getString("factory_log"));
		fac.setComment(rs.getString("comment"));
		faclist.add(fac);
		}
		faclistjson=JSONArray.fromObject(faclist);
		return "success";
	}
	public String insertFactory() throws Exception{
		 String sql="INSERT INTO 商家(factory_name,factory_addr,fac_contact_nbr,factory_log,comment,factory_acct) "
	        		+ "VALUES ("+"\'"+fac.getFactory_name()+"\'"+","+"\'"+fac.getFactory_addr()+"\'"+","
				 +fac.getFac_contact_nbr()+","+"\'"+fac.getFactory_log()+"\'"+","+"\'"+fac.getComment()+"\'"+","+fac.getFactory_acct()+")";
		 Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
		return "success";
	}
	public String updateFactory() throws Exception{

		String sql="UPDATE 商家  SET factory_name=\'"+fac.getFactory_name()+"\',"+"factory_addr=\'"+fac.getFactory_addr()+"\',"
				+ "fac_contact_nbr="+fac.getFac_contact_nbr()+","+"COMMENT=\'"+fac.getComment()+"\',"+"factory_log=\'"+fac.getFactory_log()
						+ "\'  WHERE factory_id="+fac.getFactory_id();
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

	public void setFacacct(String facacct) {
		this.facacct = facacct;
	}
	
}
