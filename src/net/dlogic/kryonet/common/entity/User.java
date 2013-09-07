package net.dlogic.kryonet.common.entity;

import java.util.List;

import com.esotericsoftware.kryonet.Connection;

public class User {
	public String id;
	public String username;
	public Connection connection;
	public List<Room> joinedRooms;
}
