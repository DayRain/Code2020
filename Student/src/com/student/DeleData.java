package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleData {

	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	public DeleData(String sId){
		try {
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.得到链接 127.0.0.1:1433
			ct=DriverManager.getConnection
					("jdbc:sqlserver://127.0.0.1:1433;databaseName=student","sa","123456");
		
			ps=ct.prepareStatement("delete from s where sno=?");
			ps.setString(1, sId);
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				ct.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
