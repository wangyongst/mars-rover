package com.myweb;

public class Rover {
    private int x;
    private int y;
    private int direct; // 1E 2N 3W 4S

    public Rover(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public String intToString(int out) {
        if (out == 1) return "E";
        else if (out == 2) return "N";
        else if (out == 3) return "W";
        else return "S";
    }

    public int stringToInt(String out) {
        if (out.equals("E")) return 1;
        else if (out.equals("N")) return 2;
        else if (out.equals("W")) return 3;
        else return 4;
    }


    public void move() {
        int out = ((direct % 4) + 4) % 4;
        if (out == 1) x--;
        else if (out == 2) y++;
        else if (out == 3) x++;
        else y--;
    }

    public void printDirect() {
        System.out.print(intToString(((direct % 4) + 4) % 4));
    }

    public void go(String s) {
        if (s.equals("L")) direct--;
        else if (s.equals("R")) direct++;
        else if (s.equals("M")) move();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
