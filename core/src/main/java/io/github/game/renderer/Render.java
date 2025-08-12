package io.github.game.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import io.github.game.entity.Entity;
import java.util.ArrayList;

public class Render {
    private FitViewport viewport;
    private SpriteBatch batch;

    public Render(FitViewport viewport, SpriteBatch batch) {
        this.viewport = viewport;
        this.batch = batch;
    }

    public void resize(int width, int height) {
        // Resizing will screw up our logic
        viewport.update(width, height, true);
    }

    public void draw(ArrayList<Entity> entities) {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        batch.begin();
        entities.forEach(entity ->
            batch.draw(entity.getTexture(), entity.getP().x, entity.getP().y, entity.getScale().x, entity.getScale().y));

        batch.end();
    }
}
