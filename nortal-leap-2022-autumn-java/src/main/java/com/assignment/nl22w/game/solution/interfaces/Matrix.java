package com.assignment.nl22w.game.solution.interfaces;

import com.assignment.nl22w.game.solution.models.ForestBlock;

public interface Matrix {
    int getHeight();
    int getWidth();
    ForestBlock getEntry();
    boolean isExit(int row, int col);
    boolean isExplored(int row, int col);
    boolean isTree(int row, int col);
    void setVisited(int row, int col, boolean value);
    boolean isValidLocation(int row, int col);
    void initialize(String text);
}