package com.job;

public class Main {

	public static void main(String[] args) {
		HashMap hm = new HashMap();
		for (int i = 0; i < 1000; i++) {
			int key = (int) (Math.random() * Integer.MAX_VALUE - 8);
			long value = (long) (Math.random() * Long.MAX_VALUE);
			hm.put(key, value);
		}
		System.out.println("ok");
	}

}
