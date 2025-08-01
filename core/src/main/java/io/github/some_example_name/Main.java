package io.github.some_example_name;

import com.badlogic.gdx.ApplicationAdapter;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms.
 */
public class Main extends ApplicationAdapter {
    Game game = new Game();

    @Override
    public void create() {
        game.create();
    }

    @Override
    public void render() {
        game.render();
    }

    @Override
    public void resize(int width, int height) {
        game.resize(width, height);
    }

    @Override
    public void dispose() {
        game.dispose();
    }

    private void step() {
        // Update game logic here
    }
}

