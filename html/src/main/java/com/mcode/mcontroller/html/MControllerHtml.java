package com.mcode.mcontroller.html;

import com.mcode.mcontroller.core.MController;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class MControllerHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new MController();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
