package io.github.some_example_name;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface Entity {
   void draw(SpriteBatch batch);
   void update();
}
