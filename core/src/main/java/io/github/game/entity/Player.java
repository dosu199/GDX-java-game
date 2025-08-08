package io.github.game.entity;

import com.badlogic.gdx.graphics.Texture;
import io.github.game.util.V2;

public class Player extends Entity {
    public Player(Texture texture, V2 p, V2 scale) {
        super(texture, p, scale);
    }

    public void update() {
    }

    @Override
    public EntityType type() {
        return EntityType.PLAYER;
    }
}
