package hashing;

import java.awt.Color;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lab05.NamesResource;



public class Hashing {
	/*
	 * Copyright (c) 1997, 2010, Oracle and/or its affiliates. All rights reserved.
	 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
	 */

	//copy the hash method from java.util.HashMap
	
	/**
	 * Returns index for hash code h.
	 */
	static int indexFor(int h, int length) {
		return h & (length-1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Color> myMap = new HashMap<String, Color>();

		myMap.put("Adam", Color.RED);
		myMap.put("Eve", Color.YELLOW);
		myMap.put("Juliet", Color.CYAN);
		myMap.put("Romeo", Color.GREEN);

		String str = "Adam";
		System.out.println(str.hashCode());
		System.out.println(hash(str));
		System.out.println(indexFor(hash(str), 16));

		str = "Eve";
		System.out.println(str.hashCode());
		System.out.println(hash(str));
		System.out.println(indexFor(hash(str), 16));

		str = "Juliet";
		System.out.println(str.hashCode());
		System.out.println(hash(str));
		System.out.println(indexFor(hash(str), 16));

		str = "Romeo";
		System.out.println(str.hashCode());
		System.out.println(hash(str));
		System.out.println(indexFor(hash(str), 16));
		
		int[] count = new int[128];
		for(String s : NamesResource.maleFirstNames) {
			count[indexFor(hash(s), 128)]++;			
		}
		
		int countZeros = 0;
		for (int i = 0; i < count.length; i++) {
			if (count[i] == 0) countZeros++;
		}
		System.out.println(Arrays.toString(count));
		System.out.println(countZeros);
	}

}
