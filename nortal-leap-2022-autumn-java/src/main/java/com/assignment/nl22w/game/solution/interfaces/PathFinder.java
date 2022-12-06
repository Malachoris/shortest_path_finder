package com.assignment.nl22w.game.solution.interfaces;

import com.assignment.nl22w.game.solution.models.ForestBlock;

import java.util.List;

public interface PathFinder {
    List<ForestBlock> findPath(Matrix matrix);
    int stepCount (List<ForestBlock> list);
}
