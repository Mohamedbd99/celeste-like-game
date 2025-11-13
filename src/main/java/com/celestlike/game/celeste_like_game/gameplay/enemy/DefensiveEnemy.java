package com.celestlike.game.celeste_like_game.gameplay.enemy;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;

// Example enemy type focusing on blocking/defense.
public class DefensiveEnemy extends Enemy {

    public DefensiveEnemy(CombatStats combatStats) {
        super(combatStats);
    }

    @Override
    public void update(float deltaTime) {
        // TODO: patrol and defend, maybe counter-attack
    }
}
