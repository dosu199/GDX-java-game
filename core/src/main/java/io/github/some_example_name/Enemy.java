package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;

public class Enemy implements Entity {
    private int posX;
    private int posY;
    private final Texture enemyTexture;


    public Enemy(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.enemyTexture = new Texture("enemy.png");
    }

    public Texture getEnemyTexture() {
        return enemyTexture;
    }

    public void render() {

    }
    public void update() {

    }
}
