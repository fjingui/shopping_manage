package com.mysql.conn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException{
		final String saveidir = "E:/360Downloads/";
		File fuimgs = new File("C:\\Users\\Administrator\\Pictures\\fruit.jpg");
		File savedir = new File(saveidir+"/"+"testfile");
		savedir.mkdir();
		if(fuimgs.exists()){
			FileInputStream fis = new FileInputStream(fuimgs);
			FileOutputStream fos = new FileOutputStream(savedir.getAbsoluteFile()+ "/copyfruit.jpg");
			byte[] readimg = new byte[1024];
			int readlen;
			int bytenum=0;
			while((readlen=fis.read(readimg))!=-1){
				bytenum +=readlen;
				System.out.println("文件大小:"+bytenum);
				fos.write(readimg, 0, readlen);
			}
		}
	}
}
