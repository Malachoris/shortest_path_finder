package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.enums.ForestTile;
import com.assignment.nl22w.game.interfaces.Matrix;
import com.assignment.nl22w.game.models.ForestBlock;
import org.springframework.stereotype.Component;

@Component
public class ForestBuilder implements Matrix {

    private static ForestTile[][] forestMatrix;
    private static boolean[][] visitedMatrix;
    private static ForestBlock startPosition;


    // FYI Service must have interface to each all public methods, if we want Dependency Injection(DI) it must have interface.
    // if There are similar classes, do abstract class and add what's missing to the ones what are similar.
    // DI is for better testing and code expansion and refactor.

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

        // Regex searches for new line that could be marked \r or \n depending on your OS. "?" means it could be or may not.
        // Goes through every String row and if it finds new line, creates new object and puts it in array.
        // ["a", "b", "c"]
        String[] lines = text.split("\r?\n");
        // Get both matrix sizes
        // Java wants to know exact number of how much memory to assign to what size array.
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