package net.dlogic.kryonet.common.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
	public List<User> userList = new ArrayList<User>();
	public int id;
	public String name;
	public int maxUsers;
	public boolean isFull() {
		return maxUsers == userList.size();
	}
}
