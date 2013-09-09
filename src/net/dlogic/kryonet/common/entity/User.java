package net.dlogic.kryonet.common.entity;

import com.esotericsoftware.kryonet.Connection;

public class User {
	private String username;
	private Connection connection;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
}
