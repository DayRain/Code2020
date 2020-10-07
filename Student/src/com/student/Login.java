package com.student;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Login extends JFrame implements ActionListener{

	private JPanel jp1=null;
	private JPanel jp2=null;
	private JPanel jp3=null;
	private JLabel lb1=null;
	private JLabel lb2=null;
	private JTextField jtf=null;
	private JPasswordField jpw=null;
	private JButton jb1=null;
	private JButton jb2=null;
	
	
	public Login() {
		//处理账号
		jp1=new JPanel();
		lb1=new JLabel("账 号");
		lb1.setFont(new Font("宋体", Font.BOLD, 15));
		lb1.setForeground(Color.white);
		jtf=new JTextField(15);
		jp1.add(lb1);
		jp1.add(jtf);
		//密码
		jp2=new JPanel();
		lb2=new JLabel("密 码");
		lb2.setFont(new Font("宋体",Font.BOLD,15));
		lb2.setForeground(Color.white);
		jpw=new JPasswordField(15);
		jp2.add(lb2);
		jp2.add(jpw);
		//注册、登录
		jp3=new JPanel();
		jb1=new JButton("注册");
		jb1.addActionListener(this);
		jb2=new JButton("登录");
		jb2.addActionListener(this);
		jp3.add(jb1);
		jp3.add(jb2);
		
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
	    //添加组件	
		this.setLayout(new GridLayout(3,1));
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		
		ImageIcon bg=new ImageIcon("image/login.jpg");
		JLabel label=new JLabel(bg);
		label.setBounds(0, 0, bg.getIconWidth(),bg.getIconHeight());
		this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);
		
		
		this.setTitle("学生档案管理系统");
		this.setLocationRelativeTo(null);
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void showLogin() {
		this.setVisible(true);
	}
	public void closeLogin(){
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1){
			String name=JOptionPane.showInputDialog(this, "请输入输入账户名", "在这输入账户...");
			String psd=JOptionPane.showInputDialog(this, "请输入密码", "在这输入密码...");
			
			if(name==null||psd==null ||name.equals("")||psd.equals("")) {
				System.out.println("yes");
				System.out.println(name);
				System.out.println(psd);
				JOptionPane.showMessageDialog(this, "注册失败");
			}else {
				Verify temp=new Verify();
				if(temp.register(name, psd)) {
					JOptionPane.showMessageDialog(this, "注册成功！请重新登录！");
				}else {
					JOptionPane.showMessageDialog(this, "注册失败！");
				}
			}
		}
		if(arg0.getSource()==jb2) {
			String name=jtf.getText();
			String psd=String.valueOf(jpw.getPassword());
			if(name==null||psd==null ||name.equals("")||psd.equals("")) {;
				JOptionPane.showMessageDialog(this, "请输入正确的账号名！");
			}else {
				Enter enter=new Enter();
				if(enter.check(name, psd)) {
					Face face1=new Face();
					this.dispose();
				}else {
					JOptionPane.showMessageDialog(this, "登录失败！");
				}
			}
		}
	}
}
