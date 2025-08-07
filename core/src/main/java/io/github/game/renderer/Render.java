package io.github.game.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.game.entity.EntityManager;

public class Render {
    private FitViewport viewport;
    private SpriteBatch batch;
    private EntityManager entityManager;

    public Render(FitViewport viewport, SpriteBatch batch, EntityManager entityManager) {
        this.viewport = viewport;
        this.batch = batch;
        this.entityManager = entityManager;
    }


    public void resize(int width, int height) {
        // Resizing will screw up our logic
        viewport.update(width, height, true);
    }

    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);


        batch.begin();
        entityManager.getEntities().forEach(entity ->
            batch.draw(entity.getTexture(), entity.getP().x, entity.getP().y, entity.getScale().x, entity.getScale().y));

        // This is game logic and does not belong here
//        if (mousePosition.x > 600 && mousePosition.x < 700 && mousePosition.y > 100 && mousePosition.y < 200) {
//            font.draw(batch, "hit", mousePosition.x, mousePosition.y);
//        }

        batch.end();
    }
}
