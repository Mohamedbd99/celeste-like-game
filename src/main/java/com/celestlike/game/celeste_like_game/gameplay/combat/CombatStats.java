package com.celestlike.game.celeste_like_game.gameplay.combat;

// Simple value object for combat-related data.
// Encapsulate data, avoid public fields.
public class CombatStats {

    private int maxHealth;
    private int currentHealth;
    private int attackPower;
    private int defense;

    public CombatStats(int maxHealth, int attackPower, int defense) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void takeDamage(int rawDamage) {
        int damage = Math.max(0, rawDamage - defense);
        currentHealth = Math.max(0, currentHealth - damage);
    }

    public boolean isDead() {
        return currentHealth <= 0;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }
}
