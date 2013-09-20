package net.dlogic.kryonet.common.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.dlogic.kryonet.common.constant.ErrorMessage;
import net.dlogic.kryonet.common.entity.Room;
import net.dlogic.kryonet.common.entity.User;
import net.dlogic.kryonet.common.utility.IForEach;

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
	public void removeUserFromAllRooms(final User user) throws RoomManagerException {
		forEachRoom(new IForEach<Room>() {
			public void exec(Room entity) {
				if (entity.users.containsKey(user.id)) {
					try {
						removeUserFromRoom(user, entity.name);
					} catch (RoomManagerException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	public boolean isUserJoinedInAnyRoom(final User user) {
		Iterator<Room> it = map.values().iterator();
		while (it.hasNext()) {
			if (it.next().users.containsKey(user.id)) {
				return true;
			}
		}
		return false;
	}
	public Room[] getRooms(final String search) {
		final List<Room> roomList = new ArrayList<Room>();
		forEachRoom(new IForEach<Room>() {
			public void exec(Room entity) {
				if (search == null) {
					roomList.add(entity);
				} else {
					if (entity.name.toLowerCase().indexOf(search.toLowerCase()) != -1) {
						roomList.add(entity);
					}
				}
			}
		});
		return roomList.toArray(new Room[roomList.size()]);
	}
	public void forEachRoom(IForEach<Room> forEach) {
		Iterator<Room> it = map.values().iterator();
		while (it.hasNext()) {
			forEach.exec(it.next());
		}
	}
}
