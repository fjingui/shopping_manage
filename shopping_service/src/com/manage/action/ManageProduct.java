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
import com.shopping.bean.Product;

public class ManageProduct implements ModelDriven<Product>{

	private Product pro;
	private String proname;
	private List<Product> allproduct =new ArrayList();
	private JSONArray prolistjson=new JSONArray();
	
	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return pro;
	}

	public String selectProduct() throws Exception{
	    ResultSet rs;
		String sql="product_name,product_price,price_unit,sale_state,product_desc,factory_id"
				+ "product_id FROM 商品  "
				+ "WHERE product_name LIKE  "+"\'%"+proname+"%\'";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		 rs=st.executeQuery(sql);
		
		while (rs.next()){
		Product product= new Product();
		product.setFactory_id(rs.getInt("factory_id"));
		product.setProduct_id(rs.getInt("product_id"));
		product.setProduct_name(rs.getString("product_name"));
		product.setProduct_price(rs.getFloat("product_price"));
		product.setPrice_unit(rs.getString("price_unit"));
		product.setSale_state(rs.getString("sale_state"));
		product.setProduct_desc(rs.getString("product_desc"));
		allproduct.add(product);
		}
		prolistjson=JSONArray.fromObject(allproduct);
		
		return "select";
	}
	public String insertProduct() throws Exception{
		 String sql="INSERT INTO 商品(product_name,product_price,price_unit,sale_state,product_desc,factory_id) "
	        		+ "VALUES ("+pro.getProduct_name()+","+pro.getProduct_price()+","
				 +pro.getPrice_unit()+","+pro.getSale_state()+","+pro.getProduct_desc()+","+pro.getFactory_id()+")";
			Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
			
		return "success";
	}
	public String updateProduct() throws Exception{
		String sql="UPDATE 商品 SET product_name="+pro.getProduct_name()+","+"product_price="+pro.getProduct_price()+","
				+ "price_unit="+pro.getPrice_unit()+","+"product_desc="+pro.getProduct_desc()
						+ " WHERE product_id="+pro.getProduct_id();
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "update";
	}
	
	public void setPro(Product pro) {
		this.pro = pro;
	}

	public void setProname(String proname) {
		this.proname = proname;
	}

	public JSONArray getProlistjson() {
		return prolistjson;
	}

	public void setProlistjson(JSONArray prolistjson) {
		this.prolistjson = prolistjson;
	}
	

	
}
