package com.echorunner.ui;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.Texture;
/**
 * Handles texture rendering and management
 */
public class TextureHandler
{
    private Texture texture;
    private String status;
    private Animation<TextureRegion> animation;
    private float stateTime = 0;

    
    public TextureHandler(String status)
    {        
        this.status = status;
        changeSprite(this.status);
    }

    public void update(float delta)
    {
        this.stateTime += delta;
    }

    public void render(SpriteBatch batch, float x, float y)
    {
        TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
        batch.draw(currentFrame, x, y, 32, 32);
    }

    public void dispose()
    {
        if (texture != null)
        texture.dispose();
    }   

    public void changeSprite(String newStatus)
    {
        this.status = newStatus;
        if (texture != null) texture.dispose();
        texture = new Texture(this.status);
        TextureRegion[][] tmp = TextureRegion.split(texture, 32, 32);
        TextureRegion[] frames = new TextureRegion[tmp[0].length];
        System.arraycopy(tmp[0], 0, frames, 0, tmp[0].length);
        animation = new Animation<>(0.05f, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
    }
}
