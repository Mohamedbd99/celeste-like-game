package com.celestlike.game.celeste_like_game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Handles keyboard state only. No gameplay logic in here.
public class KeyboardInputHandler implements InputHandler, KeyListener {

    private volatile boolean leftPressed;
    private volatile boolean rightPressed;
    private volatile boolean upPressed;
    private volatile boolean downPressed;
    private volatile boolean jumpPressed;
    private volatile boolean dashPressed;
    private volatile boolean attackPressed;
    private volatile boolean defensePressed;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                jumpPressed = true;
                break;
            case KeyEvent.VK_SHIFT:
                dashPressed = true;
                break;
            case KeyEvent.VK_J:
                attackPressed = true;
                break;
            case KeyEvent.VK_K:
                defensePressed = true;
                break;
            default:
                // ignore
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
            case KeyEvent.VK_SPACE:
                jumpPressed = false;
                break;
            case KeyEvent.VK_SHIFT:
                dashPressed = false;
                break;
            case KeyEvent.VK_J:
                attackPressed = false;
                break;
            case KeyEvent.VK_K:
                defensePressed = false;
                break;
            default:
                // ignore
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // not used
    }

    @Override public boolean isLeftPressed() { return leftPressed; }
    @Override public boolean isRightPressed() { return rightPressed; }
    @Override public boolean isUpPressed() { return upPressed; }
    @Override public boolean isDownPressed() { return downPressed; }
    @Override public boolean isJumpPressed() { return jumpPressed; }
    @Override public boolean isDashPressed() { return dashPressed; }
    @Override public boolean isAttackPressed() { return attackPressed; }
    @Override public boolean isDefensePressed() { return defensePressed; }
}
