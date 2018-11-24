package com.blank;

import java.io.Serializable;

import javax.swing.JTextField;
/**
 * 可序列化的Account类
 * @author Administrator
 *
 */
public class Account implements Serializable{

	private String userNum;
	private String userpsw;
	private String name;
	private Integer money;
	
	public Account(String userNum, String userpsw, String name,Integer money) {
		super();
		this.userNum = userNum;
		this.userpsw = userpsw;
		this.name = name;
		this.money = money;
	}
	public Account() {
		
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserpsw() {
		return userpsw;
	}
	public void setUserpsw(String userpsw) {
		this.userpsw = userpsw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	
	
	
	
}
