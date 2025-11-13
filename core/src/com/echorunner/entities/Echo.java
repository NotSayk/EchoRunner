package com.echorunner.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Echo entity - Sound waves emitted by the player for navigation
 */
public class Echo extends Entity {
    private static final float ECHO_RADIUS_START = 10f;
    private static final float ECHO_EXPANSION_RATE = 200f;
    private static final float ECHO_MAX_RADIUS = 500f;

    private float radius;
    private float lifetime;
    private float maxLifetime;
    private float alpha;

    public Echo(float x, float y) {
        super(x, y, ECHO_RADIUS_START * 2, ECHO_RADIUS_START * 2);
        this.radius = ECHO_RADIUS_START;
        this.maxLifetime = ECHO_MAX_RADIUS / ECHO_EXPANSION_RATE;
        this.lifetime = 0f;
        this.alpha = 1f;
    }

    @Override
    public void update(float delta) {
        lifetime += delta;
        radius += ECHO_EXPANSION_RATE * delta;
        alpha = 1f - (lifetime / maxLifetime);

        if (radius >= ECHO_MAX_RADIUS || alpha <= 0) {
            active = false;
        }

        updateBounds();
    }

    @Override
    public void render(SpriteBatch batch) {
        // TODO: Implement echo wave rendering
    }

    public void renderShape(ShapeRenderer shapeRenderer) {
        // TODO: Draw circular wave
    }

    public boolean hasHitObject(Entity entity) {
        // TODO: Check collision with other entities
        return false;
    }

    // Getters
    public float getRadius() {
        return radius;
    }

    public float getAlpha() {
        return alpha;
    }
}
