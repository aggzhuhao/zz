package com.blank;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ATMSaveMoney extends ATMDrawMoney {

	
	
	//�����вκ��������û�acc�����������ȷ�ϴ�����
	public ATMSaveMoney(final Account acc,String s) {
		super(acc);
	
		
		ss1.setText("�����ֽ���в��볮Ʊ");
		btn1.setBounds(645, 360, 0, 0);
		JButton btn2 = new JButton("ȷ��");
		btn2.setBounds(645, 360, 140, 70);
		//ȷ����ť����ʱ����������жϽ��
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Integer ii = Integer.parseInt(tt1.getText());
				//�жϽ���Ƿ����Ҫ��
				if(ii % 50 != 0){
					JDialog jd = new JDialog(frame,"����",true);
					JLabel msg = new JLabel("��������ȷ�Ľ��");
					msg.setBounds(55, 50, 150, 150);
					jd.setLayout(new BorderLayout());
					jd.setLayout(null);
					jd.add(msg);
					jd.setBounds(300, 200, 220, 220);
					jd.setVisible(true);
				}else{
					//��ת��ȷ�ϴ�����
					System.out.println(ii);
					ATMSureSave as = new ATMSureSave(acc,tt1.getText());
					frame.dispose();
				}
			}
		});
		//�����û���������
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
