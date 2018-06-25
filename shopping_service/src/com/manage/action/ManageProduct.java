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
import com.shopping.bean.Product;

public class ManageProduct { //implements ModelDriven<Product>

	//private Product pro=new Product();  //一定要初始化
	private int product_id;
	private String product_name;
	private Float product_price;
	private String price_unit;
	private String product_desc ;
	private String sale_state;
	private int factory_id;
	private Product proobj = new Product();
	private JSONObject projson = new JSONObject();
	private List<Product> products =new ArrayList();
	private JSONArray prosjson=new JSONArray();
	private InputStream inputstream;
	
//	@Override
//	public Product getModel() {
//		// TODO Auto-generated method stub
//		return pro;
//	}
	public String selectProduct() throws Exception{
	    ResultSet rs;
		String sql="select product_name,product_price,price_unit,sale_state,product_desc,factory_id,"
				+ "product_id FROM shopping_sales  "
				+ "WHERE product_name LIKE  "+"\'%"+product_name+"%\'"+" and factory_id ="+factory_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		 rs=st.executeQuery(sql);
		while (rs.next()){
		proobj.setFactory_id(rs.getInt("factory_id"));
		proobj.setProduct_id(rs.getInt("product_id"));
		proobj.setProduct_name(rs.getString("product_name"));
		proobj.setProduct_price(rs.getFloat("product_price"));
		proobj.setPrice_unit(rs.getString("price_unit"));
		proobj.setSale_state(rs.getString("sale_state"));
		proobj.setProduct_desc(rs.getString("product_desc"));
		}
		projson=JSONObject.fromObject(proobj);
		return "success";
	}
	public String selectAllProduct() throws Exception{
	    ResultSet rs;
		String sql="select product_name,product_price,price_unit,sale_state,product_desc,factory_id,"
				+ "product_id FROM shopping_sales  "
				+ "WHERE factory_id ="+factory_id;
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
		products.add(product);
		}
		prosjson=JSONArray.fromObject(products);
		return "success";
	}
	public String insertProduct() throws Exception{
		 String sql="INSERT INTO shopping_sales(product_name,product_price,price_unit,sale_state,product_desc,factory_id) "
	        		+ "VALUES (\'"+product_name+"\',"+product_price+",\'"
				 +price_unit+"\',\'"+sale_state+"\',\'"+product_desc+"\',"+factory_id+")";
			Connection conn= MySqlConn.getConnection();
			Statement st = (Statement) conn.createStatement();
			System.out.println(sql);
			st.executeUpdate(sql);
			MySqlConn.realseConn(conn, st);
			
		return "success";
	}
	public String updateProduct() throws Exception{
		String sql="UPDATE shopping_sales   SET product_name=\'"+product_name+"\',"+"product_price="+product_price+","
				+ "price_unit=\'"+price_unit+"\',"+"product_desc=\'"+product_desc
						+ "\' WHERE product_id="+product_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		
		return "success";
	}
	public String delProduct() throws Exception{

		String sql="delete from shopping_sales    WHERE product_id="+product_id;
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		st.executeUpdate(sql);
		MySqlConn.realseConn(conn, st);
		inputstream=new ByteArrayInputStream("成功"  
                .getBytes("UTF-8"));
		return "success";
	}
	
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public void setProduct_price(Float product_price) {
		this.product_price = product_price;
	}

	public void setPrice_unit(String price_unit) {
		this.price_unit = price_unit;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public void setSale_state(String sale_state) {
		this.sale_state = sale_state;
	}

	public void setFactory_id(int factory_id) {
		this.factory_id = factory_id;
	}

	public JSONObject getProjson() {
		return projson;
	}

	public JSONArray getProsjson() {
		return prosjson;
	}
	public InputStream getInputstream() {
		return inputstream;
	}
}
