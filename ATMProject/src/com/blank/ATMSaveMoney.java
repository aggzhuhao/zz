package com.blank;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ATMSaveMoney extends ATMDrawMoney {

	
	
	//构造有参函数，将用户acc和输入存款金额传至确认存款界面
	public ATMSaveMoney(final Account acc,String s) {
		super(acc);
	
		
		ss1.setText("请向现金槽中插入钞票");
		btn1.setBounds(645, 360, 0, 0);
		JButton btn2 = new JButton("确认");
		btn2.setBounds(645, 360, 140, 70);
		//确定按钮增加时间监听器来判断金额
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Integer ii = Integer.parseInt(tt1.getText());
				//判断金额是否符合要求
				if(ii % 50 != 0){
					JDialog jd = new JDialog(frame,"警告",true);
					JLabel msg = new JLabel("请输入正确的金额");
					msg.setBounds(55, 50, 150, 150);
					jd.setLayout(new BorderLayout());
					jd.setLayout(null);
					jd.add(msg);
					jd.setBounds(300, 200, 220, 220);
					jd.setVisible(true);
				}else{
					//跳转至确认存款界面
					System.out.println(ii);
					ATMSureSave as = new ATMSureSave(acc,tt1.getText());
					frame.dispose();
				}
			}
		});
		//返回用户操作界面
		bb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				ATMUserOperation aup = new ATMUserOperation(acc);
				frame.dispose();
			}
		});
		p2.add(btn2);
		
	}

	
	
}
