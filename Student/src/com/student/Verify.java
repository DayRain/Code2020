package com.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
public class Verify {

	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	public Verify(){
		
	}
	public boolean register(String name,String psd){
		try{
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databseName=student", "sa", "123456");
			ps=ct.prepareStatement("use student select *from users");
			rs=ps.executeQuery();
			while(rs.next()){
				//结果集存在，则说明已经有同名账户
				if(rs.getString(1).equals(name)) {
				    System.out.println("已经有了"+rs.getString(1));
			        return false;
				}
			}
			ps=ct.prepareStatement("insert into USERS values(?,?)");
			ps.setString(1, name);
			ps.setString(2, psd);
			ps.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			System.out.println("...");
		}
		return false;
	}
}
