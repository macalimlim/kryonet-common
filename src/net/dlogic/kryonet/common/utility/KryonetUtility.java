package net.dlogic.kryonet.common.utility;

import net.dlogic.kryonet.common.request.JoinRoomRequest;
import net.dlogic.kryonet.common.request.LeaveRoomRequest;
import net.dlogic.kryonet.common.request.LoginRequest;
import net.dlogic.kryonet.common.request.LogoutRequest;
import net.dlogic.kryonet.common.request.PrivateMessageRequest;
import net.dlogic.kryonet.common.request.PublicMessageRequest;
import net.dlogic.kryonet.common.response.JoinRoomFailureResponse;
import net.dlogic.kryonet.common.response.JoinRoomSuccessResponse;
import net.dlogic.kryonet.common.response.LeaveRoomResponse;
import net.dlogic.kryonet.common.response.LoginFailureResponse;
import net.dlogic.kryonet.common.response.LoginSuccessResponse;
import net.dlogic.kryonet.common.response.LogoutResponse;
import net.dlogic.kryonet.common.response.PrivateMessageResponse;
import net.dlogic.kryonet.common.response.PublicMessageResponse;

import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.minlog.Log;

public class KryonetUtility {
	public static void registerClasses(EndPoint endpoint) {
		Log.info("KryonetUtility.registerClasses()");
		//Request classes
		endpoint.getKryo().register(JoinRoomRequest.class);
		endpoint.getKryo().register(LeaveRoomRequest.class);
		endpoint.getKryo().register(LoginRequest.class);
		endpoint.getKryo().register(LogoutRequest.class);
		endpoint.getKryo().register(PrivateMessageRequest.class);
		endpoint.getKryo().register(PublicMessageRequest.class);
		//Response classes
		endpoint.getKryo().register(JoinRoomFailureResponse.class);
		endpoint.getKryo().register(JoinRoomSuccessResponse.class);
		endpoint.getKryo().register(LeaveRoomResponse.class);
		endpoint.getKryo().register(LoginFailureResponse.class);
		endpoint.getKryo().register(LoginSuccessResponse.class);
		endpoint.getKryo().register(LogoutResponse.class);
		endpoint.getKryo().register(PrivateMessageResponse.class);
		endpoint.getKryo().register(PublicMessageResponse.class);
	}
}
