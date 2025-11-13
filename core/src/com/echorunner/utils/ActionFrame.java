package com.echorunner.utils;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Utility class for managing animation frames and timing
 */
public class ActionFrame {
    private Animation<TextureRegion> animation;
    private float stateTime;
    private boolean looping;

    public ActionFrame(Animation<TextureRegion> animation, boolean looping) {
        this.animation = animation;
        this.looping = looping;
        this.stateTime = 0f;
    }

    public void update(float delta) {
        stateTime += delta;
    }

    public TextureRegion getCurrentFrame() {
        return animation.getKeyFrame(stateTime, looping);
    }

    public void reset() {
        stateTime = 0f;
    }

    public boolean isAnimationFinished() {
        return animation.isAnimationFinished(stateTime);
    }

    // Getters and setters
    public Animation<TextureRegion> getAnimation() {
        return animation;
    }

    public void setAnimation(Animation<TextureRegion> animation) {
        this.animation = animation;
        this.stateTime = 0f;
    }

    public float getStateTime() {
        return stateTime;
    }

    public boolean isLooping() {
        return looping;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    /**
     * Creates a simple animation from an array of texture regions
     */
    public static Animation<TextureRegion> createAnimation(TextureRegion[] frames, float frameDuration) {
        return new Animation<>(frameDuration, frames);
    }
}
