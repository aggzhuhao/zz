/**
 * ATMȡ�شſ�����
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ATMThanks {
	private JFrame frame = new JFrame("ATM�Զ�ȡ��ϵͳ");
	private JPanel p1 = new JPanel();
	private JLabel label1 = new JLabel("���պ��������п���ллʹ��");
	private JLabel label2 = new JLabel("��ӭ�ٴι���");
	private JLabel label3 = new JLabel("3����Զ���ת......");
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();

	
	public ATMThanks(){
		label1.setBounds(200, 100, 800, 60);
		label1.setFont(new Font("����", 30, 30));
		label2.setBounds(300, 160, 800, 60);
		label2.setFont(new Font("����", 30, 30));
		label3.setBounds(270, 220, 800, 60);
		label3.setFont(new Font("����", 30, 30));
		label3.setForeground(Color.red);
		
		p1.setLayout(null);
		p1.add(label1);
		p1.add(label2);
		p1.add(label3);
		frame.add(p1);
		
		
		frame.setSize(800, 500);
		
		Thread tt = new timeLess();
		tt.start();
		
	}
	/*
	 * timless�̣߳�3000������Զ��رոõ���
	 */
	class timeLess extends Thread{
		
		public void run(){
			try {frame.setVisible(true);
				//label3.setText("3����Զ���ת......");
				Thread.sleep((long) 1000.0);
				label3.setText("2����Զ���ת......");
				Thread.sleep((long) 1000.0);
				label3.setText("1����Զ���ת......");
				Thread.sleep((long) 1000.0);
				label3.setText("0����Զ���ת......");
				Thread.sleep(1000);
				frame.setVisible(false);
				ATMLogin al = new ATMLogin();
				
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	}
	public static void main(String[] args) {
		ATMThanks ss = new ATMThanks();
	}
	
}
