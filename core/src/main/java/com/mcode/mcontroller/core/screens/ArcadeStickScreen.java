package com.mcode.mcontroller.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcode.mcontroller.core.MController;
import com.mcode.mcontroller.core.events.ControlEvent;

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
		
		Gdx.input.setInputProcessor(new ArcadeStickInputProcessor());
	}

	@Override
	public void hide() {
		// some clean up..
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
	
	private class ArcadeStickInputProcessor implements InputProcessor {

		@Override
		public boolean keyDown(int keycode) {
			return false;
		}

		@Override
		public boolean keyUp(int keycode) {
			return false;
		}

		@Override
		public boolean keyTyped(char character) {
			return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer, int button) {
			parent.sendControlEvent(new ControlEvent(0));
			return true;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button) {
			return false;
		}

		@Override
		public boolean touchDragged(int screenX, int screenY, int pointer) {
			return false;
		}

		@Override
		public boolean mouseMoved(int screenX, int screenY) {
			return false;
		}

		@Override
		public boolean scrolled(int amount) {
			return false;
		}
		
	}

}
	