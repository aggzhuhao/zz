/**
 * ATM��ӡƾ������
 */
package com.blank;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ATMSuccess {
	private JFrame frame = new JFrame("ATM�Զ�ȡ��ϵͳ");
	private JPanel p = new JPanel();
	private JLabel s1 = new JLabel("ȡ��ɹ� ");
	private JLabel s2 = new JLabel("�Ƿ��ӡȡ��ƾ��?");
	private JButton bb1 = new JButton("��");
	private JButton bb2 = new JButton("��");
	
	public ATMSuccess(final Account acc){
		s1.setBounds(320, 120, 800, 60);
		s1.setFont(new Font("����", 30, 30));
		s2.setBounds(280, 180, 800, 60);
		s2.setFont(new Font("����", 30, 30));
		bb1.setBounds(645, 270, 140, 70);
		//����ӡƾ��
		bb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ATMDrawMoney ad = new ATMDrawMoney(acc);
				frame.dispose();
			}
		});
		bb2.setBounds(645, 360, 140, 70);
		//ƾ����ӡ�ɹ�
		bb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("��ӡ�ɹ�-------------");
				JDialog jd = new JDialog(frame,"��ʾ",true);
				JLabel msg = new JLabel("��ӡ�ɹ�");
				msg.setBounds(55, 50, 150, 150);
				jd.setLayout(new BorderLayout());
				jd.setLayout(null);
				jd.add(msg);
				jd.setBounds(300, 200, 220, 220);
				jd.setVisible(true);
				ATMDrawMoney ad = new ATMDrawMoney(acc);
				frame.dispose();
				
			}
		});
		p.add(s1);
		p.add(s2);
		p.add(bb1);
		p.add(bb2);
		frame.add(p);
		p.setLayout(null);
		frame.setResizable(false);
		frame.setSize(800, 500);
		frame.setVisible(true);
	}
	

}
