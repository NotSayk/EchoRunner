package com.echorunner.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Handles texture rendering and management
 */
public class TextureHandler {
    private Texture texture;
    private String status;
    private Animation<TextureRegion> animation;
    private float stateTime = 0;
    private boolean flipX = false;
    private int spriteWidth = 32;
    private int spriteHeight = 32;

    public TextureHandler(String status) {
        this.status = status;
        changeSprite(this.status, false);
    }

    public TextureHandler(String status, int spriteWidth, int spriteHeight) {
        this.status = status;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
        changeSprite(this.status, false);
    }

    public void update(float delta) {
        this.stateTime += delta;
    }

    public void render(SpriteBatch batch, float x, float y) {
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y, 32, 32);
    }

    public void render(SpriteBatch batch, float x, float y, int width, int height) {
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y, width, height);
    }

    public void dispose() {
        if (texture != null)
            texture.dispose();
    }

    public void changeSprite(String newStatus) {
        changeSprite(newStatus, this.flipX);
    }

    public void changeSprite(String newStatus, boolean flipX) {
        this.flipX = flipX;
        this.status = newStatus;
        if (texture != null)
            texture.dispose();
        texture = new Texture(this.status);
        TextureRegion[][] tmp = TextureRegion.split(texture, spriteWidth, spriteHeight);
        TextureRegion[] frames = new TextureRegion[tmp[0].length];
        System.arraycopy(tmp[0], 0, frames, 0, tmp[0].length);
        if (flipX) {
            for (int i = 0; i < frames.length; i++) {
                frames[i].flip(true, false);
            }
        }
        animation = new Animation<>(0.05f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }
}
