package net.dlogic.kryonet.common.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.dlogic.kryonet.common.utility.IForEach;

public class Room {
	public final Map<Integer, User> users = new HashMap<Integer, User>();
	public String name;
	public int maxUsers = 32;
	public boolean isFull() {
		return maxUsers == users.size();
	}
	public void forEachUser(IForEach<User> forEach) {
		Iterator<User> it = users.values().iterator();
		while (it.hasNext()) {
			forEach.exec(it.next());
		}
	}
}
