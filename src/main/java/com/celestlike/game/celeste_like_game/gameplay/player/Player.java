package com.celestlike.game.celeste_like_game.gameplay.player;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;

// Favor composition over inheritance: Player has components.
public class Player {

    private final CombatStats combatStats;

    public Player(CombatStats combatStats) {
        this.combatStats = combatStats;
    }

    public void move(float dx, float dy) {
        // TODO: apply movement logic (separate from rendering)
    }

    public void jump() {
        // TODO: jump logic
    }

    public void dash() {
        // TODO: dash logic
    }

    public void attack() {
        // delegate to combat / weapon system
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }
}
