package net.dlogic.kryonet.common.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
	private List<User> userList;
	public int id;
	public String name;
	public int maxUsers;
	public Room() {
		userList = new ArrayList<User>();
	}
	public List<User> getUserList() {
		return userList;
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
	public boolean isFull() {
		return maxUsers == userList.size();
	}
}
