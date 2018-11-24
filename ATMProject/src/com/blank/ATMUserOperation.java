/**
 * ATM�û����������湦�ܼ���ʵ��
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
	protected JFrame frame = new JFrame("ATM�Զ�ȡ��ϵͳ");
	protected JPanel p1 = new JPanel();
 

	protected JLabel s1 = new JLabel("�𾴵�:     **�� ");
	protected JLabel s2 = new JLabel("��ע���ÿ���ȫ");
	protected JButton btn1 = new JButton("��ѯ�û�");
	protected JButton btn2 = new JButton("��ȡ�ֽ�");
	protected JButton btn3 = new JButton("���شſ�");
	protected JButton btn4 = new JButton("�޸�����");
	protected JButton btn5 = new JButton("�����ֽ�");
	protected Socket socket;
	protected Account acc;
	private Account acc2;
	public ATMUserOperation(){
		
	}
	/*
	 * ���ܵ�¼���洫�ε�acc�˻�
	 */
	public ATMUserOperation(final Account acc){
		try {
			socket = new Socket("127.0.0.1",9999);
			System.out.println('2');
			
			
			String ss = acc.getName();
			s1.setText("�𾴵ģ�   " + ss);
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s1.setBounds(280, 160, 800, 60);
		s1.setFont(new Font("����", 30, 30));
		s2.setBounds(280, 220, 800, 60);
		s2.setFont(new Font("����", 30, 30));
		s2.setForeground(Color.red);
		btn1.setBounds(30, 230, 130, 50);
		//��btn1�����¼�����������ת���û���ѯ����
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
		//ҳ����ת��ȡǮ���棬����Account ����ȡǮ����
		btn2.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ATMDrawMoney adw = new ATMDrawMoney(acc);
				frame.dispose();
			}
		});
		btn3.setBounds(30, 370, 130, 50);
		//ҳ����ת�����شſ�ҳ��
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ATMThanks athanks = new ATMThanks();
				//frame.disable();
				frame.setVisible(false);
				
			}
		});
		btn4.setBounds(640, 230, 130, 50);
		//ҳ����ת���޸�����ҳ�棬����account������ҳ��
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ATMChangePsw acp = new ATMChangePsw(acc);
				
				frame.dispose();
			}
		});
		btn5.setBounds(640, 300, 130, 50);
		//ҳ����ת��ȡǮҳ�棬����account��������ҳ��
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
