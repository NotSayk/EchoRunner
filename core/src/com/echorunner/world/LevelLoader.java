package com.echorunner.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

/**
 * Loads levels from file
 */
public class LevelLoader {
    private Json json;

    public LevelLoader() {
        this.json = new Json();
    }

    public Level loadLevel(String levelPath) {
        try {
            FileHandle file = Gdx.files.internal(levelPath);
            if (!file.exists()) {
                Gdx.app.error("LevelLoader", "Level file not found: " + levelPath);
                return createDefaultLevel();
            }

            // TODO: Parse level data from file
            return parseLevel(file.readString());
        } catch (Exception e) {
            Gdx.app.error("LevelLoader", "Error loading level: " + levelPath, e);
            return createDefaultLevel();
        }
    }

    private Level parseLevel(String data) {
        // TODO: Parse JSON or custom format
        Level level = new Level("Test Level", 1);
        return level;
    }

    public Level loadLevelByNumber(int levelNumber) {
        String path = "levels/level_" + levelNumber + ".json";
        return loadLevel(path);
    }

    public Array<String> getAvailableLevels() {
        Array<String> levels = new Array<>();
        // TODO: Scan levels directory
        return levels;
    }

    private Level createDefaultLevel() {
        Gdx.app.log("LevelLoader", "Creating default level");
        Level level = new Level("Default Level", 0);
        
        // TODO: Add some default tiles
        for (int x = 0; x < 20; x++) {
            level.addTile(new Tile(x * 32, 0, 32, 32, Tile.TileType.SOLID));
        }
        
        return level;
    }

    public void saveLevel(Level level, String path) {
        // TODO: Serialize and save level
        try {
            String data = json.toJson(level);
            FileHandle file = Gdx.files.local(path);
            file.writeString(data, false);
            Gdx.app.log("LevelLoader", "Level saved: " + path);
        } catch (Exception e) {
            Gdx.app.error("LevelLoader", "Error saving level: " + path, e);
        }
    }
}
