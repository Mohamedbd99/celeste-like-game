package com.celestlike.game.celeste_like_game.ui;

import com.celestlike.game.celeste_like_game.gameplay.player.Player;

import javax.swing.*;
import java.awt.*;

// Draw-only: no game logic here.
public class GamePanel extends JPanel {

    private final Player player;

    public GamePanel(Player player) {
        this.player = player;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Ground
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 500, getWidth(), 100);

        // Player (simple square for now)
        int size = 40;
        int px = Math.round(player.getX());
        int py = Math.round(player.getY());
        g.setColor(Color.CYAN);
        g.fillRect(px, py, size, size);
    }
}
