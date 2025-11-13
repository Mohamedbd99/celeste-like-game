package com.celestlike.game.celeste_like_game.core.state;

public class GameStateContext {

    private GameState currentState;

    public void changeState(GameState newState) {
        if (currentState != null) {
            currentState.exit();
        }
        this.currentState = newState;
        if (currentState != null) {
            currentState.enter();
        }
    }

    public void update(float deltaTime) {
        if (currentState != null) {
            currentState.update(deltaTime);
        }
    }
}
