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
		jta.setFont(new Font("�꿬��",Font.BOLD,16));
		jta.setLineWrap(true);//�Զ�����
		jta.setWrapStyleWord(true);//���в�����
		js=new JScrollPane(jta);
		
	
	
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		try {
			//1.��������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//2.�õ����� 127.0.0.1:1433
			ct=DriverManager.getConnection
					("jdbc:sqlserver://127.0.0.1:1433;databaseName=student","sa","123456");
		
			ps=ct.prepareStatement("select * from s where sno=?");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String ssno=rs.getString(1);
				ssno="ѧ�ţ�"+ssno+"\n";
				jta.append(ssno);
				
				String sname=rs.getString(2);
				sname="������"+sname+"\n";
				jta.append(sname);
				
				String ssex=rs.getString(3);
				ssex="�Ա�"+ssex+"\n";
				jta.append(ssex);
				
				String age=rs.getString(4);
			    age="�绰���룺"+age+"\n";
			    jta.append(age);
				
			    String address=rs.getString(5);
			    address="��ַ��"+address+"\n";
			    jta.append(address);
			    
			    String number=rs.getString(6);
			    number="�绰���룺"+number+"\n";
			    jta.append(number);
			    
			    String dno=rs.getString(7);
			    dno="ϵ�ţ�"+dno+"\n";
			    jta.append(dno);
			    
			    String pol=rs.getString(8);
			    pol="������ò��"+pol+"\n";
			    jta.append(pol);
			}//����s��
			
			ps=ct.prepareStatement("select cname,score from sc,c where c.cno=sc.cno and sc.sno=?");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String cname=rs.getString(1);
				String score=rs.getString(2);
				String data=cname+"��"+score+"\n";
				jta.append(data);
			}//����sc��
			
			ps=ct.prepareStatement("select TIME,NOTE from estimate where sno=?");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String time=rs.getString(1);
				String note=rs.getString(2);
				String data=time+"��"+note+"\n";
				jta.append(data);
			}//����sc��
			
			ps=ct.prepareStatement("select dname,manger,school from dep where dno=(select dno from s where sno=?)");
			ps.setString(1, sno);
			rs=ps.executeQuery();
			while(rs.next()) {
				String dname=rs.getString(1);
				dname="ϵ����"+dname+"\n";
				jta.append(dname);
				
				String manger=rs.getString(2);
				manger="ϵ���Σ�"+manger+"\n";
				jta.append(manger);
				
				String school=rs.getString(3);
				school="ѧУ��"+school+"\n";
				jta.append(school);
			}//����sc��
			
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
		jb=new JButton("����");
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