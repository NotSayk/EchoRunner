package com.echorunner.entities;

import com.echorunner.ui.TextureHandler;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Saw extends Entity {
    private static final float SAW_WIDTH = 38f;
    private static final float SAW_HEIGHT = 38f;

    private TextureHandler textureHandler;

    public Saw(float x, float y) {
        super(x, y, SAW_WIDTH, SAW_HEIGHT);
        textureHandler = new TextureHandler("Traps/Saw/On (38x38).png", 38, 38);
    }

    @Override
    public void update(float delta) {
        textureHandler.update(delta);
    }

    @Override
    public void render(SpriteBatch batch) {
        textureHandler.render(batch, position.x, position.y, (int) SAW_WIDTH, (int) SAW_HEIGHT);
    }

    public void dispose() {
        textureHandler.dispose();
    }

}
