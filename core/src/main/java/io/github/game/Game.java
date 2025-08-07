package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.game.entity.EntityManager;
import io.github.game.renderer.Render;

public class Game {
    private final Vector2 mousePosition = new Vector2();
    private FitViewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;
    private EntityManager entityManager;
    private Render render;

    public void resize(int width, int height) {
        render.resize(width, height);
    }

    public void processInput() {
        mousePosition.set(0.0f, 0.0f);
        if (Gdx.input.isTouched()) {
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY()); // Get where the touch happened on screen
            viewport.unproject(mousePosition); // Convert the units to the world units of the viewport
        }
    }

    public void create() {
        batch = new SpriteBatch();
        entityManager = new EntityManager();
        font = new BitmapFont();
        font.getData().setLineHeight(1);
        viewport = new FitViewport(800, 500);
        render = new Render(viewport, batch, entityManager);
    }

    public void render() {
        processInput();
//        step();
        render.draw();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        entityManager.getTextures().forEach((key, value) -> value.dispose());
    }
}
