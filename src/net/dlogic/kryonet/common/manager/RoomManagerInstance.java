package net.dlogic.kryonet.common.manager;


public class RoomManagerInstance {
	private static RoomManager roomManager = new RoomManager();
	public static RoomManager getInstance() {
		return roomManager;
	}
}
