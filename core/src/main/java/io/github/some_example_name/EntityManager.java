package io.github.some_example_name;

import java.util.ArrayList;
import java.util.Objects;

public class EntityManager {
    private Player player;
    private Enemy enemy;
    private ArrayList<Entity> entities;


    public EntityManager() {
        this.entities = new ArrayList<>();
        this.player = new Player(100, 100);
        this.enemy = new Enemy(100, 100);
        addEntity(this.player);
        addEntity(this.enemy);
    }

    public void addEntity(Entity entity) {
        Objects.requireNonNull(this.entities).add(entity);
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }
}
