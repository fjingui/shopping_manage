package com.shopping.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.LogoImgs;

public class HomeLogoImagine {

	private List<LogoImgs> imglist= new ArrayList();
	private JSONArray imgsjson= new JSONArray();
	
	public String queryImgs() throws Exception{
		String sql="SELECT * FROM  shopping_logoimgs  WHERE flag=1 ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while (rs.next()){
			LogoImgs logoimg= new LogoImgs();
			logoimg.setImg_id(rs.getInt(1));
			logoimg.setImg_addr(rs.getString(2));
			logoimg.setImg_desc(rs.getString(3));
			imglist.add(logoimg);
		}
		imgsjson=JSONArray.fromObject(imglist);
		return "imgs";
	}

	public JSONArray getImgsjson() {
		return imgsjson;
	}
	
}
