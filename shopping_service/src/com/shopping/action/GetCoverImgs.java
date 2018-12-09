package com.shopping.action;

import java.sql.Connection;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.CoverImgs;
import com.shopping.bean.WithDrawAcct;

public class GetCoverImgs {

	private CoverImgs cimg;
	private JSONObject cimgobj = new JSONObject();
	
	public String getCurrentCover() throws Exception{
		ResultSet rs;
		String sql="select * from shopping_cover_imgs where if_show = 1";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()){
			cimg = new CoverImgs();
			cimg.setCover_id(rs.getInt("cover_id"));
			cimg.setCover_path(rs.getString("cover_path"));
			cimg.setCrt_date(rs.getString("crt_date"));
			cimg.setIf_show(rs.getInt("if_show"));
			
		}
		cimgobj = JSONObject.fromObject(cimg);
		return "success";
	}

	public JSONObject getCimgobj() {
		return cimgobj;
	}
	
}
