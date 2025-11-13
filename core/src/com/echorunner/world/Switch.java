package com.echorunner.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Represents a switch that can trigger doors or events
 */
public class Switch {
    private Rectangle bounds;
    private boolean activated;
    private String id;
    private String linkedDoorId;
    private float x, y;
    private float width, height;

    public Switch(String id, float x, float y, float width, float height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.bounds = new Rectangle(x, y, width, height);
        this.activated = false;
    }

    public void update(float delta) {
        // TODO: Update switch state/animation
    }

    public void render(SpriteBatch batch) {
        // TODO: Render switch (activated or not)
    }

    public void activate() {
        this.activated = true;
        // TODO: Trigger linked door or event
    }

    public void deactivate() {
        this.activated = false;
    }

    public boolean isPlayerNear(Rectangle playerBounds) {
        return bounds.overlaps(playerBounds);
    }

    // Getters and setters
    public boolean isActivated() {
        return activated;
    }

    public String getId() {
        return id;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public String getLinkedDoorId() {
        return linkedDoorId;
    }

    public void setLinkedDoorId(String linkedDoorId) {
        this.linkedDoorId = linkedDoorId;
    }
}
