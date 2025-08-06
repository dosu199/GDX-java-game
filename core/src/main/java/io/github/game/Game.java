package io.github.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.game.entity.EntityManager;

public class Game {
    private final Vector2 mousePosition = new Vector2();
    private FitViewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;
    private EntityManager entityManager;

    public void resize(int width, int height) {
        // Resizing will screw up our logic
        viewport.update(width, height, true);
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
    }

//    public void update() {
//        this.entityMgr.getEntities().forEach(entity -> {
//            entity.update();
//            entity.draw();
//        });
//    }

    public void render() {
        processInput();
//        step();
        draw();
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        System.out.println(mousePosition);
        System.out.println("Position: (" + mousePosition.x + ", " + mousePosition.y + ")");

        batch.begin();
        entityManager.getEntities().forEach(entity -> entity.draw(batch));

        // This is game logic and does not belong here
        if (mousePosition.x > 600 && mousePosition.x < 700 && mousePosition.y > 100 && mousePosition.y < 200) {
            font.draw(batch, "hit", mousePosition.x, mousePosition.y);
        }

        batch.end();
    }
}
