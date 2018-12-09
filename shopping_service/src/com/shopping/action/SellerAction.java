package com.shopping.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.ProImg;
import com.shopping.bean.Seller;

public class SellerAction {
	
	private List<Seller> sellerlist=new ArrayList<Seller>();
	private JSONArray jarry=new JSONArray();
	private List<Seller> approvelist=new ArrayList<Seller>();
	private JSONArray approveJson=new JSONArray();
	private String proname;
	public String queryData() throws Exception {
        String sql1,sql2;
        Seller sellbean=null;
        ResultSet rs;
		Connection conn=MySqlConn.getConnection();
		sql1="SELECT a.*,b.product_id, b.product_name,b.product_price,b.product_stor,b.price_unit,b.product_desc,b.product_unit, c.pro_img_addr,c.pro_img_desc "
				+ "FROM shopping_salers a JOIN shopping_sales  b ON (a.factory_id=b.factory_id) "
				+ "JOIN shopping_saleimgs  c ON (b.product_id=c.product_id) AND b.sale_state=\'在售\' ";
		sql2="SELECT a.*,b.product_id, b.product_name,b.product_price,b.product_stor,b.price_unit,b.product_desc,b.product_unit,c.pro_img_addr,c.pro_img_desc "
				+ "FROM shopping_salers a JOIN shopping_sales  b ON (a.factory_id=b.factory_id) "
				+ "JOIN shopping_saleimgs  c ON (b.product_id=c.product_id) AND b.sale_state=\'在售\' "
				+ "and b.product_name like '%"+proname+"%'";
		Statement state = (Statement) conn.createStatement();
		if(proname!=null) { 
			rs=state.executeQuery(sql2);
			} else{
			rs=state.executeQuery(sql1);
		}
		while(rs.next()) {
			
			if(sellbean!=null && sellbean.getFactory_id() == rs.getInt("factory_id")) {
				sellbean.getPro_imgs().add(new ProImg(rs.getString("pro_img_addr"),rs.getString("pro_img_desc")));
				if (rs.isLast()){
					sellerlist.add(sellbean);
					continue;
				}else {
					continue;
				}
			}
			if(sellbean!=null) {
				sellerlist.add(sellbean);
				sellbean=null;
			}
			if (sellbean==null){
				sellbean= new Seller();
				sellbean.setFactory_id(rs.getInt("factory_id"));
				sellbean.setFactory_name(rs.getString("factory_name"));
				sellbean.setFactory_addr(rs.getString("factory_addr"));
				sellbean.setFac_contact_nbr(rs.getLong("fac_contact_nbr"));
				sellbean.setJoin_date(rs.getString("join_date"));
				sellbean.setFactory_log(rs.getString("factory_log"));
				sellbean.setComment(rs.getString("comment"));
				sellbean.setProduct_id(rs.getInt("product_id"));
				sellbean.setProduct_name(rs.getString("product_name"));
				sellbean.setProduct_price(rs.getFloat("product_price"));
				sellbean.setProduct_stor(rs.getInt("product_stor"));
				sellbean.setPrice_unit(rs.getString("price_unit"));
				sellbean.setProduct_desc(rs.getString("product_desc"));
				sellbean.setProduct_unit(rs.getString("product_unit"));
				sellbean.setSaler_cust_acct(rs.getString("saler_cust_acct"));
				sellbean.getPro_imgs().add(new ProImg(rs.getString("pro_img_addr"),rs.getString("pro_img_desc")));
				if (rs.isLast()){
					sellerlist.add(sellbean);
				}
				}

			}
		MySqlConn.realseConn(conn, state);
	    jarry = JSONArray.fromObject(sellerlist);	
		return "success";
		
	}

	public String approveGoods() throws Exception {
        String sql1,sql2;
        Seller sellbean=null;
        ResultSet rs;
		Connection conn=MySqlConn.getConnection();
		sql1="SELECT a.*,b.product_id, b.product_name,b.product_price,b.product_stor,b.price_unit,b.product_desc,b.product_unit, c.pro_img_addr,c.pro_img_desc "
				+ "FROM shopping_salers a JOIN shopping_sales  b ON (a.factory_id=b.factory_id) "
				+ "JOIN shopping_saleimgs  c ON (b.product_id=c.product_id) AND b.sale_state=\'待售\' ";
		Statement state = (Statement) conn.createStatement();
		rs=state.executeQuery(sql1);
		while(rs.next()) {
			
			if(sellbean!=null && sellbean.getFactory_id() == rs.getInt("factory_id")) {
				sellbean.getPro_imgs().add(new ProImg(rs.getString("pro_img_addr"),rs.getString("pro_img_desc")));
				if (rs.isLast()){
					approvelist.add(sellbean);
					continue;
				}else {
					continue;
				}
			}
			if(sellbean!=null) {
				approvelist.add(sellbean);
				sellbean=null;
			}
			if (sellbean==null){
				sellbean= new Seller();
				sellbean.setFactory_id(rs.getInt("factory_id"));
				sellbean.setFactory_name(rs.getString("factory_name"));
				sellbean.setFactory_addr(rs.getString("factory_addr"));
				sellbean.setFac_contact_nbr(rs.getLong("fac_contact_nbr"));
				sellbean.setJoin_date(rs.getString("join_date"));
				sellbean.setFactory_log(rs.getString("factory_log"));
				sellbean.setComment(rs.getString("comment"));
				sellbean.setProduct_id(rs.getInt("product_id"));
				sellbean.setProduct_name(rs.getString("product_name"));
				sellbean.setProduct_price(rs.getFloat("product_price"));
				sellbean.setProduct_stor(rs.getInt("product_stor"));
				sellbean.setPrice_unit(rs.getString("price_unit"));
				sellbean.setProduct_desc(rs.getString("product_desc"));
				sellbean.setProduct_unit(rs.getString("product_unit"));
				sellbean.setSaler_cust_acct(rs.getString("saler_cust_acct"));
				sellbean.getPro_imgs().add(new ProImg(rs.getString("pro_img_addr"),rs.getString("pro_img_desc")));
				if (rs.isLast()){
					approvelist.add(sellbean);
				}
				}

			}
		MySqlConn.realseConn(conn, state);
		approveJson = JSONArray.fromObject(approvelist);	
		return "success";
		
	}
	
	public void setProname(String proname) {
		this.proname = proname;
	}

	public JSONArray getJarry() {
		return jarry;
	}

	public JSONArray getApproveJson() {
		return approveJson;
	}
	
}
