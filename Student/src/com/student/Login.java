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
		//�����˺�
		jp1=new JPanel();
		lb1=new JLabel("�� ��");
		lb1.setFont(new Font("����", Font.BOLD, 15));
		lb1.setForeground(Color.white);
		jtf=new JTextField(15);
		jp1.add(lb1);
		jp1.add(jtf);
		//����
		jp2=new JPanel();
		lb2=new JLabel("�� ��");
		lb2.setFont(new Font("����",Font.BOLD,15));
		lb2.setForeground(Color.white);
		jpw=new JPasswordField(15);
		jp2.add(lb2);
		jp2.add(jpw);
		//ע�ᡢ��¼
		jp3=new JPanel();
		jb1=new JButton("ע��");
		jb1.addActionListener(this);
		jb2=new JButton("��¼");
		jb2.addActionListener(this);
		jp3.add(jb1);
		jp3.add(jb2);
		
		jp1.setOpaque(false);
		jp2.setOpaque(false);
		jp3.setOpaque(false);
	    //������	
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
		
		
		this.setTitle("ѧ����������ϵͳ");
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
			String name=JOptionPane.showInputDialog(this, "�����������˻���", "���������˻�...");
			String psd=JOptionPane.showInputDialog(this, "����������", "������������...");
			
			if(name==null||psd==null ||name.equals("")||psd.equals("")) {
				System.out.println("yes");
				System.out.println(name);
				System.out.println(psd);
				JOptionPane.showMessageDialog(this, "ע��ʧ��");
			}else {
				Verify temp=new Verify();
				if(temp.register(name, psd)) {
					JOptionPane.showMessageDialog(this, "ע��ɹ��������µ�¼��");
				}else {
					JOptionPane.showMessageDialog(this, "ע��ʧ�ܣ�");
				}
			}
		}
		if(arg0.getSource()==jb2) {
			String name=jtf.getText();
			String psd=String.valueOf(jpw.getPassword());
			if(name==null||psd==null ||name.equals("")||psd.equals("")) {;
				JOptionPane.showMessageDialog(this, "��������ȷ���˺�����");
			}else {
				Enter enter=new Enter();
				if(enter.check(name, psd)) {
					Face face1=new Face();
					this.dispose();
				}else {
					JOptionPane.showMessageDialog(this, "��¼ʧ�ܣ�");
				}
			}
		}
	}
}
