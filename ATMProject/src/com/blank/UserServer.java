/**
 *
 * @author Administrator
 * 
 * ATM�������Ĵ��������������
 *
 */
package com.blank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;



public class UserServer {
	private Map<String, Account>  accountMap = new HashMap<String,Account>();//��һ���˺ţ��ڶ����û�
	private Socket socket;//ȫ�ֱ��� �׽���
	private List<Socket> socketList = new ArrayList<Socket>();
	private ServerSocket server;//ȫ�ֱ��� ������
	private Account account = new Account();
	private Account acc2 = new Account();
	/*
	 * �������Ŀ����������ڲ�SendEveryThread�߳�
	 */
	public UserServer(){
		
		//���˺�������� �����������͵ķ��˺�
		acc2.setUserNum("z");
		acc2.setUserpsw("0");
		
		try {	
			server = new ServerSocket(9999);
			System.out.println("����������++++++++++++++++++++++++++++++++");
			
			//�����̷߳����������ݷ��͸�ÿһ���ͻ���
			SendEveyThread ss = new SendEveyThread();
			ss.start();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * ������ѭ�����ܿͻ��˴��������ݣ���������
	 */
	class ServerThread extends Thread{
		public void run(){
			
			while(true){
				try {
					//���������յ��ͻ��˴���������
					ObjectInputStream ois1 = new ObjectInputStream(socket.getInputStream());
					System.out.println("����----------------------------------");
						try {
							//�½�һ��Account��������
							Account acc1 = (Account) ois1.readObject();
							
							//��C:\\2.txt�ļ���Map��ȡ��
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\2.txt"));
							System.out.println("��ȡ���л�������������������������������������������������������������������������");
							
							//��һ��Map���� ��Map��<���ţ��˻�>
							Map<String, Account>  accountMap = (Map<String, Account>) ois.readObject();

							//�ж�Map���Ƿ���ڸÿ���
							if(accountMap.containsKey(acc1.getUserNum())){
								
								//���ܵ���Account����������жϸ��˺ŵ� ���ź�����
								if(acc1.getUserpsw().equals(accountMap.get(acc1.getUserNum()).getUserpsw())){
									
									System.out.println("��֤�ɹ�����");
									//���һ����ɸö����͵��ͻ���
									ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
									oos1.writeObject(accountMap.get(acc1.getUserNum()));
									System.out.println("******");
									oos1.flush();
									
									//�޸����
									//������ܵ���Account�Ŀ��ź�accountMap�е�����һ��
									if(acc1.getUserNum().equals(accountMap.get(acc1.getUserNum()).getUserNum())&&acc1.getName() != null){
										//��acc1����accountMap
										accountMap.put(acc1.getUserNum(), acc1);
										System.out.println("map��������һ�����˻�1");
										//��accountMap���л�������C:\\2.txt
										ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C:\\2.txt"));
										oos2.writeObject(accountMap);
										
										System.out.println("��map���л�-----------");
										oos2.flush();
										
									}
								}else{
									//�޸�����
									//���acc1�˻���������Ϊ��
									if(acc1.getName() != null){
										accountMap.put(acc1.getUserNum(), acc1);
										ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C:\\2.txt"));
										oos2.writeObject(accountMap);
										System.out.println("��map���л�-----------");
										oos2.flush();
										
									}else{
									//���ͷ��˺�
									ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
									
									oos1.writeObject(acc2);
									}
									
								

									
								}
							}else{
								
								ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
								
								oos1.writeObject(acc2);
							}
							 
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				//SendEveyThread set = new SendEveyThread();
				//set.start();
				}			
			
		}
	}

	/*
	 * ��¼֮�����ݷ���ÿһ������*/
	class SendEveyThread extends Thread{
		public void run(){
			try {
				while(true){
					socket = server.accept();	
					Thread st = new ServerThread();
					st.start();
	
				}  
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}