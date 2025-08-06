package io.github.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import io.github.game.util.V2;

import java.util.ArrayList;
import java.util.Objects;

public class EntityManager {
    private ArrayList<Entity> entities;
    public int playerIndex = -1;

    public EntityManager() {
        this.entities = new ArrayList<>();
        addEntity(new Player(new Texture(Gdx.files.internal("player.png")), new V2(100.0F, 100.00F), new V2(100.0F, 100.0F)));
        this.playerIndex = 0;
        addEntity(new Enemy(new Texture(Gdx.files.internal("enemy.png")), new V2(600.0F, 100.00F), new V2(100.0F, 100.0F)));
    }

    public void addEntity(Entity entity) {
        Objects.requireNonNull(this.entities).add(entity);
    }

    public Player getPlayer() {
       return (Player) entities.get(playerIndex);
    }

//    public Enemy getEnemy() {
//        return enemy;
//    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
