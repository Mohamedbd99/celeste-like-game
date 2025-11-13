package com.celestlike.game.celeste_like_game.gameplay.enemy;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;

// Base enemy type. Keep inheritance depth shallow.
public abstract class Enemy {

    protected final CombatStats combatStats;

    protected Enemy(CombatStats combatStats) {
        this.combatStats = combatStats;
    }

    public abstract void update(float deltaTime);

    public CombatStats getCombatStats() {
        return combatStats;
    }
}
