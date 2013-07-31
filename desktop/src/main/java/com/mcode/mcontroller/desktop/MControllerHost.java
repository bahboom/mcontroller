package com.mcode.mcontroller.desktop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import network.multicast.MessageListener;
import network.multicast.Subscriber;

import com.mcode.mcontroller.core.configs.MulticastConfig;

public class MControllerHost implements MessageListener {
	private static final String TAG = "MControllerHost";
	private Robot r;
	private MControllerHost() throws AWTException {
		r = new Robot();
	}
	public static void main(String[] args) throws Exception {
		Subscriber sub = new Subscriber();
		sub.subscribe(MulticastConfig.GROUP, MulticastConfig.PORT, new MControllerHost());
	}
	
	@Override
	public void messageReceived(String group, int port, byte[] data) {
		if(data[0] == 1) { 
			r.keyPress(KeyEvent.VK_UP);
			System.out.println("keypressed");
		} else {
			r.keyRelease(KeyEvent.VK_UP);
			System.out.println("keyreleased");
		}
		//Gdx.app.log(TAG, "Message Received");
	}
}
