package com.job;

public class HashMap {

	private final int START_SIZE = 5;

	private int[] keys;
	private long[] values;
	private boolean[] notEmpty;
	private int size;

	public HashMap() {
		keys = new int[START_SIZE];
		values = new long[START_SIZE];
		notEmpty = new boolean[START_SIZE];
	}

	public long put(int key, long value) {
		int address = hashCode(key);
		while (true) {
			if (!notEmpty[address]) {
				keys[address] = key;
				values[address] = value;
				notEmpty[address] = true;
				size++;
				if (size > keys.length / 2) {
					resize();
				}
				return 0;
			} else if (keys[address] == key) {
				long oldValue = values[address];
				values[address] = value;
				return oldValue;
			} else {
				address++;
				if (address > keys.length - 1) {
					address = 0;
				}
			}
		}
	}

	public long get(int key) {
		int address = hashCode(key);
		while (address < keys.length) {
			if (keys[address] == key) {
				return values[address];
			} else {
				address++;
			}
		}
		return 0;
	}

	public int size() {
		return size;
	}

	private void resize() {
		int[] oldKeys = keys;
		long[] oldValues = values;
		boolean[] oldNotEmpty = notEmpty;

		int newLength = getNextPrimeNumber(keys.length * 2);
		keys = new int[newLength];
		values = new long[newLength];
		notEmpty = new boolean[newLength];
		size = 0;

		for (int i = 0; i < oldKeys.length; i++) {
			if (oldNotEmpty[i]) {
				put(oldKeys[i], oldValues[i]);
			}
		}
	}

	private int hashCode(int key) {
		return (key & 0x7fffffff) % keys.length;
	}

	public int getNextPrimeNumber(int n) {
		if (n % 2 == 0) {
			n++;
		} else if (n < 2) {
			return 0;
		}
		while (true) {
			n += 2;
			boolean isPrime = true;
			int roof = n / 2;
			for (int i = 2; i <= roof; i++) {
				if ((n % i) == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				return n;
			}
		}
	}
}
