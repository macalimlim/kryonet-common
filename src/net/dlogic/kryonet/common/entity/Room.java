package net.dlogic.kryonet.common.entity;

import java.util.ArrayList;
import java.util.List;

public class Room {
	public int id;
	public String name;
	public List<User> userList;
	public Room() {
		userList = new ArrayList<User>();
	}
}
