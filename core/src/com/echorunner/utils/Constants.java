package com.echorunner.utils;

/**
 * Game constants and configuration values
 */
public class Constants {
    // Screen dimensions
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    public static final String GAME_TITLE = "Echo Runner";
    
    // Physics constants
    public static final float GRAVITY = -980f;
    public static final float TERMINAL_VELOCITY = -500f;
    
    // Player constants
    public static final float PLAYER_WIDTH = 32f;
    public static final float PLAYER_HEIGHT = 32f;
    public static final float PLAYER_SPEED = 200f;
    public static final float PLAYER_JUMP_FORCE = 500f;
    
    // Echo constants
    public static final float ECHO_INITIAL_RADIUS = 10f;
    public static final float ECHO_EXPANSION_RATE = 200f;
    public static final float ECHO_MAX_RADIUS = 500f;
    public static final float ECHO_COOLDOWN = 0.5f;
    
    // Tile constants
    public static final int TILE_SIZE = 32;
    
    // Level constants
    public static final int MAX_LEVELS = 10;
    public static final String LEVELS_PATH = "levels/";
    
    // Audio constants
    public static final float DEFAULT_SOUND_VOLUME = 1.0f;
    public static final float DEFAULT_MUSIC_VOLUME = 0.7f;
    
    // Debug
    public static final boolean DEBUG_MODE = true;
    public static final boolean SHOW_COLLISION_BOXES = true;
    
    private Constants() {
        // Prevent instantiation
    }
}
