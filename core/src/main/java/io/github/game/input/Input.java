package io.github.game.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Input {
    private final Vector2 mousePosition = new Vector2();

    public void processInput(FitViewport viewport, SpriteBatch batch, BitmapFont font) {
        mousePosition.set(0.0f, 0.0f);
        if (Gdx.input.isTouched()) {
            mousePosition.set(Gdx.input.getX(), Gdx.input.getY()); // Get where the touch happened on screen
            viewport.unproject(mousePosition); // Convert the units to the world units of the viewport
            System.out.println("Position: (" + mousePosition.x + ", " + mousePosition.y + ")");
        }
    }
}
