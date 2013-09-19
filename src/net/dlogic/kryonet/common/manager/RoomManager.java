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
		if (room.users.containsKey(user.id)) {
			throw new RoomManagerException(ErrorMessage.USER_ALREADY_IN_ROOM);
		}
		room.users.put(user.id, user);
	}
	public void removeUserFromRoom(User user, String roomName) throws RoomManagerException {
		if (!map.containsKey(roomName)) {
			throw new RoomManagerException(ErrorMessage.ROOM_DOESNT_EXIST);
		}
		Room room = map.get(roomName);
		if (!room.users.containsKey(user.id)) {
			throw new RoomManagerException(ErrorMessage.USER_NOT_IN_ROOM);
		}
		room.users.remove(user.id);
	}
	public void removeUserFromAllRooms(User user) throws RoomManagerException {
		Iterator<Room> it = map.values().iterator();
		while (it.hasNext()) {
			Room room = it.next();
			if (it.next().users.containsKey(user.id)) {
				removeUserFromRoom(user, room.name);
			}
		}
	}
	public boolean isUserJoinedInAnyRoom(User user) {
		Iterator<Room> it = map.values().iterator();
		while (it.hasNext()) {
			if (it.next().users.containsKey(user.id)) {
				return true;
			}
		}
		return false;
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
