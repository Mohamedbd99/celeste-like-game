package com.celestlike.game.celeste_like_game.gameplay.player;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;

// Favor composition: Player HAS combat stats & position data.
public class Player {

    private final CombatStats combatStats;

    private float x;
    private float y;

    public Player(CombatStats combatStats, float startX, float startY) {
        this.combatStats = combatStats;
        this.x = startX;
        this.y = startY;
    }

    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    public void jump() {
        // TODO: later add vertical velocity / gravity
    }

    public void dash() {
        // TODO: later add dash mechanic
    }

    public void attack() {
        // TODO: later connect to combat system
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
