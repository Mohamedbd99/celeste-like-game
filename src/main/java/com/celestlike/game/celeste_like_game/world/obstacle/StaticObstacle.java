package com.celestlike.game.celeste_like_game.world.obstacle;

import com.celestlike.game.celeste_like_game.world.level.LevelNode;

// Simple un-moving obstacle (spikes, walls, etc.).
public class StaticObstacle implements LevelNode {

    @Override
    public void update(float deltaTime) {
        // Typically nothing; still part of composite tree.
    }
}
