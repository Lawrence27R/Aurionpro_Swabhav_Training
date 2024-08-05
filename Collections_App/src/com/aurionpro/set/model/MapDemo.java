package com.aurionpro.set.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
	public static void main(String[] args) {
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		
		
		map.put("A", 100);
		map.put("B", 100);
		map.put("D", 100);
		map.put("G", 100);
		map.put("E", 100);
//		Overrites
		map.put("A", 500);
		
//		map.put(null, 300);
		map.put("J", null);
		
		System.out.println(map);
//		If absent will put in the map
		map.putIfAbsent("A", 700);
	}
}
