package com.assignment.nl22w.game.impl;

import com.assignment.nl22w.game.interfaces.Validator;
import org.springframework.stereotype.Component;

@Component
public class ForestValidator implements Validator {

    //validates String prerequisites of assignment
    @Override
    public boolean isValid(String text) {
        if (text == null) return false;

        // ["111", "X 1", "1 1"], text.split with regex "\r?\n" makes String to go
        // to new line and removes \n symbol marking Strings new line
        String[] lines = text.split("\r?\n");
        // We create new int[][](matrix) for validation
        int[][] forestMatrix = new int[lines.length][lines[0].length()];
        // Setting starting points to 0
        int startPointCount = 0;

        //checking matrix if its correct shape rectangle
        for (int row = 0; row < forestMatrix.length; row++) {
            // checking if walls are same length which indicates correct rectangle
            if (lines[row].length() != lines[0].length()) return false;

            // checking every symbol in every row to have only valid ones
            for (int col = 0; col < lines[0].length(); col++) {
                // counting if there are more than 1 X
                if (lines[row].charAt(col) == 'X') {
                    // if there are we add
                    startPointCount++;
                }
                // checking map to have only valid characters
                if (lines[row].charAt(col) != '1'
                        && lines[row].charAt(col) != 'X'
                        && lines[row].charAt(col) != ' ') {
                    return false;
                }
            }
        }

        // checking if map is in allowed boundaries
        // returns true if matches condition because isValid is boolean
        return startPointCount == 1
                && lines.length >= 5
                && lines.length <= 11000
                && lines[0].length() >= 5
                && lines[0].length() <= 11000;
    }
}
