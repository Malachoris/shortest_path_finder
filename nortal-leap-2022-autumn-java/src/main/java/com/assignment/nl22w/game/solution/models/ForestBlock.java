package com.assignment.nl22w.game.solution.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ForestBlock {
    public int x;
    public int y;

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


