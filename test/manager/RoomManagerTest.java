package manager;

import static org.junit.Assert.*;

import net.dlogic.kryonet.common.constant.ErrorMessage;
import net.dlogic.kryonet.common.entity.Room;
import net.dlogic.kryonet.common.entity.User;
import net.dlogic.kryonet.common.manager.RoomManager;
import net.dlogic.kryonet.common.manager.RoomManagerException;
import net.dlogic.kryonet.common.manager.RoomManagerInstance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RoomManagerTest {
	private RoomManager manager;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	@Before
	public void setUp() throws Exception {
		manager = RoomManagerInstance.manager;
		Room room = new Room();
		room.name = "Test";
		room.maxUsers = 2;
		manager.map.put(room.name, room);
		Room room2 = new Room();
		room2.name = "Test2";
		room2.maxUsers = 32;
		manager.map.put(room2.name, room2);
		Room room3 = new Room();
		room3.name = "Lobby";
		room3.maxUsers = 32;
		manager.map.put(room3.name, room3);
	}
	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testAddUserToRoom() {
		try {
			User user = new User();
			user.id = 1;
			user.username = "mike";
			manager.addUserToRoom(user, "Test");
			Room testRoom = manager.map.get("Test");
			assertTrue(testRoom.users.containsKey(user.id));
		} catch (RoomManagerException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testAddUserToRoom_ThrowsRoomManagerException_RoomDoesntExist() throws RoomManagerException {
		exception.expect(RoomManagerException.class);
		exception.expectMessage(ErrorMessage.ROOM_DOESNT_EXIST);
		User user = new User();
		user.id = 1;
		user.username = "mike";
		manager.addUserToRoom(user, "Ghost");
		assertTrue(manager.map.get("Test").users.containsKey(user.id));
	}
	@Test
	public void testAddUserToRoom_ThrowsRoomManagerException_RoomIsFull() throws RoomManagerException {
		exception.expect(RoomManagerException.class);
		exception.expectMessage(ErrorMessage.ROOM_IS_FULL);
		User user = new User();
		user.id = 1;
		user.username = "mike";
		manager.addUserToRoom(user, "Test");
		User user2 = new User();
		user2.id = 2;
		user2.username = "angelo";
		manager.addUserToRoom(user2, "Test");
		User user3 = new User();
		user3.id = 3;
		user3.username = "mack";
		manager.addUserToRoom(user3, "Test");
	}
	@Test
	public void testAddUserToRoom_ThrowsRoomManagerException_UserAlreadyInRoom() throws RoomManagerException {
		exception.expect(RoomManagerException.class);
		exception.expectMessage(ErrorMessage.USER_ALREADY_IN_ROOM);
		User user = new User();
		user.id = 1;
		user.username = "mike";
		manager.addUserToRoom(user, "Test");
		manager.addUserToRoom(user, "Test");
	}
	@Test
	public void testRemoveUserFromRoom() {
		try {
			User user = new User();
			user.id = 1;
			user.username = "mike";
			manager.addUserToRoom(user, "Test");
			Room testRoom = manager.map.get("Test");
			assertTrue(testRoom.users.containsKey(user.id));
			manager.removeUserFromRoom(user, "Test");
			assertTrue(!testRoom.users.containsKey(user.id));
		} catch (RoomManagerException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRemoveUserFromRoom_ThrowsRoomManagerException_RoomDoesntExist() throws RoomManagerException {
		exception.expect(RoomManagerException.class);
		exception.expectMessage(ErrorMessage.ROOM_DOESNT_EXIST);
		User user = new User();
		user.id = 1;
		user.username = "mike";
		manager.removeUserFromRoom(user, "Ghost");
	}
	@Test
	public void testRemoveUserFromRoom_ThrowsRoomManagerException_UserNotInRoom() throws RoomManagerException {
		exception.expect(RoomManagerException.class);
		exception.expectMessage(ErrorMessage.USER_NOT_IN_ROOM);
		User user = new User();
		user.id = 1;
		user.username = "mike";
		manager.removeUserFromRoom(user, "Test2");
	}
	@Test
	public void testRemoveUserFromAllRooms() {
		try {
			User user = new User();
			user.id = 1;
			user.username = "mike";
			manager.addUserToRoom(user, "Test");
			Room testRoom = manager.map.get("Test");
			assertTrue(testRoom.users.containsKey(user.id));
			manager.removeUserFromAllRooms(user);
			assertTrue(!testRoom.users.containsKey(user.id));
		} catch (RoomManagerException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testIsUserJoinedInAnyRoom() {
		try {
			User user = new User();
			user.id = 1;
			user.username = "mike";
			manager.addUserToRoom(user, "Test");
			assertTrue(manager.isUserJoinedInAnyRoom(user));
			manager.removeUserFromAllRooms(user);
			assertTrue(!manager.isUserJoinedInAnyRoom(user));
		} catch (RoomManagerException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetRooms() {
		Room[] rooms = manager.getRooms("est");
		assertTrue(rooms[0].name.equalsIgnoreCase("Test"));
		assertTrue(rooms[1].name.equalsIgnoreCase("Test2"));
		assertTrue(rooms.length == 2);
		Room[] rooms2 = manager.getRooms("obby");
		assertTrue(rooms2[0].name.equalsIgnoreCase("Lobby"));
		assertTrue(rooms2.length == 1);
		Room[] rooms3 = manager.getRooms("ghost");
		assertTrue(rooms3.length == 0);
	}
}
