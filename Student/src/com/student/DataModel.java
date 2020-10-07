package com.student;
import java.awt.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class DataModel extends AbstractTableModel {

	Vector rowData,columnNames;
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	//通过sql语句来获得数据模型
	//用于初始化数据模型
	public void init(String sql){
		if(sql.equals("")){
			sql="select *from s";
		}
		columnNames=new Vector();
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("家庭地址 ");
		columnNames.add("联系方式");
		columnNames.add("系号");
		columnNames.add("政治面貌");
        
		rowData=new Vector();
		try {
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.得到链接 127.0.0.1:1433
			ct=DriverManager.getConnection
					("jdbc:sqlserver://127.0.0.1:1433;databaseName=student","sa","123456");
		
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				hang.add(rs.getString(8));
				rowData.add(hang);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(ct!=null)ct.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public DataModel(String sql){
		 this.init(sql);
	}
	public DataModel(){
		this.init("");
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(col);
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}
}
