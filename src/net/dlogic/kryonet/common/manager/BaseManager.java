package net.dlogic.kryonet.common.manager;

import java.util.HashMap;
import java.util.Map;

public class BaseManager<K, V> {
	public final Map<K, V> map = new HashMap<K, V>();
}
