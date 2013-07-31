package com.mcode.mcontroller.desktop;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.badlogic.gdx.Gdx;
import com.mcode.mcontroller.core.configs.MulticastConfig;

import network.multicast.MessageListener;
import network.multicast.Subscriber;

public class MControllerHost implements MessageListener {
	private static final String TAG = "MControllerHost";
	private MControllerHost() {
		
	}
	public static void main(String[] args) throws Exception {
		Subscriber sub = new Subscriber();
		sub.subscribe(MulticastConfig.GROUP, MulticastConfig.PORT, new MControllerHost());

		
		System.out.println("end of host");
	}
	
	@Override
	public void messageReceived(String group, int port, byte[] data) {
		System.out.println("mmm");
		//Gdx.app.log(TAG, "Message Received");
	}
}
