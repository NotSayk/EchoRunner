package com.echorunner.input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.echorunner.entities.Player;

/**
 * Handles player input
 */
public class InputHandler extends InputAdapter {
    private final Player player;

    public InputHandler(Player player) {
        this.player = player;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
            case Input.Keys.A:
                player.moveLeft();
                return true;
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                player.moveRight();
                return true;
            case Input.Keys.SPACE:
            case Input.Keys.W:
            case Input.Keys.UP:
                player.jump();
                return true;
            case Input.Keys.E:
            case Input.Keys.ENTER:
                player.emitEcho();
                return true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
            case Input.Keys.A:
            case Input.Keys.RIGHT:
            case Input.Keys.D:
                player.stopMoving();
                return true;
        }
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        // TODO: Handle touch input for mobile
        return false;
    }
}
