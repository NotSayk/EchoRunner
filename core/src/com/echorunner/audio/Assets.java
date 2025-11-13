package com.echorunner.audio;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Asset management and loading
 */
public class Assets {
    private AssetManager assetManager;
    
    // Asset paths
    public static final String TEXTURE_ATLAS = "textures/game.atlas";
    
    // Sound paths
    public static final String SOUND_JUMP = "sounds/jump.wav";
    public static final String SOUND_ECHO = "sounds/echo.wav";
    public static final String SOUND_DOOR_OPEN = "sounds/door_open.wav";
    public static final String SOUND_SWITCH = "sounds/switch.wav";
    
    // Music paths
    public static final String MUSIC_MENU = "music/menu.mp3";
    public static final String MUSIC_GAME = "music/game.mp3";
    
    // Texture paths
    public static final String TEXTURE_PLAYER = "textures/player.png";
    public static final String TEXTURE_TILE = "textures/tile.png";

    public Assets() {
        assetManager = new AssetManager();
    }

    public void loadAll() {
        // TODO: Load all assets
        loadSounds();
        loadMusic();
        loadTextures();
    }

    private void loadSounds() {
        // TODO: Load sound files when they exist
        // assetManager.load(SOUND_JUMP, Sound.class);
        // assetManager.load(SOUND_ECHO, Sound.class);
        // assetManager.load(SOUND_DOOR_OPEN, Sound.class);
        // assetManager.load(SOUND_SWITCH, Sound.class);
    }

    private void loadMusic() {
        // TODO: Load music files when they exist
        // assetManager.load(MUSIC_MENU, Music.class);
        // assetManager.load(MUSIC_GAME, Music.class);
    }

    private void loadTextures() {
        // TODO: Load textures when they exist
        // assetManager.load(TEXTURE_ATLAS, TextureAtlas.class);
        // assetManager.load(TEXTURE_PLAYER, Texture.class);
        // assetManager.load(TEXTURE_TILE, Texture.class);
    }

    public void finishLoading() {
        assetManager.finishLoading();
    }

    public boolean update() {
        return assetManager.update();
    }

    public float getProgress() {
        return assetManager.getProgress();
    }

    // Asset getters
    public Sound getSound(String path) {
        return assetManager.get(path, Sound.class);
    }

    public Music getMusic(String path) {
        return assetManager.get(path, Music.class);
    }

    public Texture getTexture(String path) {
        return assetManager.get(path, Texture.class);
    }

    public TextureAtlas getAtlas(String path) {
        return assetManager.get(path, TextureAtlas.class);
    }

    public void dispose() {
        assetManager.dispose();
    }
}
