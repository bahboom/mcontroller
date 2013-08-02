package com.mcode.mcontroller.desktop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import network.multicast.MessageListener;
import network.multicast.Subscriber;

import com.mcode.mcontroller.core.configs.MulticastConfig;
import com.mcode.mjl.util.BitFlags;

public class MControllerHost implements MessageListener {
	private static final String TAG = "MControllerHost";
	
	private BitFlags lastConfig = null;
	private Robot r;
	private MControllerHost() throws AWTException {
		r = new Robot();
	}
	public static void main(String[] args) throws Exception {
		Subscriber sub = new Subscriber();
		sub.subscribe(MulticastConfig.GROUP, MulticastConfig.PORT, new MControllerHost());
	}
	
	@Override
	public void messageReceived(byte[] data) {
		BitFlags config = new BitFlags(data);
		
		if(config.get(0)) { 
			r.keyPress(KeyEvent.VK_UP);
			System.out.println("keypressed");
		} else {
			r.keyRelease(KeyEvent.VK_UP);
			System.out.println("keyreleased");
		}
		if(config.get(1)) { 
			r.keyPress(KeyEvent.VK_DOWN);
			System.out.println("keypressed");
		} else {
			r.keyRelease(KeyEvent.VK_DOWN);
			System.out.println("keyreleased");
		}
		//Gdx.app.log(TAG, "Message Received");
	}
}
