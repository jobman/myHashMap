package com.job;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHashSizeChage {

	@Test
	public void test() {
		HashMap hmap = new HashMap();
		int expectedSize = 1000000;
		for (int i = 0; i < expectedSize; i++) {
			hmap.put(i, i);
		}
		assertEquals(expectedSize, hmap.size());
	}

}
