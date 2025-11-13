package com.celestlike.game.celeste_like_game.input;

// Pure input abstraction: no game logic here.
public interface InputHandler {
    boolean isLeftPressed();
    boolean isRightPressed();
    boolean isUpPressed();
    boolean isDownPressed();
    boolean isJumpPressed();
    boolean isDashPressed();
    boolean isAttackPressed();
    boolean isDefensePressed();
}
