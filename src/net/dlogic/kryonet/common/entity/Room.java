package net.dlogic.kryonet.common.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private int id;
	private String name;
	private List<User> userList;
	public Room() {
		userList = new ArrayList<User>();
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUserList() {
		return userList;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	public boolean addUser(User user) {
		return userList.add(user);
	}
	public boolean removeUser(User user) {
		return userList.remove(user);
	}
	public boolean containsUser(User user) {
		return userList.contains(user);
	}
}
