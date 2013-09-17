package net.dlogic.kryonet.common.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.dlogic.kryonet.common.constant.ErrorMessage;
import net.dlogic.kryonet.common.entity.Room;
import net.dlogic.kryonet.common.entity.User;

public class RoomManager extends BaseManager<String, Room> {
	public void addUserToRoom(User user, String roomName) throws RoomManagerException {
		if (!map.containsKey(roomName)) {
			throw new RoomManagerException(ErrorMessage.ROOM_DOESNT_EXIST);
		}
		Room room = map.get(roomName);
		if (room.isFull()) {
			throw new RoomManagerException(ErrorMessage.ROOM_IS_FULL);
		}
		if (room.userList.contains(user)) {
			throw new RoomManagerException(ErrorMessage.USER_ALREADY_IN_ROOM);
		}
		room.userList.add(user);
	}
	public void removeUserToRoom(User user, String roomName) throws RoomManagerException {
		if (!map.containsKey(roomName)) {
			throw new RoomManagerException(ErrorMessage.ROOM_DOESNT_EXIST);
		}
		Room room = map.get(roomName);
		if (!room.userList.contains(user)) {
			throw new RoomManagerException(ErrorMessage.USER_NOT_IN_ROOM);
		}
		room.userList.remove(user);
	}
	public Room[] getRooms(String search) {
		Iterator<Room> it = map.values().iterator();
		List<Room> roomList = new ArrayList<Room>();
		while (it.hasNext()) {
			Room room = it.next();
			if (search == null) {
				roomList.add(room);
			} else {
				if (room.name.equalsIgnoreCase(search) || room.name.toLowerCase().indexOf(search.toLowerCase()) != -1) {
					roomList.add(room);
				}
			}
		}
		return roomList.toArray(new Room[roomList.size()]);
	}
}
