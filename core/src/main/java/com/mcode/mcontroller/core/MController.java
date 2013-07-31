package com.mcode.mcontroller.core;

import java.io.IOException;

import network.multicast.Publisher;

import com.badlogic.gdx.Game;
import com.mcode.mcontroller.core.screens.ArcadeStickScreen;

public class MController extends Game {
	private Publisher pub;

	@Override
	public void create() {
		try {
			pub = new Publisher("239.192.1.1", 2222, 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		setScreen(new ArcadeStickScreen(this));
	}
	
	public void publishMessage() {
		
	}

}
