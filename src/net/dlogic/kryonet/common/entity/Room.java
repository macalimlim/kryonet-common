package net.dlogic.kryonet.common.entity;

import java.util.HashMap;
import java.util.Map;

public class Room {
	public Map<Integer, User> users = new HashMap<Integer, User>();
	public String name;
	public int maxUsers;
	public boolean isFull() {
		return maxUsers == users.size();
	}
}
