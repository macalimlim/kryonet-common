package net.dlogic.kryonet.common.entity;

import java.util.ArrayList;
import java.util.List;

public class RoomGroup {
	public int id;
	public String name;
	public List<Room> roomList;
	public RoomGroup() {
		roomList = new ArrayList<Room>();
	}
}
