package io.github.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.game.util.V2;

public abstract class Entity {
    private V2 p;
    private V2 scale;
    private Texture texture;

    public enum EntityType {PLAYER, ENEMY}

    public Entity(Texture texture, V2 p, V2 scale) {
        this.p = new V2(p.x, p.y);
        this.scale = scale;
        this.texture = texture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, p.x, p.y, scale.x, scale.y);
    }

    public abstract EntityType type();

    void update() {
    }
}
