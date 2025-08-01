package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Enemy implements Entity {
    private int posX;
    private int posY;
    private final int width;
    private final int height;
    private Texture enemyTexture;


    public Enemy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.width = 100;
        this.height = 100;
    }

    public Texture createTexture() {
        this.enemyTexture = new Texture(Gdx.files.internal("enemy.png"));
        return this.enemyTexture;
    }

    public Texture getEnemyTexture() {
        return enemyTexture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(enemyTexture, posX, posY, width, height);

    }

    public void update() {

    }
}
