package net.dlogic.kryonet.common.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseManager<V> {
	private Map<Integer, V> map = new HashMap<Integer, V>();
	public V put(Integer key, V value) {
		return map.put(key, value);
	}
	public V remove(int key) {
		return map.remove(key);
	}
	public V get(int key) {
		return map.get(key);
	}
	public Iterator<V> iterator() {
		return map.values().iterator();
	}
}
