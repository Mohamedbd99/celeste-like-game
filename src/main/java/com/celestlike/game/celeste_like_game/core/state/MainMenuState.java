package com.celestlike.game.celeste_like_game.core.state;

public class MainMenuState implements GameState {

    private final GameStateContext context;

    public MainMenuState(GameStateContext context) {
        this.context = context;
    }

    @Override
    public void enter() {
        // TODO: show menu UI
    }

    @Override
    public void update(float deltaTime) {
        // TODO: handle menu navigation and transition to PlayingState
    }

    @Override
    public void exit() {
        // TODO: hide menu UI
    }
}
