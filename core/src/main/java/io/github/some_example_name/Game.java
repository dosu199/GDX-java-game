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

public class Game extends ApplicationAdapter {
    private final Vector2 mousePosition = new Vector2();
    private FitViewport viewport;
    private SpriteBatch batch;
    private Player player;
    private Enemy enemy;
    private BitmapFont font;
    private EntityManager entityMgr;

    public Game() {
        this.entityMgr = new EntityManager();
    }

    public void processInput() {
        mousePosition.set(0.0f, 0.0f);
        if (Gdx.input.isTouched()) {
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY()); // Get where the touch happened on screen
            viewport.unproject(mousePosition); // Convert the units to the world units of the viewport
        }
    }

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setLineHeight(1);
        viewport = new FitViewport(800, 500);
    }
//
//    public void update() {
//        this.entityMgr.getEntities().forEach(entity -> {
//            entity.update();
//            entity.render();
//        });
//    }

    @Override
    public void render() {
        processInput();
//        step();
        draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }


    public void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        batch.setProjectionMatrix(viewport.getCamera().combined);

        System.out.println("Position: (" + mousePosition.x + ", " + mousePosition.y + ")");
        System.out.println(entityMgr.getPlayer().getPlayerTexture());
        batch.begin();
        batch.draw(entityMgr.getPlayer().getPlayerTexture(), 100, 100, 100, 100);
        batch.draw(entityMgr.getEnemy().getEnemyTexture(), 600, 100, 100, 100);

        // This is game logic and does not belong here
        if (mousePosition.x > 600 && mousePosition.x < 700 && mousePosition.y > 100 && mousePosition.y < 200) {
            font.draw(batch, "hit", mousePosition.x, mousePosition.y);
        }

        batch.end();
    }
}
