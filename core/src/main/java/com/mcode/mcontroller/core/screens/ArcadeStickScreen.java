package com.mcode.mcontroller.core.screens;

import java.io.IOException;

import network.multicast.Publisher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcode.mcontroller.core.MController;

public class ArcadeStickScreen implements Screen {
	private MController parent;
	
	private Texture buttonTexture;
	private Sprite[] buttonSprites;
	private SpriteBatch batch;

	public ArcadeStickScreen(MController parent) {
		this.parent = parent;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(buttonSprites[0], 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		buttonTexture = new Texture(Gdx.files.internal("libgdx-logo.png"));
		buttonSprites = new Sprite[6];
		for(int i = 0; i < 6; i++) {
			buttonSprites[i] = new Sprite(buttonTexture);
		}
		batch = new SpriteBatch();
		

	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
	