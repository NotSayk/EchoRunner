package com.echorunner.audio;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * Manages all game audio (sounds and music)
 */
public class SoundManager implements Disposable {
    private ObjectMap<String, Sound> sounds;
    private ObjectMap<String, Music> music;
    
    private float soundVolume;
    private float musicVolume;
    private boolean soundEnabled;
    private boolean musicEnabled;

    public SoundManager() {
        sounds = new ObjectMap<>();
        music = new ObjectMap<>();
        soundVolume = 1.0f;
        musicVolume = 0.7f;
        soundEnabled = true;
        musicEnabled = true;
    }

    public void loadSound(String name, Sound sound) {
        sounds.put(name, sound);
    }

    public void loadMusic(String name, Music musicTrack) {
        music.put(name, musicTrack);
    }

    public void playSound(String name) {
        if (soundEnabled && sounds.containsKey(name)) {
            sounds.get(name).play(soundVolume);
        }
    }

    public void playMusic(String name, boolean looping) {
        if (musicEnabled && music.containsKey(name)) {
            Music track = music.get(name);
            track.setLooping(looping);
            track.setVolume(musicVolume);
            track.play();
        }
    }

    public void stopMusic(String name) {
        if (music.containsKey(name)) {
            music.get(name).stop();
        }
    }

    public void stopAllMusic() {
        for (Music track : music.values()) {
            track.stop();
        }
    }

    // Getters and setters
    public void setSoundVolume(float volume) {
        this.soundVolume = Math.max(0f, Math.min(1f, volume));
    }

    public void setMusicVolume(float volume) {
        this.musicVolume = Math.max(0f, Math.min(1f, volume));
        for (Music track : music.values()) {
            track.setVolume(this.musicVolume);
        }
    }

    public void setSoundEnabled(boolean enabled) {
        this.soundEnabled = enabled;
    }

    public void setMusicEnabled(boolean enabled) {
        this.musicEnabled = enabled;
        if (!enabled) {
            stopAllMusic();
        }
    }

    @Override
    public void dispose() {
        for (Sound sound : sounds.values()) {
            sound.dispose();
        }
        for (Music track : music.values()) {
            track.dispose();
        }
        sounds.clear();
        music.clear();
    }
}
