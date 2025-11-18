package com.echorunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.echorunner.input.InputHandler;
import com.echorunner.logic.ActionHandler;
import com.echorunner.utils.ActionGroup;

/**
 * Main game class - Entry point for EchoRunner
 */
public class Main extends Game
{
    private enum actionTest implements ActionGroup
    {
        PROUT_MDR_AHAHAH
    }

    private Texture sprite;
    private SpriteBatch batch;

    @Override
    public void create()
    {
        InputHandler.init();

        this.sprite = new Texture("Main Characters/Pink Man/Run (32x32).png");
        this.batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        super.render();
        this.batch.begin();
        this.batch.draw(this.sprite, 50, 50);
        this.batch.end();
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}

/*
 * ASSETS JOUEUR 20FPS -> 50MS
 * 
*/