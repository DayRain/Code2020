package com.student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;
public class UpdateData extends JDialog implements ActionListener{

	//定义所需swing组件
	private JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	private JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	JPanel jp1,jp2,jp3;
	
	//owner父窗口
	//modal指定是模式窗口还是非模式窗口
	public UpdateData(Frame owner, String title, boolean modal,DataModel dm,int rowNum){
		super(owner,title,modal);
		jl1=new JLabel("学号");
		jl2=new JLabel("姓名");
		jl3=new JLabel("性别");
		jl4=new JLabel("年龄");
		jl5=new JLabel("家庭地址");
		jl6=new JLabel("联系方式");
		jl7=new JLabel("系号");
		jl8=new JLabel("政治面貌");
		
		jtf1=new JTextField();
		jtf1.setText((String)dm.getValueAt(rowNum, 0));
		jtf1.setEditable(false);
		jtf2=new JTextField();
		jtf2.setText((String)dm.getValueAt(rowNum, 1));
		jtf3=new JTextField();
		jtf3.setText((String)dm.getValueAt(rowNum, 2));
		jtf4=new JTextField();
		jtf4.setText((String)dm.getValueAt(rowNum, 3));
		jtf5=new JTextField();
		jtf5.setText((String)dm.getValueAt(rowNum, 4));
		jtf6=new JTextField();
		jtf6.setText((String)dm.getValueAt(rowNum, 5));
		jtf7=new JTextField();
		jtf7.setText((String)dm.getValueAt(rowNum, 6));
		jtf8=new JTextField();
		jtf8.setText((String)dm.getValueAt(rowNum, 7));
		
		jb1=new JButton("确定");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		
		//设置布局
		jp1.setLayout(new GridLayout(8,1));
		jp2.setLayout(new GridLayout(8,1));
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
		
		//展现
		
		this.setSize(400, 600); 
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1){
			PreparedStatement ps=null;
			Connection ct=null;
			ResultSet rs=null;
			try {
				//1.加载驱动
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				//2.得到链接 127.0.0.1:1433
				ct=DriverManager.getConnection
						("jdbc:sqlserver://127.0.0.1:1433;databaseName=student","sa","123456");
			
				String sql="update s set sname=?,sex=?,age=?,saddress=?,"
						+ "spnumber=?,dno=?,political=? where sno=?";
				ps=ct.prepareStatement(sql);
				//给？赋值
				ps.setString(1, jtf2.getText());
				ps.setString(2, jtf3.getText());
				ps.setString(3, jtf4.getText());
				ps.setString(4, jtf5.getText());
				ps.setString(5, jtf6.getText());
				ps.setString(6, jtf7.getText());
				ps.setString(7, jtf8.getText());
				ps.setString(8, jtf1.getText());

				ps.executeUpdate();
				this.dispose();
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
	}
}
