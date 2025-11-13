package com.celestlike.game.celeste_like_game.core.state;

public class PlayingState implements GameState {

    private final GameStateContext context;

    public PlayingState(GameStateContext context) {
        this.context = context;
    }

    @Override
    public void enter() {
        // TODO: initialize level, player, enemies, HUD
    }

    @Override
    public void update(float deltaTime) {
        // TODO: update gameplay systems, detect pause/game over, etc.
    }

    @Override
    public void exit() {
        // TODO: clean up or save progress if needed
    }
}
