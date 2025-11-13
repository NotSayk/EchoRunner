package com.echorunner.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Represents a door that can be opened/closed
 */
public class Door {
    private Rectangle bounds;
    private boolean open;
    private boolean locked;
    private String linkedSwitchId;
    private float x, y;
    private float width, height;

    public Door(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bounds = new Rectangle(x, y, width, height);
        this.open = false;
        this.locked = true;
    }

    public void update(float delta) {
        // TODO: Update door animation
    }

    public void render(SpriteBatch batch) {
        // TODO: Render door (open or closed)
    }

    public void setOpen(boolean open) {
        if (!locked) {
            this.open = open;
        }
    }

    public void unlock() {
        this.locked = false;
    }

    public void lock() {
        this.locked = true;
        this.open = false;
    }

    // Getters and setters
    public boolean isOpen() {
        return open;
    }

    public boolean isLocked() {
        return locked;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getLinkedSwitchId() {
        return linkedSwitchId;
    }

    public void setLinkedSwitchId(String linkedSwitchId) {
        this.linkedSwitchId = linkedSwitchId;
    }
}
