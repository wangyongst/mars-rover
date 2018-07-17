package com.myweb;

public class Rover {
    private Area area;
    private int x;
    private int y;
    private int direct; // 1W 2N 3E 0S

    public Rover(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public static String intToString(int out) {
        if (out == 1) return "W";
        else if (out == 2) return "N";
        else if (out == 3) return "E";
        else return "S";
    }

    public static int stringToInt(String out) {
        if (out.equals("W")) return 1;
        else if (out.equals("N")) return 2;
        else if (out.equals("E")) return 3;
        else return 4;
    }


    public void move() {
        int out = ((direct % 4) + 4) % 4;
        if (out == 1 && x > 0) x--;
        else if (out == 2 && y < area.getMaxY()) y++;
        else if (out == 3 && y < area.getMaxX()) x++;
        else if (y > 0) y--;
    }

    public void go(String s) {
        if (s.equals("L")) direct--;
        else if (s.equals("R")) direct++;
        else if (s.equals("M")) move();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirect() {
        return intToString(((direct % 4) + 4) % 4);
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
