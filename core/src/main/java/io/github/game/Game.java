package io.github.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.game.entity.EntityManager;
import io.github.game.input.Input;
import io.github.game.renderer.Render;

public class Game {
    private FitViewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;
    private EntityManager entityManager;
    private Render render;
    private Input input;

    public void resize(int width, int height) {
        render.resize(width, height);
    }

    public void create() {
        batch = new SpriteBatch();
        entityManager = new EntityManager();
        font = new BitmapFont();
        font.getData().setLineHeight(1);
        viewport = new FitViewport(800, 500);
        render = new Render(viewport, batch);
        input = new Input();
    }

    public void render() {
        input.processInput(viewport, batch, font);
//        step();
        render.draw(entityManager.getAllEntities());
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        entityManager.getTextures().forEach((key, value) -> value.dispose());
    }
}
