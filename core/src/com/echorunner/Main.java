package com.echorunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.echorunner.screens.MainMenuScreen;

/**
 * Main game class - Entry point for EchoRunner
 */
public class Main extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        batch = new SpriteBatch();
        // TODO: Initialize game systems
        setScreen(new MainMenuScreen(this));
        Gdx.app.log("EchoRunnerGame", "Game created");
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        if (batch != null) {
            batch.dispose();
        }
        super.dispose();
    }
}
