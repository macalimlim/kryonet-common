package net.dlogic.kryonet.common.manager;

import java.util.HashMap;
import java.util.Map;

public class BaseManager<V> {
	public final Map<Integer, V> map = new HashMap<Integer, V>();
}
