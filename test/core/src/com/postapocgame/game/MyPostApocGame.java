package com.postapocgame.game;

import com.badlogic.gdx.Game;
import com.postapocgame.game.screens.WorldMap;

public class MyPostApocGame extends Game {

	@Override
	public void create() {
		setScreen(new WorldMap(this));
		
	}

}
