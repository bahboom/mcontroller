package com.mcode.mcontroller.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcode.mcontroller.core.MController;
import com.mcode.mjl.util.BitFlags;

public class ArcadeStickScreen implements Screen {
	private MController parent;
	
	private Texture buttonTexture;
	private Texture stickTexture;
	private Pixmap buttonPixmap;
	private Pixmap stickPixmap;
	private Sprite buttonSprite;
	private Sprite stickSprite;
	private SpriteBatch batch;

	private int buttonWidth;
	private int buttonHeight;
	
	public ArcadeStickScreen(MController parent) {
		this.parent = parent;
		
		buttonWidth = Gdx.graphics.getWidth() / 3;
		buttonHeight = Gdx.graphics.getHeight() / 2;
		
		buttonPixmap = new Pixmap(buttonWidth, buttonHeight, Pixmap.Format.RGB888);
		buttonPixmap.setColor(Color.CYAN);
		buttonPixmap.fillRectangle(0, 0, buttonWidth, buttonHeight);
		buttonPixmap.setColor(Color.BLUE);
		buttonPixmap.drawRectangle(0, 0, buttonWidth, buttonHeight);
		buttonTexture = new Texture(buttonPixmap);
		buttonSprite = new Sprite(buttonTexture);
		
		stickPixmap = new Pixmap(200, 200, Pixmap.Format.RGB888);
		stickPixmap.setColor(Color.CYAN);
		stickPixmap.fillCircle(100, 100, 100);
		stickTexture = new Texture(stickPixmap);
		stickSprite = new Sprite(stickTexture);
		
		//stickSprite.
		
		batch = new SpriteBatch();
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.9f, .1f, .2f, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(buttonSprite, 0, 0);
		//batch.draw(buttonSprite, 100, 100);
		batch.draw(stickSprite, 300, 300);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		Thread keypressListeningThread = new Thread(new Runnable() {
			@Override
			public void run() {
				BitFlags lastConfig = new BitFlags(1);
				while(!Thread.currentThread().isInterrupted()) {
					if(true) {
						int width = Gdx.graphics.getWidth() / 3;
						int height = Gdx.graphics.getHeight() / 2;
						
						BitFlags config = new BitFlags(1);
						for(int i = 0; i < 2; i++) {
							int x = Gdx.input.getX(i);
							int y = Gdx.input.getY(i);
							if(x == 0  && y == 0 || !Gdx.input.isTouched(i)) {
								continue;
							}
							
							if(x > 0 && x < width && y > 0 && y < height) {
								config.set(0);
								System.out.println("top left");
							}
							if(x > width && x < width * 2 && y > 0 && y < height) {
								config.set(1);
								System.out.println("top mid");
							}
							if(x > width * 2 && x < width * 3 && y > 0 && y < height) {
								config.set(2);
								System.out.println("top right");
							}
							if(x > 0 && x < width && y > height && y < height *2) {
								config.set(3);
								System.out.println("bottom left");
							}
							if(x > width && x < width * 2 && y > height && y < height *2) {
								config.set(4);
								System.out.println("bottom mid");
							}
							if(x > width * 2 && x < width * 3 && y > height && y < height * 2) {
								config.set(5);
								System.out.println("bottom right");
							}				
						}
						if(!config.equals(lastConfig)) {
							parent.sendKeyBytes(config.getBytes());
							System.out.println("Sending");
						}
						lastConfig = config;
					}
					
					try {
						Thread.sleep(1000 / 60); // 60 FPS
					} catch (InterruptedException x) {
						// TODO Log4j 
						x.printStackTrace();
					}
				}
			}
		}); 

		keypressListeningThread.start();
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
	