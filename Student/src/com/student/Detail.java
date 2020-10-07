package com.student;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.Vector;
public class Detail extends JFrame implements ActionListener {

	JTextArea jta=null;
	JScrollPane js=null;
	JButton jb=null;
	public Detail(String sno){
		jta=new JTextArea(400,300);
		jta.setTabSize(4);
		jta.setFont(new Font("标楷体",Font.BOLD,16));
		jta.setLineWrap(true);//自动换行
		jta.setWrapStyleWord(true);//断行不断字
		js=new JScrollPane(jta);
		
	
	
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		try {
			//1.加载驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.得到链接 127.0.0.1:1433
			ct=DriverManager.getConnection
					("jdbc:sqlserver://127.0.0.1:1433;databaseName=student","sa","123456");
		
			ps=ct.prepareStatement("select * from s where sno=?");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String ssno=rs.getString(1);
				ssno="学号："+ssno+"\n";
				jta.append(ssno);
				
				String sname=rs.getString(2);
				sname="姓名："+sname+"\n";
				jta.append(sname);
				
				String ssex=rs.getString(3);
				ssex="性别："+ssex+"\n";
				jta.append(ssex);
				
				String age=rs.getString(4);
			    age="电话号码："+age+"\n";
			    jta.append(age);
				
			    String address=rs.getString(5);
			    address="地址："+address+"\n";
			    jta.append(address);
			    
			    String number=rs.getString(6);
			    number="电话号码："+number+"\n";
			    jta.append(number);
			    
			    String dno=rs.getString(7);
			    dno="系号："+dno+"\n";
			    jta.append(dno);
			    
			    String pol=rs.getString(8);
			    pol="政治面貌："+pol+"\n";
			    jta.append(pol);
			}//读完s表
			
			ps=ct.prepareStatement("select cname,score from sc,c where c.cno=sc.cno and sc.sno=?");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String cname=rs.getString(1);
				String score=rs.getString(2);
				String data=cname+"："+score+"\n";
				jta.append(data);
			}//读完sc表
			
			ps=ct.prepareStatement("select TIME,NOTE from estimate where sno=?");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String time=rs.getString(1);
				String note=rs.getString(2);
				String data=time+"："+note+"\n";
				jta.append(data);
			}//读完sc表
			
			ps=ct.prepareStatement("select dname,manger,school from dep where dno=(select dno from s where sno=?)");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String dname=rs.getString(1);
				dname="系名："+dname+"\n";
				jta.append(dname);
				
				String manger=rs.getString(2);
				manger="系主任："+manger+"\n";
				jta.append(manger);
				
				String school=rs.getString(3);
				school="学校："+school+"\n";
				jta.append(school);
			}//读完sc表
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				ct.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		ImageIcon bg=new ImageIcon("image/bg.jpg");
		JLabel label=new JLabel(bg);
		label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);
		js.setOpaque(false);
		
		this.add(js,BorderLayout.CENTER); 
		jb=new JButton("返回");
		jb.addActionListener(this);
		this.add(jb,BorderLayout.SOUTH);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb) {
			this.dispose();
		}
	}

}