/**
 * 小键盘页面布局及功能实现
 */
package com.blank;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ATMKey {
	
	private JButton b1 = new JButton("1");
	private JButton b2 = new JButton("2");
	private JButton b3 = new JButton("3");
	private JButton b4 = new JButton("4");
	private JButton b5 = new JButton("5");
	private JButton b6 = new JButton("6");
	private JButton b7 = new JButton("7");
	private JButton b8 = new JButton("8");
	private JButton b9 = new JButton("9");
	private JButton b10 = new JButton("0");
	private JButton b11 = new JButton("<-");
	private JButton b12 = new JButton("取消");
	private JTextField tt1 = new JTextField(20);
	public ATMKey(JPanel p1,final JTextField tt1){
		p1.setLayout(new GridLayout(4, 3));
		p1.add(b1);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "1");
			}
		});
		p1.add(b2);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "2");
			}
		});
		p1.add(b3);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "3");
			}
		});
		p1.add(b4);
		b4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "4");
			}
		});
		p1.add(b5);
		b5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "5");
			}
		});
		p1.add(b6);
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "6");
			}
		});
		p1.add(b7);
		b7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "7");
			}
		});
		p1.add(b8);
		b8.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "8");
			}
		});
		p1.add(b9);
		b9.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "9");
			}
		});
		p1.add(b10);
		b10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String temp = tt1.getText();
				tt1.setText(tt1.getText()+ "0");
			}
		});
		p1.add(b11);
		b11.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		p1.add(b12);
		b12.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				tt1.setText( "0");
			}
		});
	}
	
	
	
	
	
}
