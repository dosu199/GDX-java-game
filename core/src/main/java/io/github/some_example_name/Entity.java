package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
    private V2 p;
    private V2 scale;
    private Texture texture;

    public Entity(String textureLocation, V2 p, V2 scale) {
        this.p = new V2(p.x, p.y);
        this.scale = scale;
        this.texture = new Texture(Gdx.files.internal(textureLocation));
    }

    void draw(SpriteBatch batch) {
        batch.draw(texture, p.x, p.y, scale.x, scale.y);
    }

    void update() {
    }
}
