package com.postapocgame.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.postapocgame.game.MyPostApocGame;

public class WorldMap implements Screen{
	private MyPostApocGame game;
	private TiledMap tiledMap;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private int mapPixelWidth;
	private int mapPixelHeight;
	
	public WorldMap(MyPostApocGame gm) {
		game = gm;
	}

	@Override
	public void show() {
		tiledMap = new TmxMapLoader().load("maps/testMap2D.tmx");
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		camera = new OrthographicCamera();
		MapProperties prop = tiledMap.getProperties();
		
		int mapWidth = prop.get("width", Integer.class);
		int mapHeight = prop.get("height", Integer.class);
		
		int titlePixelWidth = prop.get("tilewidth", Integer.class);
		int titlePixelHeight = prop.get("tileheight", Integer.class);
		
		mapPixelWidth = mapWidth * titlePixelWidth;
		mapPixelHeight = mapHeight * titlePixelHeight;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderer.setView(camera);
 
		if(!Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {	
			float mouseY = Gdx.input.getY();
			float mouseX = Gdx.input.getX();
			
			//up
			if(mouseY < 40 && camera.position.y < mapPixelHeight) {
				camera.translate(new Vector2(0, 5));
			}if(mouseY < 20 && camera.position.y < mapPixelHeight) {
				camera.translate(new Vector2(0, 7));
			}
			//down
			if(mouseY > 640 && camera.position.y > 0) {
				camera.translate(new Vector2(0, -5)); 
			}if(mouseY > 660  && camera.position.y > 0) {
				camera.translate(new Vector2(0, -7));
			}
			//right
			if(Gdx.input.getX() > 1100  && camera.position.x < mapPixelWidth) {
				camera.translate(new Vector2(5, 0));
			}
			if(Gdx.input.getX() > 1200 && camera.position.x < mapPixelWidth) {
				camera.translate(new Vector2(7, 0));
			}
			//left
			if(Gdx.input.getX() < 150 && camera.position.x > 0) {
				camera.translate(new Vector2(-5, 0));
			}if(Gdx.input.getX() < 50 && camera.position.x > 0) {
				camera.translate(new Vector2(-7, 0));
			}

			if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				camera.translate(new Vector2(0, 50));
			}if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				camera.translate(new Vector2(0, -50));
			}if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				camera.translate(new Vector2(-50, 0));
			}if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				camera.translate(new Vector2(50, 0));
			}
			camera.update();
		}
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
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

	@Override
	public void hide() {
		
	} 

}
