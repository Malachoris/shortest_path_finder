package com.assignment.nl22w.game.solution;

import com.assignment.nl22w.game.solution.interfaces.Validator;
import org.springframework.stereotype.Component;

@Component
public class ForestValidator implements Validator {

    //validates String prerequisites of assignment
    @Override
    public boolean isValid(String text) {
        if (text == null) return false;

        //wanted matrix for validation
        String[] lines = text.split("\r?\n");
        int[][] forestMatrix = new int[lines.length][lines[0].length()];
        int startPointCount = 0;

        //checking matrix if its correct shape rectangle
        for (int row = 0; row < forestMatrix.length; row++) {
            if (lines[row].length() != lines[0].length()) return false;

            //checking every symbol in every row to have only valid ones
            for (int col = 0; col < lines[0].length(); col++) {
                if (lines[row].charAt(col) == 'X') {
                    startPointCount++;
                }
                if (lines[row].charAt(col) != '1'
                        && lines[row].charAt(col) != 'X'
                        && lines[row].charAt(col) != ' ') {
                    return false;
                }
            }
        }

        //checking if map is in allowed boundaries
        return startPointCount == 1
                && lines.length >= 5
                && lines.length <= 11000
                && lines[0].length() >= 5
                && lines[0].length() <= 11000;
    }
}
