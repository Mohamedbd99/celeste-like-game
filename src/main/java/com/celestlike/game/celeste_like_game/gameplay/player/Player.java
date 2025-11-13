package com.celestlike.game.celeste_like_game.gameplay.player;

import com.celestlike.game.celeste_like_game.gameplay.combat.CombatStats;

// Favor composition: Player HAS combat stats & position data.
public class Player {

    private final CombatStats combatStats;

    private float x;
    private float y;

    // Velocity
    private float vx;
    private float vy;

    // Movement / physics constants (tweak as you like)
    private static final float MOVE_SPEED = 200f;        // walk speed (px/s)
    private static final float GRAVITY = 1500f;          // gravity (px/s^2)
    private static final float MAX_FALL_SPEED = 1200f;   // terminal velocity
    private static final float JUMP_FORCE = -650f;       // jump impulse (px/s up)
    private static final float GROUND_Y = 460f;          // where player stands

    // Dash
    private static final float DASH_SPEED = 800f;        // dash speed (px/s)
    private static final float DASH_DURATION = 0.15f;    // dash time in seconds

    private boolean grounded = true;
    private boolean isDashing = false;
    private boolean canDash = true;
    private float dashTimeLeft = 0f;

    // For edge detection of inputs
    private boolean prevJumpPressed = false;
    private boolean prevDashPressed = false;

    // For default dash direction if no input (remember facing)
    private float lastFacingX = 1f; // 1 = right, -1 = left
    private float lastFacingY = 0f;

    public Player(CombatStats combatStats, float startX, float startY) {
        this.combatStats = combatStats;
        this.x = startX;
        this.y = startY;
    }

    public void move(float dx, float dy) {
        this.x += dx;
        this.y += dy;
    }

    public void jump() {
        // TODO: later add vertical velocity / gravity
    }

    public void dash() {
        // TODO: later add dash mechanic
    }

    public void attack() {
        // TODO: later connect to combat system
    }
    public void update(float deltaTime,
                       float inputX,
                       float inputY,
                       boolean jumpPressed,
                       boolean dashPressed) {

        boolean jumpJustPressed = jumpPressed && !prevJumpPressed;
        boolean dashJustPressed = dashPressed && !prevDashPressed;

        prevJumpPressed = jumpPressed;
        prevDashPressed = dashPressed;

        if (inputX != 0 || inputY != 0) {
            // remember facing direction for dash
            lastFacingX = inputX != 0 ? Math.signum(inputX) : lastFacingX;
            lastFacingY = inputY != 0 ? Math.signum(inputY) : lastFacingY;
        }

        if (isDashing) {
            // In dash: ignore gravity + normal movement, just dash
            dashTimeLeft -= deltaTime;
            if (dashTimeLeft <= 0f) {
                isDashing = false;
                // After dash, you can't dash again until grounded
                canDash = false;
            }
        } else {
            // Horizontal movement
            vx = inputX * MOVE_SPEED;

            // Gravity
            vy += GRAVITY * deltaTime;
            if (vy > MAX_FALL_SPEED) {
                vy = MAX_FALL_SPEED;
            }

            // Jump
            if (jumpJustPressed && grounded) {
                vy = JUMP_FORCE;
                grounded = false;
                canDash = true; // allow dash once after jumping
            }

            // Dash in any direction (including diagonals)
            if (dashJustPressed && canDash) {
                float dirX = inputX;
                float dirY = inputY;

                // If no input direction, dash in last facing horizontal direction
                if (dirX == 0 && dirY == 0) {
                    dirX = lastFacingX != 0 ? lastFacingX : 1f;
                    dirY = lastFacingY;
                }

                // Normalize direction
                float len = (float) Math.sqrt(dirX * dirX + dirY * dirY);
                if (len == 0f) {
                    dirX = 1f;
                    dirY = 0f;
                    len = 1f;
                }
                dirX /= len;
                dirY /= len;

                vx = dirX * DASH_SPEED;
                vy = dirY * DASH_SPEED;

                isDashing = true;
                dashTimeLeft = DASH_DURATION;
            }
        }

        // Integrate position
        x += vx * deltaTime;
        y += vy * deltaTime;

        // Simple ground collision at GROUND_Y
        if (y >= GROUND_Y) {
            y = GROUND_Y;
            vy = 0f;
            grounded = true;
            isDashing = false;
            // Recharge dash on ground
            canDash = true;
        }
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
