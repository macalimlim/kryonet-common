package net.dlogic.kryonet.common.entity;

import net.dlogic.kryonet.common.manager.RoomManager;
import net.dlogic.kryonet.common.manager.RoomManagerInstance;
import net.dlogic.kryonet.common.manager.UserManager;
import net.dlogic.kryonet.common.manager.UserManagerInstance;

public class Myself extends User {
	public final UserManager userManager = UserManagerInstance.manager;
	public final RoomManager roomManager = RoomManagerInstance.manager;
}
