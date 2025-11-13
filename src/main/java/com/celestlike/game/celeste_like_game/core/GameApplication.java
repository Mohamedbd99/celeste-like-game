package com.celestlike.game.celeste_like_game.core;

import com.celestlike.game.celeste_like_game.core.state.GameStateContext;

public class GameApplication {

    public static void main(String[] args) {
        // TODO: load config, initialize logging, create window/renderer, etc.
        GameStateContext gameStateContext = new GameStateContext();
        // TODO: set initial state to MainMenuState
        // gameStateContext.changeState(new MainMenuState(gameStateContext));
        gameLoop(gameStateContext);
    }

    private static void gameLoop(GameStateContext context) {
        boolean running = true;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            float deltaTime = (now - lastTime) / 1_000_000_000.0f;
            lastTime = now;

            // TODO: poll input & dispatch to systems (do NOT hard-wire input here)
            // TODO: update game state via context.update(deltaTime)
            // TODO: render via renderer (separate class)
        }
    }
}
