package io.github.some_example_name;

import java.util.ArrayList;
import java.util.Objects;

public class EntityManager {
    private ArrayList<Entity> entities;
    public int playerIndex = -1;

    public EntityManager() {
        this.entities = new ArrayList<>();
        addEntity(new Player("player.png", new V2(100.0F, 100.00F), new V2(100.0F, 100.0F)));
        this.playerIndex = 0;
        addEntity(new Enemy("enemy.png", new V2(600.0F, 100.00F), new V2(100.0F, 100.0F)));
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
