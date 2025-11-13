package com.echorunner.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Base class for all game entities
 */
public abstract class Entity {
    protected Vector2 position;
    protected Vector2 velocity;
    protected Rectangle bounds;
    protected boolean active;

    public Entity(float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.bounds = new Rectangle(x, y, width, height);
        this.active = true;
    }

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);

    public void updateBounds() {
        bounds.setPosition(position);
    }

    // Getters and setters
    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(float x, float y) {
        position.set(x, y);
        updateBounds();
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
