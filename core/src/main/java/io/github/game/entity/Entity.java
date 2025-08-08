package io.github.game.entity;

import com.badlogic.gdx.graphics.Texture;
import io.github.game.util.V2;

public abstract class Entity {
    private V2 p;
    private V2 scale;
    private Texture texture;


    public Entity(Texture texture, V2 p, V2 scale) {
        this.p = new V2(p.x, p.y);
        this.scale = scale;
        this.texture = texture;
    }


    public V2 getP() {
        return p;
    }

    public V2 getScale() {
        return scale;
    }

    public Texture getTexture() {
        return texture;
    }

    public abstract EntityType type();

    void update() {
    }
}
