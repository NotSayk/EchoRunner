package com.echorunner.ui;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Heads-Up Display for showing game information
 */
public class HUD implements Disposable {
    private Stage stage;
    private Viewport viewport;
    
    private Label levelLabel;
    private Label scoreLabel;
    private Label timerLabel;
    private Label echoCountLabel;
    
    private int score;
    private float timeElapsed;
    private int echoCount;
    private String levelName;

    public HUD(SpriteBatch batch) {
        viewport = new FitViewport(800, 600, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        
        score = 0;
        timeElapsed = 0f;
        echoCount = 0;
        levelName = "Level 1";
        
        setupUI();
    }

    private void setupUI() {
        Table table = new Table();
        table.top();
        table.setFillParent(true);
        
        // TODO: Create labels with proper styling
        levelLabel = new Label(levelName, new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        scoreLabel = new Label("Score: " + score, new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        timerLabel = new Label("Time: 0:00", new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        echoCountLabel = new Label("Echos: " + echoCount, new Label.LabelStyle(new BitmapFont(), com.badlogic.gdx.graphics.Color.WHITE));
        
        table.add(levelLabel).expandX().padTop(10);
        table.add(scoreLabel).expandX().padTop(10);
        table.add(timerLabel).expandX().padTop(10);
        table.add(echoCountLabel).expandX().padTop(10);
        
        stage.addActor(table);
    }

    public void update(float delta) {
        timeElapsed += delta;
        updateLabels();
    }

    private void updateLabels() {
        int minutes = (int)(timeElapsed / 60);
        int seconds = (int)(timeElapsed % 60);
        timerLabel.setText(String.format("Time: %d:%02d", minutes, seconds));
        scoreLabel.setText("Score: " + score);
        echoCountLabel.setText("Echos: " + echoCount);
        levelLabel.setText(levelName);
    }

    public void render() {
        stage.draw();
    }

    // Setters
    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public void setEchoCount(int count) {
        this.echoCount = count;
    }

    public void incrementEchoCount() {
        this.echoCount++;
    }

    public void setLevelName(String name) {
        this.levelName = name;
    }

    public void resetTimer() {
        this.timeElapsed = 0f;
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
