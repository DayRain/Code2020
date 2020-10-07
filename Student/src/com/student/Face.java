package com.student;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;
import java.util.*;
public class Face extends JFrame implements ActionListener{

	private JPanel jp1=null;
	private JPanel jp2=null;
	private JLabel lb1=null;
	private JTextField jtf=null;
	private JButton jb=null;
	//定义表
	private JTable jt;
	private JScrollPane jsp;
	Vector rowData;
	Vector columnNames;
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	DataModel dm=null;
	//增删改
	private JButton jb_add=null;
	private JButton jb_modify=null;
	private JButton jb_del=null;
	private JButton jb_detail=null;
	
	public Face(){
		jp1=new JPanel();
		lb1=new JLabel("请输入学生姓名");
		jtf=new JTextField(15);
		jb=new JButton("查询");
		jb.setActionCommand("search");
		jb.addActionListener(this);
		jp1.add(lb1);
		jp1.add(jtf);
		jp1.add(jb);
		jp1.setOpaque(false);
		this.add(jp1,"North");
		
		//添加table

	    dm=new DataModel();	
		jt=new JTable(dm);
		jsp=new JScrollPane(jt);
		jsp.setOpaque(false);
		this.add(jsp);

		jp2=new JPanel();
		jb_add=new JButton("添加");
		jb_add.addActionListener(this);
		jb_add.setActionCommand("add");
		
		jb_modify=new JButton("修改");
		jb_modify.addActionListener(this);
		jb_modify.setActionCommand("update");
		
		jb_del=new JButton("删除");
		jb_del.addActionListener(this);
		jb_del.setActionCommand("del");
		
		jb_detail=new JButton("更多信息");
		jb_detail.addActionListener(this);
		jb_detail.setActionCommand("detail");
		
		
		jp2.add(jb_add);
		jp2.add(jb_modify);
		jp2.add(jb_del);
		jp2.add(jb_detail);
		jp2.setOpaque(false);
		this.add(jp2,"South");
		
		ImageIcon bg=new ImageIcon("image/bg.jpg");
		JLabel label=new JLabel(bg);
		label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);
		
		
		this.setTitle("学生档案管理系统");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("search")){
			System.out.println("查询");			
			String name=this.jtf.getText().trim();

			if(name.equals("")){
				String sql="select *from s";
				dm=new DataModel(sql);
				jt.setModel(dm);
			}else {
			    String sql="select *from s where sname like '"+'%'+name+'%'+"'";
			    //构建新的数据模型类，并更新
			    dm=new DataModel(sql);
			    jt.setModel(dm);
			}
		}
		//当用户点击添加的时候
		if(arg0.getActionCommand().equals("add")){
			AddData ad=new AddData(this,"添加学生",true);
			dm=new DataModel();
			jt.setModel(dm);
		}
		//当用户点击删除
		if(arg0.getActionCommand().equals("del")){
			//如果没有选择，就返回-1
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1) {
				JOptionPane.showMessageDialog(this, "请选择一行");
				return;
			}
			//得到学生学号
			String sId=(String)dm.getValueAt(rowNum, 0);
			//连接数据库,完成删除
			DeleData dd=new DeleData(sId);
			dm=new DataModel();
			jt.setModel(dm);
		}
		if(arg0.getActionCommand().equals("update")){
			//修改
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "选择所要修改的行");
				return ;
			}
			new UpdateData(this,"修改学生信息",true,dm,rowNum);
			dm=new DataModel();
			jt.setModel(dm);
		}
		if(arg0.getActionCommand().equals("detail")) {
			int rowNum=this.jt.getSelectedRow();
			if(rowNum==-1){
				JOptionPane.showMessageDialog(this, "选择所要修改的行");
				return ;
			}
			String sno=(String)dm.getValueAt(rowNum, 0);
			System.out.println(sno);
			Detail de=new Detail(sno);
		}
	}
}
