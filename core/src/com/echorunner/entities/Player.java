package com.echorunner.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.echorunner.ui.TextureHandler;

/**
 * Player entity controlled by the user
 */
public class Player extends Entity {
    private static final float PLAYER_WIDTH = 32f;
    private static final float PLAYER_HEIGHT = 32f;
    private static final float MOVE_SPEED = 200f;
    private static final float JUMP_VELOCITY = 500f;
    private TextureHandler textureHandler;

    private boolean grounded;
    private boolean canJump;

    public Player(float x, float y) {
        super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.grounded = false;
        this.canJump = true;
        this.textureHandler = new TextureHandler("Main Characters/Pink Man/Idle (32x32).png");
    }

    @Override
    public void update(float delta) {
        textureHandler.update(delta);
        position.add(velocity.x * delta, velocity.y * delta);
        updateBounds();
    }

    @Override
    public void render(SpriteBatch batch) {
        textureHandler.render(batch, position.x, position.y);
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
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }
}
