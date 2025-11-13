package com.celestlike.game.celeste_like_game.core;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;
import com.celestlike.game.celeste_like_game.gameplay.player.Player;
import com.celestlike.game.celeste_like_game.input.KeyboardInputHandler;
import com.celestlike.game.celeste_like_game.ui.GameWindow;

public class GameApplication {

    public static void main(String[] args) {
        // TODO: later use game states (MainMenuState, PlayingState, etc.)

        CombatStats stats = new CombatStats(100, 10, 2);
        // Start above the ground (GROUND_Y = 460 in Player)
        Player player = new Player(stats, 100f, 460f);

        GameWindow window = new GameWindow(player);
        window.setVisible(true);

        KeyboardInputHandler input = window.getInputHandler();

        gameLoop(player, window, input);
    }

    private static void gameLoop(Player player,
                                 GameWindow window,
                                 KeyboardInputHandler input) {

        boolean running = true;
        long lastTime = System.nanoTime();

        while (running) {
            long now = System.nanoTime();
            float deltaTime = (now - lastTime) / 1_000_000_000.0f;
            lastTime = now;

            // Build input axes from keyboard state
            float inputX = 0f;
            float inputY = 0f;

            if (input.isLeftPressed()) {
                inputX -= 1f;
            }
            if (input.isRightPressed()) {
                inputX += 1f;
            }
            if (input.isUpPressed()) {
                inputY -= 1f;
            }
            if (input.isDownPressed()) {
                inputY += 1f;
            }

            boolean jumpPressed = input.isJumpPressed();
            boolean dashPressed = input.isDashPressed();

            // Update player with physics
            player.update(deltaTime, inputX, inputY, jumpPressed, dashPressed);

            // Redraw frame
            window.redraw();

            // ~60 FPS
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }
    }
}
