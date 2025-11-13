package com.celestlike.game.celeste_like_game.input;

// Input is separated from gameplay logic.
// You can later implement a Command pattern here.
public interface InputHandler {
    void pollInput();
}
