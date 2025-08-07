package io.github.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.game.Enums.EntityType;
import io.github.game.util.V2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class EntityManager {
    private ArrayList<Entity> entities;
    public int playerIndex = -1;
    public HashMap<EntityType, Texture> textures;

    public EntityManager() {
        textures = new HashMap<>();
        textures.put(EntityType.PLAYER, new Texture(Gdx.files.internal("player.png")));
        textures.put(EntityType.ENEMY, new Texture(Gdx.files.internal("enemy.png")));

        this.entities = new ArrayList<>();
        addEntity(new Player(textures.get(EntityType.PLAYER), new V2(100.0F, 100.00F), new V2(100.0F, 100.0F)));
        this.playerIndex = 0;
        addEntity(new Enemy(textures.get(EntityType.ENEMY), new V2(600.0F, 100.00F), new V2(100.0F, 100.0F)));
    }

    public void addEntity(Entity entity) {
        Objects.requireNonNull(this.entities).add(entity);
    }

    public Player getPlayer() {
        return (Player) entities.get(playerIndex);
    }

    public HashMap<EntityType, Texture> getTextures() {
        return textures;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
