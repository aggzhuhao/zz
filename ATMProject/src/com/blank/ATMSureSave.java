/**
 * ATM确认存款界面及功能实现
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ATMSureSave {
	private JFrame frame = new JFrame();
	private JPanel p1 = new JPanel();
	private JButton btnenter = new JButton("  确 认  ");
	private JButton btnback = new JButton("  后 退  ");
	private JButton bb1 = new JButton("继续存款");
	private JLabel ss1 = new JLabel("您将向以下账户: ");
	private JLabel ss2 = new JLabel("开户人: ");
	private JLabel ss3 = new JLabel("***亮");
	private JLabel ss4 = new JLabel("账号 :");
	private JLabel ss5 = new JLabel("6321  **** **** ***  867");
	private JLabel ss6 = new JLabel("存入现金: ");
	private JLabel ss7 = new JLabel("0");
	private JLabel ss8 = new JLabel("元");
	private Socket socket;
	private Account acc = new Account();
	//接受传参来的账户acc和金额数目
	public ATMSureSave(final Account acc,String s){
	
		final Integer i1 = Integer.parseInt(s);
		System.out.println("确认存款数目" + i1);
		try {
			socket = new Socket("127.0.0.1",9999);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ss7.setText(i1.toString());
		ss3.setText(acc.getName());
		ss5.setText(acc.getUserNum());
		ss2.setBounds(250, 150, 500, 30);
		ss2.setFont(new Font("宋体", 20, 20));
		ss1.setBounds(320, 120, 500, 30);
		ss1.setFont(new Font("宋体", 20, 20));
		ss3.setBounds(340, 150, 500, 30);
		ss3.setFont(new Font("宋体", 20, 20));
		ss4.setBounds(250, 190, 500, 30);
		ss4.setFont(new Font("宋体", 20, 20));
		ss5.setBounds(330, 190, 500, 30);
		ss5.setFont(new Font("宋体", 20, 20));
		ss6.setBounds(250, 230, 500, 30);
		ss6.setFont(new Font("宋体", 20, 20));
		ss7.setBounds(360, 230, 500, 30);
		ss7.setFont(new Font("宋体", 20, 20));
		ss7.setForeground(Color.red);
		ss8.setBounds(410, 230, 500, 30);
		ss8.setFont(new Font("宋体", 20, 20));
		btnenter.setBounds(645, 360, 140, 70);
		/*
		 * 确认键判断金额是否符合
		 */
		btnenter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = "";
				if(i1 % 50 == 0){
					try {
						//符合则将修改过后的账户余额放入acc发送至服务器
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						acc.setMoney(acc.getMoney() + i1);
						System.out.println(acc.getMoney());
						oos.writeObject(acc);
						System.out.println(acc.getMoney());
						frame.dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(i1);
					ATMSaveMoney sam = new ATMSaveMoney(acc,s);
				}else{
					JDialog jd = new JDialog(frame,"警告",true);
					JLabel msg = new JLabel("请输入正确的金额");
					msg.setBounds(55, 50, 150, 150);
					jd.setLayout(new BorderLayout());
					jd.setLayout(null);
					jd.add(msg);
					jd.setBounds(300, 200, 220, 220);
					jd.setVisible(true);
				}
				
				
			}
		});
		btnback.setBounds(10, 360, 140, 70);
		btnback.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String s = "";
				ATMSaveMoney asm = new ATMSaveMoney(acc,s);
				frame.dispose();
			}
		});
		bb1.setBounds(645, 270, 140, 70);
		bb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String s = "";
				if(i1 % 50 == 0){
					try {
						
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						acc.setMoney(acc.getMoney() + i1);
						System.out.println(acc.getMoney());
						oos.writeObject(acc);
						//oos.writeOb
						System.out.println(acc.getMoney());
						frame.dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(i1);
					ATMSaveMoney sam = new ATMSaveMoney(acc,s);
				}else{
					JDialog jd = new JDialog(frame,"警告",true);
					JLabel msg = new JLabel("请输入正确的金额");
					msg.setBounds(55, 50, 150, 150);
					jd.setLayout(new BorderLayout());
					jd.setLayout(null);
					jd.add(msg);
					jd.setBounds(300, 200, 220, 220);
					jd.setVisible(true);
				}
				
				
			}
		});
		p1.add(btnenter);
		p1.add(btnback);
		p1.add(bb1);
		p1.add(ss1);
		p1.add(ss2);
		p1.add(ss3);
		p1.add(ss4);
		p1.add(ss5);
		p1.add(ss6);
		p1.add(ss7);
		p1.add(ss8);
		p1.setLayout(null);
		frame.add(p1);
		
		frame.setResizable(false);
		frame.setSize(800, 500);
		frame.setVisible(true);
		
	}
	
	class UsernameThread extends Thread{
		public void run(){
			
		}
	}
	

}
