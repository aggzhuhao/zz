/**
 *
 * @author Administrator
 * 
 * ATM服务器的打开与输出输入数据
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
	private Map<String, Account>  accountMap = new HashMap<String,Account>();//第一个账号，第二个用户
	private Socket socket;//全局变量 套接字
	private List<Socket> socketList = new ArrayList<Socket>();
	private ServerSocket server;//全局变量 服务器
	private Account account = new Account();
	private Account acc2 = new Account();
	/*
	 * 服务器的开启并调用内部SendEveryThread线程
	 */
	public UserServer(){
		
		//若账号密码错误 ，服务器发送的废账号
		acc2.setUserNum("z");
		acc2.setUserpsw("0");
		
		try {	
			server = new ServerSocket(9999);
			System.out.println("开启服务器++++++++++++++++++++++++++++++++");
			
			//开启线程服务器将数据发送给每一个客户端
			SendEveyThread ss = new SendEveyThread();
			ss.start();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 服务器循环接受客户端传来的数据，并做处理
	 */
	class ServerThread extends Thread{
		public void run(){
			
			while(true){
				try {
					//服务器接收到客户端传来的数据
					ObjectInputStream ois1 = new ObjectInputStream(socket.getInputStream());
					System.out.println("接受----------------------------------");
						try {
							//新建一个Account存入数据
							Account acc1 = (Account) ois1.readObject();
							
							//将C:\\2.txt文件中Map读取出
							ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\2.txt"));
							System.out.println("读取序列化————————————————————————————————————");
							
							//建一个Map存入 该Map，<卡号，账户>
							Map<String, Account>  accountMap = (Map<String, Account>) ois.readObject();

							//判断Map中是否存在该卡号
							if(accountMap.containsKey(acc1.getUserNum())){
								
								//接受到的Account如果存在则判断该账号的 卡号和密码
								if(acc1.getUserpsw().equals(accountMap.get(acc1.getUserNum()).getUserpsw())){
									
									System.out.println("验证成功密码");
									//如果一样则吧该对象发送到客户端
									ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
									oos1.writeObject(accountMap.get(acc1.getUserNum()));
									System.out.println("******");
									oos1.flush();
									
									//修改余额
									//如果接受到的Account的卡号和accountMap中的姓名一样
									if(acc1.getUserNum().equals(accountMap.get(acc1.getUserNum()).getUserNum())&&acc1.getName() != null){
										//将acc1存入accountMap
										accountMap.put(acc1.getUserNum(), acc1);
										System.out.println("map放入姓名一样的账户1");
										//将accountMap序列化并存入C:\\2.txt
										ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C:\\2.txt"));
										oos2.writeObject(accountMap);
										
										System.out.println("将map序列化-----------");
										oos2.flush();
										
									}
								}else{
									//修改密码
									//如果acc1账户的姓名不为空
									if(acc1.getName() != null){
										accountMap.put(acc1.getUserNum(), acc1);
										ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("C:\\2.txt"));
										oos2.writeObject(accountMap);
										System.out.println("将map序列化-----------");
										oos2.flush();
										
									}else{
									//发送废账号
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
	 * 登录之后将数据发给每一个界面*/
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