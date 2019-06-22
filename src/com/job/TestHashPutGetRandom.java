package com.job;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHashPutGetRandom {

	@Test
	public void test() {
		HashMap hmap = new HashMap();
		final int testLength = 1000;
		int keyOfExpectedValue = 0;
		long expectedValue = 0;
		for (int i = 0; i < testLength; i++) {
			int key = (int) (Math.random() * Integer.MAX_VALUE - Integer.MAX_VALUE / 2);
			long value = (long) (Math.random() * Long.MAX_VALUE - Long.MAX_VALUE / 2);
			hmap.put(key, value);

			if (i == testLength / 2) {
				keyOfExpectedValue = key;
				expectedValue = value;
			}
		}
		assertEquals(expectedValue, hmap.get(keyOfExpectedValue));
	}

}
