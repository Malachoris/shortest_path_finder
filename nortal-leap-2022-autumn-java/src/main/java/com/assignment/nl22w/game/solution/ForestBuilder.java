package com.assignment.nl22w.game.solution;

import com.assignment.nl22w.game.solution.Enums.ForestTile;
import com.assignment.nl22w.game.solution.interfaces.Matrix;
import com.assignment.nl22w.game.solution.models.ForestBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ForestBuilder implements Matrix {
    @Autowired
    private static ForestTile[][] forestMatrix;
    private static boolean[][] visitedMatrix;
    @Autowired
    private static ForestBlock startPosition;

    @Override
    public int getHeight() {
        return forestMatrix.length;
    }
    @Override
    public int getWidth() {
        return forestMatrix[0].length;
    }
    @Override
    public ForestBlock getEntry() {
        return startPosition;
    }
    @Override
    public boolean isExit(int row, int col) {
        return row == 0
            || row == forestMatrix.length - 1
            || col == 0
            || col == forestMatrix[row].length - 1;
    }
    @Override
    public boolean isExplored(int row, int col) {
        return visitedMatrix[row][col];
    }
    @Override
    public boolean isTree(int row, int col) {
        return forestMatrix[row][col] == ForestTile.TREE;
    }
    @Override
    public void setVisited(int row, int col, boolean value) {
        visitedMatrix[row][col] = value;
    }
    @Override
    public boolean isValidLocation(int row, int col) {
        return !(row < 0 || row >= getHeight() || col < 0 || col >= getWidth());
    }
    @Override
    public void initialize(String text) {

        //get both matrix sizes
        String[] lines = text.split("\r?\n");
        forestMatrix = new ForestTile[lines.length][lines[0].length()];
        visitedMatrix = new boolean[lines.length][lines[0].length()];

        //Reading text file and marking text file's symbols
        for (int row = 0; row < getHeight(); row++) {
            for (int col = 0; col < getWidth(); col++) {
                if (lines[row].charAt(col) == '1')
                    forestMatrix[row][col] = ForestTile.TREE;
                else if (lines[row].charAt(col) == 'X') {
                    forestMatrix[row][col] = ForestTile.START;
                    startPosition = new ForestBlock(row, col);
                } else if (row == 0
                    || col == 0
                    || row == forestMatrix.length-1
                    || col == forestMatrix[row].length-1){
                    forestMatrix[row][col] = ForestTile.EXIT;
                } else
                    forestMatrix[row][col] = ForestTile.ROAD;
            }
        }
    }
}