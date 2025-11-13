package com.celestlike.game.celeste_like_game.gameplay.enemy;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;

// Example enemy type with its own behavior (Strategy/State later).
public class AggressiveEnemy extends Enemy {

    public AggressiveEnemy(CombatStats combatStats) {
        super(combatStats);
    }

    @Override
    public void update(float deltaTime) {
        // TODO: chase player and attack aggressively
    }
}
