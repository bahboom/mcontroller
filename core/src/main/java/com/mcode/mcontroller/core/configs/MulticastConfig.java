package com.mcode.mcontroller.core.configs;

public class MulticastConfig {
	public static final String GROUP = "239.192.1.1";
	public static final int PORT = 2222;
	public static final int TTL = 3;
	
	private MulticastConfig() {
		throw new UnsupportedOperationException();
	}
}
