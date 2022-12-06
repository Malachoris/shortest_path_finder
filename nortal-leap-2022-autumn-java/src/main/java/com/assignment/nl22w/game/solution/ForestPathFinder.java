package com.assignment.nl22w.game.solution;

import com.assignment.nl22w.game.solution.interfaces.Matrix;
import com.assignment.nl22w.game.solution.interfaces.PathFinder;
import com.assignment.nl22w.game.solution.models.ForestBlock;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
public class ForestPathFinder implements PathFinder {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    //returns a list of forest blocks that is needed for traveling through matrix
    @Override
    public List<ForestBlock> findPath(Matrix forest) {
        LinkedList<ForestBlock> nextToVisit = new LinkedList<>();

        ForestBlock start = forest.getEntry();
        nextToVisit.add(start);

        while (!nextToVisit.isEmpty()) {
            ForestBlock current = nextToVisit.remove();

            if (!forest.isValidLocation(current.getX(), current.getY()) || forest.isExplored(current.getX(), current.getY())) {
                continue;
            }

            if (forest.isTree(current.getX(), current.getY())) {
                forest.setVisited(current.getX(), current.getY(), true);
                continue;
            }

            if (forest.isExit(current.getX(), current.getY())) {
                return backtrackPath(current);
            }

            for (int[] direction : DIRECTIONS) {
                ForestBlock location = new ForestBlock(current.getX() + direction[0], current.getY() + direction[1], current);
                nextToVisit.add(location);
                forest.setVisited(current.getX(), current.getY(), true);
            }
        }
        return nextToVisit;
    }

    @Override
    public int stepCount(List list) {
        return list.size() < 1 ? 0 : list.size() - 1;
    }
    //makes a flat list of traveled path
    private List<ForestBlock> backtrackPath(ForestBlock current) {
        List<ForestBlock> path = new ArrayList<>();
        ForestBlock iteration = current;

        while (iteration != null) {
            path.add(iteration);
            iteration = iteration.parent;
        }
        return path;
    }
}