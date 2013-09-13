package net.dlogic.kryonet.common.manager;


public class UserManagerInstance {
	private static UserManager userManager = new UserManager();
	public static UserManager getInstance() {
		return userManager;
	}
}
