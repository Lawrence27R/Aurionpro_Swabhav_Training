package com.aurionpro.set.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapToSet {
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1, "Samsung");
		map.put(2, "Apple");
		map.put(3, "Xaomi");
		map.put(4, "Google");
		
		System.out.println(map);
		
		Set<Entry<Integer, String>> entries = map.entrySet();
		
		for (Entry entry: entries) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}
