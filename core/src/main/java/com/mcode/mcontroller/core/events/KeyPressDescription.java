package com.mcode.mcontroller.core.events;

public class KeyPressDescription {
	private boolean keyPressed = false;
	public KeyPressDescription(boolean b) {
		keyPressed = b;
	}
	public boolean keyPressed() {
		return keyPressed;
	}
	public byte[] getBytes() {
		if(keyPressed) {
			return new byte[]{ 1 };
		}
		return new byte[]{ 0 };
	}
}
