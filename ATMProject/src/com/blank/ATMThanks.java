/**
 * ATM取回磁卡界面
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
	private JFrame frame = new JFrame("ATM自动取款系统");
	private JPanel p1 = new JPanel();
	private JLabel label1 = new JLabel("请收好您的银行卡，谢谢使用");
	private JLabel label2 = new JLabel("欢迎再次光临");
	private JLabel label3 = new JLabel("3秒后自动跳转......");
	private JPanel p2 = new JPanel();
	private JPanel p3 = new JPanel();

	
	public ATMThanks(){
		label1.setBounds(200, 100, 800, 60);
		label1.setFont(new Font("宋体", 30, 30));
		label2.setBounds(300, 160, 800, 60);
		label2.setFont(new Font("宋体", 30, 30));
		label3.setBounds(270, 220, 800, 60);
		label3.setFont(new Font("宋体", 30, 30));
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
	 * timless线程，3000毫秒后自动关闭该弹窗
	 */
	class timeLess extends Thread{
		
		public void run(){
			try {frame.setVisible(true);
				//label3.setText("3秒后自动跳转......");
				Thread.sleep((long) 1000.0);
				label3.setText("2秒后自动跳转......");
				Thread.sleep((long) 1000.0);
				label3.setText("1秒后自动跳转......");
				Thread.sleep((long) 1000.0);
				label3.setText("0秒后自动跳转......");
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
