package com.manage.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.bean.ProImg;
import com.shopping.bean.Product;

public class ManageProductImg implements ModelDriven<ProImg> {

	private ProImg proimg=new ProImg();
	private int productid;
	private int delimgid;
	private List<ProImg> proimglist=new ArrayList();
	private JSONArray proimgjson=new JSONArray();
	@Override
	public ProImg getModel() {
		// TODO Auto-generated method stub
		return proimg;
	}

	public String selectProImg() throws Exception{
	    ResultSet rs;
		String sql="select product_id,pro_img_id,pro_img_addr,pro_img_desc"
				+ " FROM 商品图集   WHERE product_id ="+productid;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		 rs=st.executeQuery(sql);
		
		while (rs.next()){
			ProImg proimg= new ProImg();
			proimg.setProduct_id(rs.getInt("product_id"));
			proimg.setPro_img_id(rs.getInt("pro_img_id"));
			proimg.setPro_img_addr(rs.getString("pro_img_addr"));
			proimg.setPro_img_desc(rs.getString("pro_img_desc"));
			proimglist.add(proimg);
		}
		proimgjson=JSONArray.fromObject(proimglist);
		
		return "success";
	}
	public String insertProImg() throws Exception{
		 String sql="INSERT INTO 商品图集(product_id,pro_img_addr,pro_img_desc) "
	        		+ "VALUES ("+proimg.getProduct_id()+",\'"+proimg.getPro_img_addr()+"\',\'"+proimg.getPro_img_desc()+"\')";
		 Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
			
		return "success";
	}
	public String delProImg() throws Exception{
		String sql="DELETE FROM 商品图集  WHERE pro_img_id="+delimgid;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "success";
	}

	public JSONArray getProimgjson() {
		return proimgjson;
	}
	
	public void setDelimgid(int delimgid) {
		this.delimgid = delimgid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}
	
}
