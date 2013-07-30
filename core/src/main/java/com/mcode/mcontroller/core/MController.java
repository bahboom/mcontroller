package com.mcode.mcontroller.core;

import org.jeromq.ZMQ;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MController implements ApplicationListener {
	ZMQ.Context ctx = ZMQ.context();
	ZMQ.Socket pub  = ctx.socket(ZMQ.PUB);
	
	Texture texture;
	SpriteBatch batch;
	float elapsed;
	
	@Override
	public void create () {
		texture = new Texture(Gdx.files.internal("libgdx-logo.png"));
		batch = new SpriteBatch();
		
		pub.bind("tcp://*:2222");
	}

	@Override
	public void resize (int width, int height) {
		pub.send(new byte[]{0}, ZMQ.SNDMORE);
		pub.send(new byte[]{0}, 0);
		System.out.println("sending");
	}

	@Override
	public void render () {
		elapsed += Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, 100+100*(float)Math.cos(elapsed), 100+25*(float)Math.sin(elapsed));
		batch.end();
	}

	@Override
	public void pause () {
	}

	@Override
	public void resume () {
	}

	@Override
	public void dispose () {
	}
}
