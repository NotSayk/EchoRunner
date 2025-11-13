package com.echorunner.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.echorunner.Main;

/**
 * Level selection screen
 */
public class LevelSelectScreen implements Screen {
    private final Main game;
    private OrthographicCamera camera;
    private Stage stage;

    public LevelSelectScreen(Main game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 600);
        
        stage = new Stage(new FitViewport(800, 600, camera));
        Gdx.input.setInputProcessor(stage);
        
        setupUI();
    }

    private void setupUI() {
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        
        // TODO: Add level selection buttons
    }

    @Override
    public void show() {
        Gdx.app.log("LevelSelectScreen", "Showing level selection");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        stage.dispose();
    }
}
