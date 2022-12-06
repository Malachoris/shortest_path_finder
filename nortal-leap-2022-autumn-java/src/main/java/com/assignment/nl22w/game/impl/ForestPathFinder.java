package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.interfaces.PathFinder;
import com.assignment.nl22w.game.models.ForestBlock;
import com.assignment.nl22w.game.enums.Direction;
import com.assignment.nl22w.game.interfaces.Matrix;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



@Component
public class ForestPathFinder implements PathFinder {

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

            for (Direction direction : Direction.values()) {
                ForestBlock location = new ForestBlock(current.getX() + direction.label[0], current.getY() + direction.label[1], current);

                nextToVisit.add(location);
                forest.setVisited(current.getX(), current.getY(), true);
            }
        }
        return nextToVisit;
    }

    @Override
    // : operator asks if list.size < 1 and if YES return 0 if NOT return step count -1 because start is like 1
    public int stepCount(List list) {
        return list.size() < 1 ? 0 : list.size() - 1;
    }

    // optimization of backtrackPath list
    //makes a flat list of traveled path
    private List<ForestBlock> backtrackPath(ForestBlock current) {
        List<ForestBlock> path = new ArrayList<>();

        // we create reference type object (referring to same hash code of "current")
        // to have many iterations without changing value of current object
        ForestBlock iteration = current;

        while (iteration != null) {
            path.add(new ForestBlock(iteration.getX(), iteration.getY()));
            // while iteration ForestBlock is not equal null we increase path size by 1 until
            // when current position is null (which is default ForestBlock value), "while" stops
            iteration = iteration.parent;
        }
        // and returns path size
        return path; // FB(0,1,null), FB(0,2,null), FB(0,3,null)}
    }
}