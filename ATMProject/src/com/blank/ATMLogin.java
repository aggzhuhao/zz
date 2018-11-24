package com.blank;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * ATM��¼ҳ�沼��
 * @author Administrator
 *
 */
public class ATMLogin {
	protected JFrame frame = new JFrame("ATM�Զ�ȡ��ϵͳ");
	protected JPanel p1 = new JPanel();// key����
	protected JPanel p2 = new JPanel();// ���岼��
	protected JLabel namelabel = new JLabel("    ����         ");
	protected JTextField namefield = new JTextField(20);
	protected JLabel pswlabel = new JLabel("    ����         ");
	protected JPasswordField pswfield = new JPasswordField(20);
	protected JButton btnback = new JButton("ȡ�شſ�");
	protected JButton btnenter = new JButton("  ȷ ��  ");
	protected Socket socket;
	protected Account acc = new Account();
	protected Account acc1 = new Account();
	protected int sign;
	
	
	public ATMLogin() {
		init();

	}

	public void init() {

		try {
			socket = new Socket("127.0.0.1", 9999);

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		namelabel.setBounds(160, 34, 800, 70);
		namelabel.setFont(new Font("����", 30, 30));
		pswlabel.setBounds(160, 86, 800, 70);
		pswlabel.setFont(new Font("����", 30, 30));
		pswfield.setBounds(350, 100, 300, 50);

		namefield.setBounds(350, 40, 300, 50);
		//��namefield�����������������ӱ�ʶλ
		namefield.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sign = 0;
			}
		});
		//��pswfield�����������������ӱ�ʶλ
		pswfield.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				sign = 1;
			}
		});
		p1.setBounds(255, 220, 320, 220);

		btnback.setBounds(10, 360, 140, 70);
		btnenter.setBounds(645, 360, 140, 70);
		System.out.println("111111111111111111");
		/*
		 * ��ȷ����ť���Ӽ�����
		 */
		btnenter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					System.out.println(socket);
					//������ĸÿ��ź���������Account������������
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					System.out.println("��ֵ֮ǰ+++++++++++++++++++++");
					acc.setUserNum(namefield.getText());
					acc.setUserpsw(pswfield.getText());
					oos.writeObject(acc);
					System.out.println("   ����������������������������������������");
					
					//���ܷ������������ͻ��˵�����
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

					try {
						acc1 = (Account) ois.readObject();
						//�����¼ʱ����˺ź����� �ͷ�������������һ�������¼
						if (acc1.getUserNum().equals(namefield.getText())&& acc1.getUserpsw().equals(pswfield.getText())) {
							System.out.println("��¼�ɹ�+++++++++++++++++++");
							frame.dispose();
							//�����вκ��������˻�acc1�����û���������
							ATMUserOperation auo = new ATMUserOperation(acc1);

						} else {
							JDialog jd = new JDialog(frame,"����",true);
							JLabel msg = new JLabel("�������");
							msg.setBounds(60, 50, 150, 100);
							jd.setLayout(new BorderLayout());
							jd.setLayout(null);
							jd.add(msg);
							jd.setBounds(300, 200, 200, 200);
							jd.setVisible(true);
							System.out.println("��¼ʧ�ܡ�����������������������������������������������-");
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ATMThanks athanks = new ATMThanks();
				// frame.disable();
				frame.setVisible(false);

			}
		});
		/*
		 * ���̲���
		 */
		p1.setLayout(new GridLayout(4, 3));
		JButton b1 = new JButton("1");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "1");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "1");
				}

			}
		});
		JButton b2 = new JButton("2");
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "2");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "2");
				}

			}
		});
		JButton b3 = new JButton("3");
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "3");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "3");
				}

			}
		});
		JButton b4 = new JButton("4");
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "4");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "4");
				}

			}
		});
		JButton b5 = new JButton("5");
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "5");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "5");
				}

			}
		});
		JButton b6 = new JButton("6");

		b6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "6");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "6");
				}

			}
		});
		JButton b7 = new JButton("7");
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "7");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "7");
				}

			}
		});
		JButton b8 = new JButton("8");
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "8");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "8");
				}

			}
		});
		JButton b9 = new JButton("9");
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "7");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "7");
				}

			}
		});
		JButton b10 = new JButton("0");
		b10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText(temp + "10");
				} else {
					String temp = pswfield.getText();
					pswfield.setText(temp + "10");
				}

			}
		});
		JButton b11 = new JButton("<-");
		b11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();

				} else {
					String temp = pswfield.getText();

				}

			}
		});
		JButton b12 = new JButton("ȡ��");
		b12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sign == 0) {
					String temp = namefield.getText();
					namefield.setText("");
				} else {
					String temp = pswfield.getText();
					pswfield.setText("");
				}

			}
		});
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(b10);
		p1.add(b11);
		p1.add(b12);
		p2.add(pswfield);
		p2.add(namefield);
		p2.add(namelabel);
		p2.add(pswlabel);
		p2.add(btnback);
		p2.add(btnenter);
		p2.add(p1);
		p2.setLayout(null);

		frame.add(p2);
		frame.setResizable(false);
		frame.setSize(800, 500);
		frame.setVisible(true);

	}

	class btnThread extends Thread {
		public void run() {

		}

	}

	public static void main(String[] args) {
		UserServer ssss = new UserServer();
		ATMLogin b1 = new ATMLogin();
		

	}

}
