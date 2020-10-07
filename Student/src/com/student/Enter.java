package com.student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Enter {

	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	public Enter(){
		
	}
	public boolean check(String name,String psd) {
		try{
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databseName=student", "sa", "123456");
			ps=ct.prepareStatement("use student select *from users"); 
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals(name)&&rs.getString(2).equals(psd)) {
				    System.out.println("验证成功");
			        return true;
				}
			}
			
			return false;
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			System.out.println("...");
		}
		return true;
	}
}
