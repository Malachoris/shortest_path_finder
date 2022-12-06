package com.assignment.nl22w.game.enums;

public enum Direction {
    NORTH(new int[]{0, 1}),
    EAST(new int[]{1, 0}),
    SOUTH(new int[]{0, -1}),
    WEST(new int[]{-1, 0});

    public final int [] label;

    private Direction(int[] label){
        this.label = label;
    }
}