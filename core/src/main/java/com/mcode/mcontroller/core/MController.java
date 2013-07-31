package com.mcode.mcontroller.core;

import java.io.IOException;

import network.multicast.Publisher;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.mcode.mcontroller.core.configs.MulticastConfig;
import com.mcode.mcontroller.core.events.ControlEvent;
import com.mcode.mcontroller.core.screens.ArcadeStickScreen;

public class MController extends Game {
	private static final String TAG = "MController";
	private Publisher pub;

	@Override
	public void create() {
		try {
			pub = new Publisher(MulticastConfig.GROUP, MulticastConfig.PORT, MulticastConfig.TTL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setScreen(new ArcadeStickScreen(this));
	}
	
	public void sendControlEvent(ControlEvent event) {
		try {
			pub.publish(event.getBytes());
		} catch (IOException e) {
			Gdx.app.error(TAG, "Error sending control event", e);
		}
	}

}
