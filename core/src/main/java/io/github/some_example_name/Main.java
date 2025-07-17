package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import org.w3c.dom.Text;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture player;
    private Texture enemy;
    private BitmapFont font;
    private FitViewport viewport;
    private final Vector2 mousePosition = new Vector2();

    @Override
    public void create() {
        batch = new SpriteBatch();
        player = new Texture("player.png");
        enemy = new Texture("enemy.png");
        font = new BitmapFont();
        font.getData().setLineHeight(1);
        viewport =  new FitViewport(800, 500);
    }

    @Override
    public void render() {
        processInput();
        step();
        draw();
    }

    @Override
    public void resize(int width, int height) {
        // Resizing will screw up our logic
        viewport.update(width, height, true);
    }

    @Override
    public void dispose() {
        batch.dispose();
        player.dispose();
        enemy.dispose();
    }

    private void processInput() {
        mousePosition.set(0.0f, 0.0f);
        if (Gdx.input.isTouched()) {
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY()); // Get where the touch happened on screen
            viewport.unproject(mousePosition); // Convert the units to the world units of the viewport
        }
    }

    private void step() {
        // Update game logic here
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        System.out.println("Position: (" + mousePosition.x + ", " + mousePosition.y + ")");

        batch.begin();

        batch.draw(player, 100, 100, 100, 100);
        batch.draw(enemy, 600, 100, 100, 100);

        // This is game logic and does not belong here
        if (mousePosition.x > 600 && mousePosition.x < 700 && mousePosition.y > 100 && mousePosition.y < 200) {
            font.draw(batch, "hit", mousePosition.x, mousePosition.y);
        }

        batch.end();
    }
}
