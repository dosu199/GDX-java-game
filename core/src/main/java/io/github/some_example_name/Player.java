package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;

public class Player implements Entity {
    private int posX;
    private int posY;
    private final Texture playerTexture;

    public Player(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.playerTexture = new Texture("player.png");
    }

    public void render() {

    }
    public void update() {

    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Texture getPlayerTexture() {
        return playerTexture;
    }
}
