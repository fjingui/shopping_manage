package com.shopping.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.shopping.bean.WithDrawAcct;

public class WithDraw {
	private String cust_acct;
	private File image;
	private String imagepath;
	private String imageContentType;
	private String imageFileName;
	private String tx_account_name;
	private String tx_account;
	private String account_type;
//	private InputStream inputstream;
	private WithDrawAcct wda;
	private JSONObject withdrawobj = new JSONObject();
	
	public String saveAcctImage() throws IOException{
		String target=ServletActionContext.getServletContext().getRealPath("/withdrawimages");
		Date dt =	new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(dt);
	    File savedir = new File(target+"/"+str);
		if(!savedir.exists()) {savedir.mkdir();}
		imagepath = savedir.getAbsolutePath() +"\\"+cust_acct+".png";
		FileInputStream proimgis = new FileInputStream(image);
		FileOutputStream proimgos = new FileOutputStream(imagepath);
		if(image.exists()){
			byte[] readimg = new byte[1024];
			int bytenum =0;
			int readlen;
			while((readlen=proimgis.read(readimg))!=-1){
				bytenum +=readlen;
				proimgos.write(readimg, 0, readlen);
			}
		}
		
		return "success";
	}
	
	public String getWithDrawAcct() throws Exception{
		ResultSet rs;
		String sql="select tx_account_name,tx_account,account_image,account_type"
				+ " FROM shopping_withdraw_account  WHERE cust_acct ="+cust_acct;
	
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs=st.executeQuery(sql);
		while(rs.next()){
		    wda = new WithDrawAcct();
			wda.setTx_account_name(rs.getString("tx_account_name"));
			wda.setTx_account(rs.getString("tx_account"));
			wda.setAccount_image(rs.getString("account_image"));
			wda.setAccount_type(rs.getString("account_type"));
			
		}
		withdrawobj = JSONObject.fromObject(wda);
		return "success";
		
	}
	
	public String insertWithDrawAcct() throws Exception{
		ResultSet rs_select;
		String sql="select tx_account "
				+ " FROM shopping_withdraw_account  WHERE cust_acct ="+cust_acct;
		String sql_u="UPDATE shopping_withdraw_account  SET tx_account_name=\'"+tx_account_name+"\',"+"tx_account=\'"+tx_account+"\',"
				+ "account_image="+imagepath+","+"account_type=\'"+account_type+"\'"+" WHERE cust_acct =" +cust_acct;
		String sql_i = "INSERT INTO shopping_withdraw_account(tx_account_name,tx_account,account_image,account_type,cust_acct) "
        		+ "VALUES (\'"+tx_account_name+"\',\'"+tx_account+"\',\'"+imagepath+"\',\'"+account_type+"\',\'"+cust_acct+"\')";
		Connection conn= MySqlConn.getConnection();
		Statement st = (Statement) conn.createStatement();
		rs_select = st.executeQuery(sql);
		boolean b_ts =rs_select.next();
		if(b_ts){
			st.executeUpdate(sql_u);
		}else{
			st.executeUpdate(sql_i);
		}
		MySqlConn.realseConn(conn, st);
//		inputstream=new ByteArrayInputStream("上传成功！"  
//                .getBytes("UTF-8"));
		return "success";
	}
	
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
	}

//	public InputStream getInputstream() {
//		return inputstream;
//	}

	public void setImage(File image) {
		this.image = image;
	}

	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public void setTx_account_name(String tx_account_name) {
		this.tx_account_name = tx_account_name;
	}


	public void setTx_account(String tx_account) {
		this.tx_account = tx_account;
	}


	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public JSONObject getWithdrawobj() {
		return withdrawobj;
	}

	
}
