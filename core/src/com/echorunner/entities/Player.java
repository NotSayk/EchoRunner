package com.echorunner.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Player entity controlled by the user
 */
public class Player extends Entity {
    private static final float PLAYER_WIDTH = 32f;
    private static final float PLAYER_HEIGHT = 32f;
    private static final float MOVE_SPEED = 200f;
    private static final float JUMP_VELOCITY = 500f;

    private boolean grounded;
    private boolean canJump;

    public Player(float x, float y) {
        super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.grounded = false;
        this.canJump = true;
    }

    @Override
    public void update(float delta) {
        // TODO: Implement player physics and movement
        position.add(velocity.x * delta, velocity.y * delta);
        updateBounds();
    }

    @Override
    public void render(SpriteBatch batch) {
        // TODO: Implement player rendering
    }

    public void moveLeft() {
        velocity.x = -MOVE_SPEED;
    }

    public void moveRight() {
        velocity.x = MOVE_SPEED;
    }

    public void stopMoving() {
        velocity.x = 0;
    }

    public void jump() {
        if (grounded && canJump) {
            velocity.y = JUMP_VELOCITY;
            grounded = false;
        }
    }

    public void emitEcho() {
        // TODO: Emit echo for sound-based navigation
    }

    // Getters and setters
    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }
}
