package com.celestlike.game.celeste_like_game.world.level;

// Composite base for level elements (platforms, obstacles, groups, etc.)
public interface LevelNode {
    void update(float deltaTime);
}
