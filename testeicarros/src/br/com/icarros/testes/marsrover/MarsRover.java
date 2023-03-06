package br.com.icarros.testes.marsrover;

import java.util.HashMap;
import java.util.Map;

public class MarsRover {
    static Map<String, Integer> headingsMap = new HashMap<>() {{
        put("N", 0);
        put("E", 1);
        put("S", 2);
        put("W", 3);
    }};

    static char[] headingsArr = {'N','E','S','W'};

    static boolean checkMax(int maxNumber, int number) {
        return number < maxNumber;
    }

    static boolean checkMin(int number) {
        return number > 0;
    }

    static void solver(int maxX, int maxY, int x, int y, String startHeading, String commands) {
        int actualHeading = headingsMap.get(startHeading);
        for (int i = 0; i < commands.length(); i++) {
            char cmd = commands.charAt(i);
            switch (cmd) {
                case 'L' -> actualHeading--;
                case 'R' -> actualHeading++;
                case 'M' -> {
                    char direction = headingsArr[Math.abs(actualHeading % headingsArr.length)];
                    switch (direction) {
                        case 'N' -> {
                            if (checkMax(maxY, y)) y++;
                        }
                        case 'E' -> {
                            if (checkMax(maxX, x)) x++;
                        }
                        case 'S' -> {
                            if (checkMin(y)) y--;
                        }
                        case 'W' -> {
                            if(checkMin(x)) x--;
                        }
                        default -> {
                        }
                    }
                }
                default -> {
                }
            }
        }

        System.out.println(x
                + " "
                + y
                + " "
                + headingsArr[Math.abs(actualHeading % headingsArr.length)]
        );
    }
    
    public static void main(String[] args) {
        solver(5,5,1,2, "N", "LMLMLMLMM");
        solver(5,5,3,3, "E", "MMRMMRMRRM");
    }
}


