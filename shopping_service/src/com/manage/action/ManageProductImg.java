package com.manage.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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

public class ManageProductImg {

	private int product_id;
	private int pro_img_id;
	private String pro_img_addr;
	private String pro_img_desc;
	private List<ProImg> proimglist=new ArrayList();
	private JSONArray proimgsjson=new JSONArray();
	private InputStream inputstream;

	public String selectProImgs() throws Exception{
	    ResultSet rs;
		String sql="select product_id,pro_img_id,pro_img_addr,pro_img_desc"
				+ " FROM shopping_saleimgs  WHERE product_id ="+product_id;
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
		proimgsjson=JSONArray.fromObject(proimglist);
		
		return "success";
	}
	public String insertProImg() throws Exception{
		 String sql="INSERT INTO shopping_saleimgs(product_id,pro_img_addr,pro_img_desc) "
	        		+ "VALUES ("+product_id+",\'"+pro_img_addr+"\',\'"+pro_img_desc+"\')";
		 Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
			
		return "success";
	}
	public String delProImg() throws Exception{
		String sql="DELETE FROM shopping_saleimgs  WHERE product_id="+product_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		inputstream=new ByteArrayInputStream("³É¹¦"  
                .getBytes("UTF-8"));
		
		return "success";
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setPro_img_id(int pro_img_id) {
		this.pro_img_id = pro_img_id;
	}

	public void setPro_img_addr(String pro_img_addr) {
		this.pro_img_addr = pro_img_addr;
	}

	public void setPro_img_desc(String pro_img_desc) {
		this.pro_img_desc = pro_img_desc;
	}

	public JSONArray getProimgsjson() {
		return proimgsjson;
	}

	public InputStream getInputstream() {
		return inputstream;
	}

}
