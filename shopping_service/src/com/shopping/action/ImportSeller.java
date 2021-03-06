package com.shopping.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.ProImg;
import com.shopping.bean.Seller;

public class ImportSeller {
	private List<Seller> importseller=new ArrayList<Seller>();
	private JSONArray importjson=new JSONArray();
	
	public String queryData() throws Exception {
        String sql;
        Seller sellbean=null;
        ResultSet rs;
		Connection conn=MySqlConn.getConnection();
		sql="SELECT a.*,b.product_id, b.product_name,b.product_price,b.price_unit,b.product_unit,b.product_desc,c.pro_img_addr,c.pro_img_desc "
				+ "FROM shopping_salers a  JOIN shopping_sales  b ON (a.factory_id=b.factory_id) "
				+ " JOIN shopping_saleimgs  c ON (b.product_id=c.product_id) "
				+ " WHERE b.sale_state=\'����\'  AND b.if_important=1 ";
		Statement state = (Statement) conn.createStatement();
		rs=state.executeQuery(sql);
		while(rs.next()) {
			
			if(sellbean!=null && sellbean.getFactory_id() == rs.getInt("factory_id")) {
				sellbean.getPro_imgs().add(new ProImg(rs.getString("pro_img_addr"),rs.getString("pro_img_desc")));
				if (rs.isLast()){
					importseller.add(sellbean);
					continue;
				}else {
					continue;
				}
			}
			if(sellbean !=null ){
				importseller.add(sellbean);
				sellbean=null;
			}
			if(sellbean == null) {
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
				sellbean.setPrice_unit(rs.getString("price_unit"));
				sellbean.setProduct_desc(rs.getString("product_desc"));
				sellbean.setProduct_unit(rs.getString("product_unit"));
				sellbean.getPro_imgs().add(new ProImg(rs.getString("pro_img_addr"),rs.getString("pro_img_desc")));
				if (rs.isLast()){
					importseller.add(sellbean);
				}
				}
			}
		MySqlConn.realseConn(conn, state);
		importjson = JSONArray.fromObject(importseller);	
		return "success";
		
	}

	public JSONArray getImportjson() {
		return importjson;
	}

}
