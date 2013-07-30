package com.mcode.mcontroller.java;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import network.multicast.Subscriber;

public class MControllerHost {
	public static void main(String[] args) throws Exception {
		Subscriber sub = new Subscriber();
		sub.subscribe("239.192.1.1", 2222, null);

		
		System.out.println("end of host");
	}
}
