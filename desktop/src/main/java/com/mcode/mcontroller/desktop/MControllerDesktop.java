package com.mcode.mcontroller.desktop;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mcode.mcontroller.core.MController;

public class MControllerDesktop {
	public static void main (String[] args) throws UnknownHostException {
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
		new LwjglApplication(new MController(), config);
	}
}
