/**
 * 
 */
package com.xiter.igou.model;

/**
 * Description:用户实体
 * 
 * @author liufeihua
 * @date 2014-11-18下午4:19:35
 * @version 1.0
 * 
 */
public class User {

	private String id;
	private String userName;
	private String password;
	private String felling;
	private String head;
	private String regtime;

	public User() {
	}

	public User(String id, String userName, String password, String felling,
			String head, String regtime) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.felling = felling;
		this.head = head;
		this.regtime = regtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFelling() {
		return felling;
	}

	public void setFelling(String felling) {
		this.felling = felling;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password="
				+ password + ", felling=" + felling + ", head=" + head
				+ ", regtime=" + regtime + "]";
	}

}
