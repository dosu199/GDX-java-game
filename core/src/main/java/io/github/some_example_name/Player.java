package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player implements Entity {
    private float posX;
    private float posY;
    private final int width;
    private final int height;
    private Texture playerTexture;

    public Player(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.width = 100;
        this.height = 100;
    }

    public Texture createTexture() {
        this.playerTexture = new Texture(Gdx.files.internal("player.png"));
        return this.playerTexture;
    }


    public void draw(SpriteBatch batch) {
        batch.draw(playerTexture, posX, posY, width, height);
    }

    public void update() {

    }
}
