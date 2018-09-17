package com.manage.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.conn.MySqlConn;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.shopping.bean.ProImg;
import com.shopping.bean.Product;

public class ManageProductImg {

	private File[] file;
	private List<String> fileContentType;
	private List<String> fileFileName;
	
//	private static final String saveimgdir = "http://114.115.138.24:8080/shopping_service/productimages/";
	private String cust_acct;
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
		inputstream=new ByteArrayInputStream("成功"  
                .getBytes("UTF-8"));
		
		return "success";
	}
	public String saveUpImgs() throws IOException{
		String target=ServletActionContext.getServletContext().getRealPath("/productimages");
		if(product_id>0){
		Date dt =	new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(dt);
	    File savedir = new File(target+"/"+str);
		if(!savedir.exists()) {savedir.mkdir();}
		for(int i=0;i<file.length;i++){
			FileInputStream proimgis = new FileInputStream(file[i]);
			FileOutputStream proimgos = new FileOutputStream(savedir.getAbsolutePath() +"/"+cust_acct+"_"+i+".jpg");
			if(file[i].exists()){
				byte[] readimg = new byte[1024];
				int bytenum =0;
				int readlen;
				while((readlen=proimgis.read(readimg))!=-1){
					bytenum +=readlen;
					proimgos.write(readimg, 0, readlen);
				}
			}
		 }
	  }
		inputstream=new ByteArrayInputStream("成功"  
                .getBytes("UTF-8"));
		return "success";
	}
	

	public void setFile(File[] file) {
		this.file = file;
	}
	public void setFileContentType(List<String> fileContentType) {
		this.fileContentType = fileContentType;
	}
	public void setFileFileName(List<String> fileFileName) {
		this.fileFileName = fileFileName;
	}
	public void setCust_acct(String cust_acct) {
		this.cust_acct = cust_acct;
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
