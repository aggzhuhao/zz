/**
 * ATM用户操作主界面功能及其实现
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ATMUserOperation{
	protected JFrame frame = new JFrame("ATM自动取款系统");
	protected JPanel p1 = new JPanel();
 

	protected JLabel s1 = new JLabel("尊敬的:     **亮 ");
	protected JLabel s2 = new JLabel("请注意用卡安全");
	protected JButton btn1 = new JButton("查询用户");
	protected JButton btn2 = new JButton("提取现金");
	protected JButton btn3 = new JButton("返回磁卡");
	protected JButton btn4 = new JButton("修改密码");
	protected JButton btn5 = new JButton("存入现金");
	protected Socket socket;
	protected Account acc;
	private Account acc2;
	public ATMUserOperation(){
		
	}
	/*
	 * 接受登录界面传参的acc账户
	 */
	public ATMUserOperation(final Account acc){
		try {
			socket = new Socket("127.0.0.1",9999);
			System.out.println('2');
			
			
			String ss = acc.getName();
			s1.setText("尊敬的：   " + ss);
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s1.setBounds(280, 160, 800, 60);
		s1.setFont(new Font("宋体", 30, 30));
		s2.setBounds(280, 220, 800, 60);
		s2.setFont(new Font("宋体", 30, 30));
		s2.setForeground(Color.red);
		btn1.setBounds(30, 230, 130, 50);
		//给btn1加入事件监听器，跳转至用户查询界面
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ATMQuery aq = new ATMQuery(acc);
				System.out.println(acc.getMoney());
				frame.dispose();
			}
		});
		btn2.setBounds(30, 300, 130, 50);
		//页面跳转至取钱界面，并将Account 传至取钱界面
		btn2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ATMDrawMoney adw = new ATMDrawMoney(acc);
				frame.dispose();
			}
		});
		btn3.setBounds(30, 370, 130, 50);
		//页面跳转至返回磁卡页面
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ATMThanks athanks = new ATMThanks();
				//frame.disable();
				frame.setVisible(false);
				
			}
		});
		btn4.setBounds(640, 230, 130, 50);
		//页面跳转至修改密码页面，并将account传至该页面
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ATMChangePsw acp = new ATMChangePsw(acc);
				
				frame.dispose();
			}
		});
		btn5.setBounds(640, 300, 130, 50);
		//页面跳转至取钱页面，并将account传入至该页面
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s = "";
				ATMSaveMoney asm = new ATMSaveMoney(acc, s);
				frame.dispose();
			}
		});
		
		
		p1.add(s1);
		p1.add(s2);
		p1.add(btn1);
		p1.add(btn2);
		p1.add(btn3);
		p1.add(btn4);
		p1.add(btn5);
		p1.setLayout(null);
		frame.add(p1);
		frame.setResizable(false);
		frame.setSize(800, 500);
		frame.setVisible(true);
		
		
	}


}
