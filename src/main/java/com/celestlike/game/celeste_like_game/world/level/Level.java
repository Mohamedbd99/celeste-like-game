package com.celestlike.game.celeste_like_game.world.level;

import java.util.ArrayList;
import java.util.List;

// Composite that contains all nodes in a level.
public class Level implements LevelNode {

    private final List<LevelNode> children = new ArrayList<>();

    public void addNode(LevelNode node) {
        children.add(node);
    }

    public void removeNode(LevelNode node) {
        children.remove(node);
    }

    @Override
    public void update(float deltaTime) {
        for (LevelNode node : children) {
            node.update(deltaTime);
        }
    }
}
