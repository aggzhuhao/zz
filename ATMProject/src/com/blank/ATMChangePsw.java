/**
 * ATM修改密码页面布局
 * @author Administrator
 *
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ATMChangePsw {
	private JLabel sss1 = new JLabel("原始密码");
	private JLabel sss2 = new JLabel("新密码");
	private JLabel sss3 = new JLabel("确认密码");
	private JPasswordField ttt1 = new JPasswordField();
	private JPasswordField ttt2 = new JPasswordField();
	private JPasswordField ttt3 = new JPasswordField();
	private Account acc = new Account();
	private JFrame frame = new JFrame("ATM取款系统");
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private int sign;
	private JButton btnenter = new JButton("  确 认  ");
	private JButton btnback = new JButton("  后  退  ");
	private Socket socket;
	public ATMChangePsw(final Account acc){
		try {
			socket = new Socket("127.0.0.1",9999);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnback.setBounds(10, 360, 140, 70);
		btnback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ATMUserOperation auo = new ATMUserOperation(acc);
				frame.dispose();
			}
		});
		btnenter.setBounds(645, 360, 140, 70);
		/*
		 * 给确认键加入时间监听器
		 */
		btnenter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//如果旧密码框密码和获得传参过来的acc一样则继续
				if(ttt1.getText().equals(acc.getUserpsw())){
					
					//如果新密码和确认新密码框一致
					if(ttt2.getText().equals(ttt3.getText())){
						try {
							//将新密码传入acc中，并将acc发送至服务器
							ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
							acc.setUserpsw(ttt2.getText());
							oos.writeObject(acc);
							ATMLogin al = new ATMLogin();
							frame.dispose();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else{
						//旧密码与原始密码不一致弹窗
						JDialog jd = new JDialog(frame,"警告",true);
						JLabel msg = new JLabel("密码不一致");
						msg.setBounds(55, 50, 150, 100);
						jd.setLayout(new BorderLayout());
						jd.setLayout(null);
						jd.add(msg);
						jd.setBounds(300, 200, 220, 220);
						jd.setVisible(true);
						System.out.println("登录失败————————————————————————-");
					}
				}else{
					//两次输入密码不一致弹窗
					JDialog jd = new JDialog(frame,"警告",true);
					JLabel msg = new JLabel("请输入正确的密码");
					msg.setBounds(55, 50, 150, 150);
					jd.setLayout(new BorderLayout());
					jd.setLayout(null);
					jd.add(msg);
					jd.setBounds(300, 200, 220, 220);
					jd.setVisible(true);
					System.out.println("请输入正确的密码");
				}
			}
		});
		p2.setLayout(new GridLayout(4, 3));
		JButton b1 = new JButton("1");
		p2.setBounds(255, 220, 320, 220);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"1");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"1");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"1");
				}

			}
		});
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"2");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"2");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"2");
				}

			}
		});
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"3");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"3");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"3");
				}

			}
		});
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"4");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"4");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"4");
				}

			}
		});
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"5");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"5");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"5");
				}

			}
		});
		JButton b6 = new JButton("6");
		
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"6");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"6");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"6");
				}

			}
		});
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"7");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"7");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"7");
				}

			}
		});
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"8");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"8");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"8");
				}

			}
		});
		JButton b9 = new JButton("9");
		b9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"9");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"9");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"9");
				}

			}
		});
		JButton b10 = new JButton("0");
		b10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText(temp+"10");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText(temp+"10");
				}else{
					String temp = ttt3.getText();
					ttt3.setText(temp+"10");
				}

			}
		});
		JButton b11 = new JButton("<-");
		b11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

			}
		});
		JButton b12 = new JButton("取消");
		b12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(sign==0){
					String temp = ttt1.getText();
					ttt1.setText("");
				}else if(sign == 1){
					String temp = ttt2.getText();
					ttt2.setText("");
				}else{
					String temp = ttt3.getText();
					ttt3.setText("");
				}

			}
		});
		sss1.setBounds(220, 40, 300, 60);
		sss1.setFont(new Font("宋体", 20, 20));
		sss2.setBounds(220, 90, 220, 60);
		sss2.setFont(new Font("宋体", 20, 20));
		sss3.setBounds(220,140,400,50);
		sss3.setFont(new Font("宋体", 20, 20));	
		ttt1.setBounds(320, 40, 300, 50);
		ttt1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sign = 0;
			}
		});
		ttt2.setBounds(320, 90, 300, 50);
		ttt2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sign = 1;
			}
		});
		ttt3.setBounds(320, 140, 300, 50);
		ttt3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sign = 2;
			}
		});
		p1.setLayout(null);
		p1.add(sss1);
		p1.add(sss2);
		p1.add(sss3);
		p1.add(ttt1);
		p1.add(ttt2);
		p1.add(ttt3);
		p1.add(btnback);
		p1.add(btnenter);
		p2.add(b1);
		p2.add(b2);
		p2.add(b3);
		p2.add(b4);
		p2.add(b5);
		p2.add(b6);
		p2.add(b7);
		p2.add(b8);
		p2.add(b9);
		p2.add(b10);
		p2.add(b11);
		p2.add(b12);
		p1.add(p2);
		frame.add(p1);
		frame.setResizable(false);
		frame.setSize(800, 500);
		frame.setVisible(true);
	}
	
	
}
