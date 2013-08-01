package com.mcode.mcontroller.core;

import java.io.IOException;
import java.net.InetAddress;

import network.multicast.Publisher;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mcode.mcontroller.core.configs.MulticastConfig;
import com.mcode.mcontroller.core.events.KeyPressDescription;
import com.mcode.mcontroller.core.screens.ArcadeStickScreen;

public class MController extends Game {
	private static final String TAG = "MController";
	private Publisher pub;

	@Override
	public void create() {
		try {
			pub = new Publisher(MulticastConfig.GROUP, MulticastConfig.PORT, MulticastConfig.TTL);
		} catch (IOException e) {
			Gdx.app.error(TAG, "Error instantiating publisher", e);
		}
		setScreen(new ArcadeStickScreen(this));
	}
	
	public void sendKeyPressDescription(KeyPressDescription description) {
		try {
			pub.publish(description.getBytes());
			Gdx.app.log(TAG, "Sending KeyPressDescription : " + InetAddress.getLocalHost().getHostAddress());
		} catch (IOException e) {
			Gdx.app.error(TAG, "Error sending KeyPressDescription", e);
		}
	}

}
