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
	//ͨ��sql������������ģ��
	//���ڳ�ʼ������ģ��
	public void init(String sql){
		if(sql.equals("")){
			sql="select *from s";
		}
		columnNames=new Vector();
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("��ͥ��ַ ");
		columnNames.add("��ϵ��ʽ");
		columnNames.add("ϵ��");
		columnNames.add("������ò");
        
		rowData=new Vector();
		try {
			//1.��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.�õ����� 127.0.0.1:1433
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
