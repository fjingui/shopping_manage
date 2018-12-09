package com.manage.action;

import java.sql.Connection;
import java.sql.ResultSet;

import net.sf.json.JSONObject;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.ApkVersion;

public class ApkVersionAction {

	private ApkVersion apkver =new ApkVersion();
	private JSONObject apkverjsn=new JSONObject();
	
	public String getApkVersion() throws Exception{
		
		ResultSet rs=null;
		String sql11="SELECT version_code,version_name,version_desc,publish_date,min_version_name,apk_path"
				+ " FROM shopping_apk_version ORDER BY publish_date DESC LIMIT 1  ";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql11);
		while (rs.next()){
			apkver.setApk_path(rs.getString("apk_path"));
			apkver.setMin_version_name(rs.getString("min_version_name"));
			apkver.setPublish_date(rs.getString("publish_date"));
			apkver.setVersion_code(rs.getInt("version_code"));;
			apkver.setVersion_desc(rs.getString("version_desc"));
			apkver.setVersion_name(rs.getString("version_name"));
		}
		apkverjsn=JSONObject.fromObject(apkver);
		
		return "success";
	}

	public JSONObject getApkverjsn() {
		return apkverjsn;
	}
}
