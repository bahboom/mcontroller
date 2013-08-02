package com.mcode.mcontroller.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mcode.mcontroller.core.MController;
import com.mcode.mjl.util.BitFlags;

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
		Gdx.gl.glClearColor(.9f, .1f, .2f, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(buttonSprites[0], 0, 0);
//		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		//buttonTexture = new Texture(Gdx.files.internal("libgdx-logo.png"));
//		buttonSprites = new Sprite[6];
//		for(int i = 0; i < 6; i++) {
//			buttonSprites[i] = new Sprite();
//			buttonSprites[i].setColor(1, 1, 0, 1);
//		}
//		batch = new SpriteBatch();
//		
//		Gdx.input.setInputProcessor(new ArcadeStickInputProcessor());
//		Gdx.input.getX
		
		Thread keypressListeningThread = new Thread(new Runnable() {
			@Override
			public void run() {
				BitFlags lastConfig = new BitFlags(1);
				while(!Thread.currentThread().isInterrupted()) {
					if(Gdx.input.isTouched()) {
						int width = Gdx.graphics.getWidth() / 3;
						int height = Gdx.graphics.getHeight() / 2;
						
						BitFlags config = new BitFlags(1);
						for(int i = 0; i < 10; i++) {
							int x = Gdx.input.getX(i);
							int y = Gdx.input.getY(i);
							if(x == 0  && y == 0) {
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
							//config.
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
	

}
	