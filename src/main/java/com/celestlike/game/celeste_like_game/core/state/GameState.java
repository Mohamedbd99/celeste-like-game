package com.celestlike.game.celeste_like_game.core.state;

public interface GameState {
    void enter();
    void update(float deltaTime);
    void exit();
}
