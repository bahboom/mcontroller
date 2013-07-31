package com.mcode.mcontroller.desktop;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import network.multicast.MessageListener;
import network.multicast.Subscriber;

public class MControllerHost implements MessageListener {
	private MControllerHost() {
		
	}
	public static void main(String[] args) throws Exception {
		Subscriber sub = new Subscriber();
		sub.subscribe("239.192.1.1", 2222, new MControllerHost());

		
		System.out.println("end of host");
	}
	@Override
	public void messageReceived(String group, int port, byte[] data) {
		System.out.println(new String(data));
	}
}
