package com.mysql.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConn {

	 static Connection conn=null;

	public static Connection getConnection() throws Exception{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		   conn = DriverManager.getConnection("jdbc:mysql://114.115.138.24:3306/shopping?useSSL=true&serverTimezone=GMT","root","FJGfjg662004");
		return conn;
	}
	public static void realseConn(Connection con,Statement st) throws SQLException {
		if(con !=null){
		con.close();
		st.close();
		}
	}
}
