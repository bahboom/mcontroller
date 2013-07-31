package com.mcode.mcontroller.core.events;

/**
 * There will only be a maximum of 256 keys.
 *
 */
public class ControlEvent {
	private byte key;
	public ControlEvent(int key) {
		this.key = (byte)key;
	}
	public ControlEvent getEvent(byte[] bytes) {
		return null;
	}
	public byte[] getBytes() {
		return new byte[]{key};
	}
}
