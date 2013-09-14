package net.dlogic.kryonet.common.manager;

import net.dlogic.kryonet.common.constant.ErrorMessage;
import net.dlogic.kryonet.common.entity.Room;
import net.dlogic.kryonet.common.entity.User;

public class RoomManager extends BaseManager<Room> {
	public void addUserToRoom(User user, int roomId) throws RoomManagerException {
		Room room = get(roomId);
		if (room.isFull()) {
			throw new RoomManagerException(ErrorMessage.ROOM_IS_FULL);
		}
		if (room.containsUser(user)) {
			throw new RoomManagerException(ErrorMessage.USER_ALREADY_IN_ROOM);
		}
		room.addUser(user);
	}
	public void removeUserToRoom(User user, int roomId) {
		get(roomId).removeUser(user);
	}
}
