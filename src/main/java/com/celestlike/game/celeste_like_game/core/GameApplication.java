package com.celestlike.game.celeste_like_game.core;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;
import com.celestlike.game.celeste_like_game.gameplay.player.Player;
import com.celestlike.game.celeste_like_game.input.KeyboardInputHandler;
import com.celestlike.game.celeste_like_game.ui.GameWindow;

public class GameApplication {

    public static void main(String[] args) {
        // For now, skip menus and jump straight into playing

        CombatStats stats = new CombatStats(100, 10, 2);
        Player player = new Player(stats, 100f, 460f); // starting position

        GameWindow window = new GameWindow(player);
        window.setVisible(true);

        KeyboardInputHandler input = window.getInputHandler();

        gameLoop(player, window, input);
    }

    private static void gameLoop(Player player, GameWindow window, KeyboardInputHandler input) {
        boolean running = true;
        long lastTime = System.nanoTime();

        final float moveSpeed = 200f; // pixels per second (tweak to feel good)

        while (running) {
            long now = System.nanoTime();
            float deltaTime = (now - lastTime) / 1_000_000_000.0f;
            lastTime = now;

            float dx = 0f;
            float dy = 0f;

            if (input.isLeftPressed()) {
                dx -= moveSpeed * deltaTime;
            }
            if (input.isRightPressed()) {
                dx += moveSpeed * deltaTime;
            }
            if (input.isUpPressed()) {
                dy -= moveSpeed * deltaTime;
            }
            if (input.isDownPressed()) {
                dy += moveSpeed * deltaTime;
            }

            // Basic movement; later add physics + collisions
            player.move(dx, dy);

            // Redraw
            window.redraw();

            // Simple fixed-ish timestep
            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }
}
