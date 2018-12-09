package com.manage.action;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneOrderid {
	  private static long orderNum = 0l;
	    private static String date ;
	    public static synchronized String getOrderid(){
	        String date=new SimpleDateFormat("yyMMddHHmmss").format(new Date());
	        Long orderno=Long.parseLong(date)*10000;
	        orderNum++;
	        orderno+=orderNum;
	        System.out.println(orderNum);
	        
	        return orderno+"";
	    }
	    public static void main(String[] args){
	    	String orderid=GeneOrderid.getOrderid();
	    }
}
