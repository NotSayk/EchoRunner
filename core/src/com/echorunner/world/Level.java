package com.echorunner.world;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

/**
 * Represents a game level
 */
public class Level implements Disposable {
    private String levelName;
    private int levelNumber;
    private Array<Tile> tiles;
    private Array<Door> doors;
    private Array<Switch> switches;
    
    private int width;
    private int height;
    private boolean completed;

    public Level(String levelName, int levelNumber) {
        this.levelName = levelName;
        this.levelNumber = levelNumber;
        this.tiles = new Array<>();
        this.doors = new Array<>();
        this.switches = new Array<>();
        this.completed = false;
    }

    public void update(float delta) {
        // TODO: Update level objects
        for (Door door : doors) {
            door.update(delta);
        }
        for (Switch switchObj : switches) {
            switchObj.update(delta);
        }
    }

    public void render(SpriteBatch batch) {
        // TODO: Render level elements
        for (Tile tile : tiles) {
            tile.render(batch);
        }
        for (Door door : doors) {
            door.render(batch);
        }
        for (Switch switchObj : switches) {
            switchObj.render(batch);
        }
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    public void addDoor(Door door) {
        doors.add(door);
    }

    public void addSwitch(Switch switchObj) {
        switches.add(switchObj);
    }

    // Getters and setters
    public String getLevelName() {
        return levelName;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public Array<Tile> getTiles() {
        return tiles;
    }

    public Array<Door> getDoors() {
        return doors;
    }

    public Array<Switch> getSwitches() {
        return switches;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public void dispose() {
        // TODO: Dispose level resources
        tiles.clear();
        doors.clear();
        switches.clear();
    }
}
