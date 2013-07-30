package com.mcode.mcontroller.java;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jeromq.ZMQ;

public class MControllerHost {
	public static void main(String[] args) throws Exception {
		ZMQ.Context ctx = ZMQ.context();
		ZMQ.Socket sub = ctx.socket(ZMQ.SUB);
		sub.connect("tcp://192.168.0.21:2222");
		sub.subscribe(new byte[]{0});
		
		while(true) {
			sub.recv();
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_UP);
			System.out.println("pressing up");
		}
	}
}
