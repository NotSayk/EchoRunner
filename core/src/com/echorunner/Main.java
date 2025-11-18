package com.echorunner;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
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
    private TextureRegion region;
    private int cpt;

    @Override
    public void create()
    {
        InputHandler.init();

        this.sprite = new Texture("Main Characters/Pink Man/Idle (32x32).png");
        this.region = new TextureRegion(this.sprite, 0, 0, 32, 32);
        this.batch = new SpriteBatch();
    }

    @Override
    public void render()
    {
        ScreenUtils.clear(0,0,0,1,true);
        super.render();
        this.batch.begin();
        this.region.setRegion(cpt%11*32, 0, 32, 32);
        batch.draw(this.region, 10, 10);
        this.batch.end();
        this.cpt++;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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