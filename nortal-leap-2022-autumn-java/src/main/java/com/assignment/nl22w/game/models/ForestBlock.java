package com.assignment.nl22w.game.models;

// Works as information carrier. Only job - to model. It is like
// separate entity in our forest, one block is one object
// that why its separate. Data transfer object.

public class ForestBlock {
    private final int x;
    private final int y;

    public ForestBlock parent;

    public ForestBlock(int x, int y){
        this.x = x;
        this.y = y;
        this.parent = null;
    }
    public ForestBlock(int x, int y, ForestBlock parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ForestBlock getParent() {
        return parent;
    }
}


