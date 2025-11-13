package com.celestlike.game.celeste_like_game.ui;

import com.celestlike.game.celeste_like_game.gameplay.player.Player;
import com.celestlike.game.celeste_like_game.input.KeyboardInputHandler;

import javax.swing.*;

public class GameWindow extends JFrame {

    private final GamePanel panel;
    private final KeyboardInputHandler inputHandler;

    public GameWindow(Player player) {
        super("Celeste-like Game");

        this.inputHandler = new KeyboardInputHandler();
        this.panel = new GamePanel(player);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(800, 600);

        add(panel);
        addKeyListener(inputHandler);

        setLocationRelativeTo(null); // center
    }

    public KeyboardInputHandler getInputHandler() {
        return inputHandler;
    }

    public void redraw() {
        panel.repaint();
    }
}
