/**
 * ATMȡǮҳ�沼�ּ�ʵ��
 * 
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ATMDrawMoney extends ATMLogin {
	protected JPanel p3 = new JPanel();
	protected JLabel ss1 = new JLabel("������ȡ����");
	protected JLabel ss2 = new JLabel("*��ATM����С���Ϊ50");
	protected JButton bb1 = new JButton("��������");
	protected JTextField tt1 = new JTextField();
	protected JButton bb2 = new JButton("����");
	protected JButton btn1 = new JButton("ȷ��");
	protected Account acc2;
	protected Account acc = new Account();
	public ATMDrawMoney(){
		
	}
	public ATMDrawMoney(final Account acc){
		
		p1.setBounds(100, 100, 0, 0);
		ATMKey key = new ATMKey(p3, tt1);
		p3.setBounds(255, 220, 320, 220);
		bb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tt1.setText("");
			}
		});
		ss1.setBounds(300, 30, 300, 60);
		ss1.setFont(new Font("����", 30, 30));
		ss2.setBounds(320, 140, 220, 60);
		ss2.setFont(new Font("����", 20, 20));
		tt1.setBounds(220,90,400,50);
		tt1.setFont(new Font("����", 20, 20));
		namelabel.setBounds(160, 34, 0, 0);
		pswlabel.setBounds(160, 86, 0, 0);
		pswfield.setBounds(350,100,0,0);
		namefield.setBounds(350,40,0,0);
		btnback.setBounds(350,40,0,0);
		btnenter.setBounds(350,40,0,0);
		
		btn1.setBounds(645, 360, 140, 70);
		/*
		 * ��ȷ��ȡǮ��ť����ʱ�������
		 */
		btn1.addActionListener(new ActionListener() {
			
			@Override
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//���ı����ַ���ת��Ϊinteger����
				Integer ii = Integer.parseInt(tt1.getText());
				System.out.println(ii+"---------");
				if(ii % 50 == 0){
					try {
						//���޸ĺõĸ��˻����������˻�������������
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						acc.setMoney(acc.getMoney() - ii);
						System.out.println(acc.getMoney());
						oos.writeObject(acc);
						System.out.println(acc.getMoney());
						frame.dispose();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(ii);
					ATMSuccess as = new ATMSuccess(acc);
				}else{
					JDialog jd = new JDialog(frame,"����",true);
					JLabel msg = new JLabel("��������ȷ�Ľ��");
					msg.setBounds(55, 40, 150, 150);
					jd.setLayout(new BorderLayout());
					jd.setLayout(null);
					jd.add(msg);
					jd.setBounds(300, 200, 220, 220);
					jd.setVisible(true);
				}
				
				
			}
		});
		bb2.setBounds(10, 360, 140, 70);
		//�����û���������
		bb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ATMUserOperation auo = new ATMUserOperation(acc);
				frame.dispose();
			}
		});
		bb1.setBounds(645, 270, 140, 70);
		p2.add(p3);
		p2.add(ss1);
		p2.add(btn1);
		p2.add(ss2);
		p2.add(tt1);
		p2.add(bb1);
		p2.add(bb2);
		
	}
	

	
	

}
