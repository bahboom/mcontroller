package com.mcode.mcontroller.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.mcode.mcontroller.core.MController;

public class MainControlScreen implements Screen {

	private MController parent;
	private Label hostLabel;
	private List hostList;
	
	private SpriteBatch sb;
	
	public MainControlScreen(MController parent) {
		this.parent = parent;
		sb = new SpriteBatch();
		hostLabel = new Label("Available Hosts:", new LabelStyle(new BitmapFont(), Color.BLACK ));
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.6f, 0.6f, 0.6f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		sb.begin();
		hostLabel.draw(sb, 1);
		sb.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
