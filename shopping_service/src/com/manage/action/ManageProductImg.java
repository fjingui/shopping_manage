package com.manage.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.bean.Pro_Img;
import com.shopping.bean.Product;

public class ManageProductImg implements ModelDriven<Pro_Img> {

	private Pro_Img proimg;
	private int product_id;
	private List<Pro_Img> proimglist=new ArrayList();
	private JSONArray proimgjson=new JSONArray();
	@Override
	public Pro_Img getModel() {
		// TODO Auto-generated method stub
		return proimg;
	}

	public String selectProImg() throws Exception{
	    ResultSet rs;
		String sql="product_id,pro_img_id,pro_img_addr,pro_img_desc"
				+ " FROM 商品图集   WHERE product_id ="+product_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		 rs=st.executeQuery(sql);
		
		while (rs.next()){
			Pro_Img proimg= new Pro_Img();
			proimg.setProduct_id(rs.getInt("product_id"));
			proimg.setPro_img_id(rs.getInt("pro_img_id"));
			proimg.setPro_Img_Addr(rs.getString("pro_img_addr"));
			proimg.setPro_Img_Desc(rs.getString("pro_img_desc"));
			proimglist.add(proimg);
		}
		proimgjson=JSONArray.fromObject(proimglist);
		
		return "select";
	}
	public String insertProImg() throws Exception{
		 String sql="INSERT INTO 商品图集(product_id,pro_img_addr,pro_img_desc) "
	        		+ "VALUES ("+proimg.getProduct_id()+","+proimg.getPro_Img_Addr()+","+proimg.getPro_Img_Desc()+")";
			Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
			
		return "insert";
	}
	public String delProImg() throws Exception{
		
		String sql="DELETE FROM 商品图集  WHERE pro_img_id="+proimg.getPro_img_id();
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "delete";
	}

	public JSONArray getProimgjson() {
		return proimgjson;
	}

	public void setProimgs(Pro_Img proimg) {
		this.proimg = proimg;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
}
