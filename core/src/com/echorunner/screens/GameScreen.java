package com.echorunner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.echorunner.Main;
import com.echorunner.entities.Player;
import com.echorunner.input.InputHandler;
import com.echorunner.world.Level;

/**
 * Main gameplay screen
 */
public class GameScreen implements Screen {
    private final Main game;
    private OrthographicCamera camera;
    private Viewport viewport;
    
    private Level currentLevel;
    private Player player;
    private InputHandler inputHandler;

    public GameScreen(Main game) {
        this.game = game;
        
        camera = new OrthographicCamera();
        viewport = new FitViewport(800, 600, camera);
        camera.position.set(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2, 0);
        
        // TODO: Initialize game objects
        player = new Player(100, 100);
       /*  inputHandler = new InputHandler(player); */
    }

    @Override
    public void show() {
        /* Gdx.input.setInputProcessor(inputHandler); */
        Gdx.app.log("GameScreen", "Game started");
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
        // TODO: Update game logic
        player.update(delta);
        camera.update();
    }

    private void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /* game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        
        // TODO: Render game objects
        player.render(game.batch);
        
        game.batch.end(); */
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        // TODO: Dispose resources
    }
}
