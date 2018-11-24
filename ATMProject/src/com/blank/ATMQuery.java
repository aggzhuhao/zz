/**
 * ATM用户余额查询界面
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ATMQuery extends ATMUserOperation {
	
	private JLabel ss1 = new JLabel("您的账户可用余额为:  ");
	private JLabel ss2 = new JLabel("");
	private JLabel ss3= new JLabel("元");
	private Socket socket;
	private Account acc2;
	
	
	
	public ATMQuery(final Account acc) {
	

		ss1.setBounds(210, 200, 800, 68);
		ss1.setFont(new Font("宋体", 30, 30));
		ss2.setBounds(510, 200, 800, 68);
		ss2.setFont(new Font("宋体", 30, 30));
		ss2.setForeground(Color.red);
		//System.out.println(acc.getMoney());
		ss2.setText(acc.getMoney().toString());
		ss3.setBounds(600, 200, 800, 68);
		ss3.setFont(new Font("宋体", 30, 30));
		s2.setFont(new Font("宋体", 0, 0));
		btn1.setBounds(30, 230, 0, 0);
		
		btn4.setBounds(640, 230, 0, 0);
		btn5.setBounds(640, 230, 0, 0);
		JButton btn6 = new JButton();
		btn6.setText("后退");
		btn6.setBounds(640, 300, 130, 50);
		//返回至用户操作界面
		btn6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//ATMUserOperation aso = new ATMUserOperation(acc);
				ATMUserOperation aus = new ATMUserOperation(acc);
				frame.dispose();
			}
		});
		
		p1.add(ss1);
		p1.add(ss2);
		p1.add(ss3);
		p1.setLayout(null);
		p1.add(btn6);
		frame.add(p1);
		frame.setSize(800, 500);
		frame.setVisible(true);
	
	}
	
	


}
