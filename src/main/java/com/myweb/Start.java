package com.myweb;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        Area area = new Area();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入最大座标（X Y），X、Y为数字坐标，中间加空格");
            String[] areas = scan.nextLine().split(" ");
            if (areas.length != 2 || !StringUtils.isNumeric(areas[0]) || !StringUtils.isNumeric(areas[1])) continue;
            else {
                area.setMaxX(Integer.parseInt(areas[0]));
                area.setMaxY(Integer.parseInt(areas[1]));
                break;
            }

        }
        while (true) {
            System.out.println("请输入漫步车当前座标及朝向（X Y Direct），X、Y为数字坐标，Direct为字母朝向（E或S或W或N），中间加空格");
            String[] state = scan.nextLine().split(" ");
            if (state.length != 3 || !StringUtils.isNumeric(state[0]) || !StringUtils.isNumeric(state[1]) || state[1].length() != 1 || !StringUtils.containsOnly(state[2], "ESWN")) continue;
            else {
                Rover rover = init(area, Integer.parseInt(state[0]), Integer.parseInt(state[1]), state[2]);
                while (true) {
                    System.out.println("请输入漫步车行动指令，指令为字母串（L或R或M），中间无空格");
                    String[] move = scan.nextLine().split(" ");
                    if (move.length != 1 || !StringUtils.containsOnly(move[0], "LRM")) continue;
                    else {
                        start(rover, move[0]);
                        break;
                    }
                }
            }
        }

    }

    public static void start(Rover rover, String move) {
        char[] chars = move.toCharArray();
        for (char c : chars) {
            rover.go(c + "");
        }
        System.out.println("漫步车执行指令完成，执行指令后的坐标及朝向为：");
        System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirect());
    }

    public static Rover init(Area area, int x, int y, String direct) {
        Rover rover = new Rover(x, y, Rover.stringToInt(direct));
        rover.setArea(area);
        return rover;
    }
}
