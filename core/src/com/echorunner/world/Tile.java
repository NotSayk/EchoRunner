package com.echorunner.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Represents a tile in the game world
 */
public class Tile {
    public enum TileType {
        EMPTY,
        SOLID,
        PLATFORM,
        HAZARD,
        ECHO_REFLECTIVE
    }

    private Rectangle bounds;
    private TileType type;
    private boolean collidable;
    private float x, y;
    private float width, height;

    public Tile(float x, float y, float width, float height, TileType type) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = type;
        this.bounds = new Rectangle(x, y, width, height);
        this.collidable = (type == TileType.SOLID || type == TileType.PLATFORM);
    }

    public void render(SpriteBatch batch) {
        // TODO: Render tile based on type
    }

    public boolean isCollidable() {
        return collidable;
    }

    // Getters
    public Rectangle getBounds() {
        return bounds;
    }

    public TileType getType() {
        return type;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
