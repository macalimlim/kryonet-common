package net.dlogic.kryonet.common.entity;

import net.dlogic.kryonet.common.manager.RoomManager;
import net.dlogic.kryonet.common.manager.RoomManagerInstance;

public class Myself extends User {
	public final RoomManager roomManager = RoomManagerInstance.manager;
}
