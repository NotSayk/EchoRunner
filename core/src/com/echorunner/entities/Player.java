package com.echorunner.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.echorunner.input.InputHandler;
import com.echorunner.input.InputTuple;
import com.echorunner.input.InputTuple.InputState;
import com.echorunner.logic.ActionHandler;
import com.echorunner.ui.TextureHandler;
import com.echorunner.utils.ActionGroup;

/**
 * Player entity controlled by the user
 */
public class Player extends Entity {
    private static final float PLAYER_WIDTH = 32f;
    private static final float PLAYER_HEIGHT = 32f;
    private static final float MOVE_SPEED = 200f;
    private static final float JUMP_VELOCITY = 500f;
    private boolean canDoubleJump;

    private TextureHandler textureHandler;
    private boolean grounded;
    private boolean canJump;

    /*
     * enum des déplacements
     */

    private enum Movement implements ActionGroup {
        LEFT,
        RIGHT,
        JUMP,
        STOP
    }

    public Player(float x, float y) {
        super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.grounded = false;
        this.canJump = true;
        this.canDoubleJump=false;
        this.textureHandler = new TextureHandler("Main Characters/Pink Man/Idle (32x32).png");
        inputHandling();
    }

    private void inputHandling() {
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.A , InputState.DOWN), Movement.LEFT);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.A, InputState.UP), Movement.STOP);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.D, InputState.DOWN), Movement.RIGHT);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.D, InputState.UP), Movement.STOP);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.LEFT , InputState.DOWN), Movement.LEFT);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.LEFT, InputState.UP), Movement.STOP);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.RIGHT, InputState.DOWN), Movement.RIGHT);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.RIGHT, InputState.UP), Movement.STOP);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.UP, InputState.DOWN), Movement.JUMP);
        InputHandler.registerKeyBind(new InputTuple(Input.Keys.SPACE, InputState.DOWN), Movement.JUMP);
        ActionHandler.registerAction(Movement.LEFT, () -> moveLeft());
        ActionHandler.registerAction(Movement.RIGHT, () -> moveRight());
        ActionHandler.registerAction(Movement.STOP, () -> stopMoving());
        ActionHandler.registerAction(Movement.JUMP, () -> jump());
    }

    @Override
    public void update(float delta) {
        textureHandler.update(delta);
        if (!grounded) {
            velocity.y -= GRAVITY * delta;
        }

        if (position.x < 0) {
            position.x = 0;
        }
        if (position.x > Gdx.graphics.getWidth() - PLAYER_WIDTH) {
            position.x = Gdx.graphics.getWidth() - PLAYER_WIDTH;
        }

        position.add(velocity.x * delta, velocity.y * delta);

        if (position.y <= 10) {
            position.y = 10;
            grounded = true;
            canJump = true;
            velocity.y = 0;

            if (velocity.x != 0) {
                textureHandler.changeSprite("Main Characters/Pink Man/Run (32x32).png", velocity.x < 0);
            } else {
                textureHandler.changeSprite("Main Characters/Pink Man/Idle (32x32).png");
            }
        } else {
            grounded = false;
            if (velocity.y > 0&& canDoubleJump == true) {
                textureHandler.changeSprite("Main Characters/Pink Man/Jump (32x32).png");
            }
            if(velocity.y > 0&& canDoubleJump == false){
                textureHandler.changeSprite("Main Characters/Pink Man/Double Jump (32x32).png");
            }
             else {
                textureHandler.changeSprite("Main Characters/Pink Man/Fall (32x32).png");
            }
        }

        updateBounds();
    }

    @Override
    public void render(SpriteBatch batch) {
        textureHandler.render(batch, position.x, position.y);
    }

    public void moveLeft() {
        textureHandler.changeSprite("Main Characters/Pink Man/Run (32x32).png", true);
        velocity.x = -MOVE_SPEED;
    }

    public void moveRight() {
        textureHandler.changeSprite("Main Characters/Pink Man/Run (32x32).png", false);
        velocity.x = MOVE_SPEED;
    }

    public void stopMoving() {
        if (Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            moveLeft();
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight();
        } else {
            textureHandler.changeSprite("Main Characters/Pink Man/Idle (32x32).png");
            velocity.x = 0;
        }
    }


    public void jump() {
        if (grounded && canJump) {
            velocity.y = JUMP_VELOCITY;
            grounded = false;
            canJump = false;
            canDoubleJump=true;
        }
        else if (!grounded && !canJump && canDoubleJump){
            velocity.y = JUMP_VELOCITY;
            grounded = false;
            canJump = false;
            canDoubleJump= false;
        }
    }

    public void emitEcho() {
    }

    public void setHit() {
    }

    public boolean isGrounded() {
        return grounded;
    }

    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }
}
