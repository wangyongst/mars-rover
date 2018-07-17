package com.myweb;

public class Start {

    public static void main(String[] args) {
        Rover rover = new Rover(3, 3, 1);
        String move = "MMRMMRMRRM";
        char[] chars = move.toCharArray();
        for(char c : chars){
            rover.go(c+"");
        }
        System.out.print(rover.getX());
        System.out.print(rover.getY());
        rover.printDirect();
    }
}
