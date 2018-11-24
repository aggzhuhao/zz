/**
 * 将Account类放入accountMap中
 * @author Administrator
 *
 */
package com.blank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.stream.FileImageInputStream;

public class AccountMap {
	private Map<String, Account>  accountMap = new HashMap<String,Account>();//第一个账号，第二个用户
	private Account acc1 = new Account("123456","123456","张三",2000);
	private Account acc2 = new Account("12345","12345","李四",2000);
	private Account acc3 = new Account("1234","1234","王五",2000);
	private Map<String, Account> accMap = new HashMap<String,Account>();
	public AccountMap(){
		//将Account放入accountMap
		accountMap.put(acc1.getUserNum(), acc1);
		accountMap.put(acc2.getUserNum(), acc2);
		accountMap.put(acc3.getUserNum(), acc3);
		try {
			//将accountMap输出到 c:\\2.txt
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\2.txt"));
			oos.writeObject(accountMap);
			//测试accountMap中的account的值
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\2.txt"));
			try {
				accMap = (Map<String, Account>) ois.readObject();
				accMap.get("123456").getUserpsw();
				System.out.println(accMap.get("123456").getUserpsw());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public static void main(String[] args) {
		AccountMap ac = new AccountMap();
		
	}


}
