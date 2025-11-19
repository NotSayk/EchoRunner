package com.echorunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.echorunner.entities.Player;
import com.echorunner.input.InputHandler;

/**
 * Main game class - Entry point for EchoRunner
 */
public class Main extends Game {

    private SpriteBatch batch;
    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        InputHandler.init();
        player = new Player(100, 100);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.57f, 0.77f, 0.85f, 1);

        float delta = Gdx.graphics.getDeltaTime();
        player.update(delta);

        batch.begin();
        player.render(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}

/*
 * ASSETS JOUEUR 20FPS -> 50MS
 * 
 */