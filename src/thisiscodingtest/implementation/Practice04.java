package thisiscodingtest.implementation;

import java.util.Scanner;

public class Practice04 {

    public static int turnLeft(int d) {
        if (d == 0) {
            return 3;
        }
        return d - 1;
    }

    public static int turnRight(int d) {
        if (d == 3) {
            return 0;
        }
        return d + 1;
    }

    public static int getTargetA(int a, int d) {
        int targetA;
        switch (d) {
            case 0:
                targetA = a - 1;
                break;
            case 1:
            case 3:
                targetA = a;
                break;
            case 2:
                targetA = a + 1;
                break;
            default:
                targetA = -1;
        }
        return targetA;
    }

    public static int getTargetB(int b, int d) {
        int targetB;
        switch (d) {
            case 3:
                targetB = b - 1;
                break;
            case 0:
            case 2:
                targetB = b;
                break;
            case 1:
                targetB = b + 1;
                break;
            default:
                targetB = -1;
        }
        return targetB;
    }

    public static int getBackA(int a, int d) {
        if (d == 0) {
            return a + 1;
        } else if (d == 2) {
            return a - 1;
        } else {
            return a;
        }
    }

    public static int getBackB(int b, int d) {
        if (d == 3) {
            return b + 1;
        } else if (d == 1) {
            return b - 1;
        } else {
            return b;
        }
    }

    public static boolean isMovable(int[][] map, int a, int b, int d) {
        int targetA = getTargetA(a, d);
        int targetB = getTargetB(b, d);

        try {
            return map[targetA][targetB] == 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static int[][] move(int[][] map, int a, int b, int d) {
        int targetA = getTargetA(a, d);
        int targetB = getTargetB(b, d);
        map[targetA][targetB] = 2;
        return map;
    }

    public static boolean isBackMovable(int[][] map, int a, int b, int d) {
        int backA = getBackA(a, d);
        int backB = getBackB(b, d);

        try {
            return map[backA][backB] != 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] map = new int[n][m];
        int a = sc.nextInt();
        int b = sc.nextInt();
        int d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int moveCnt = 0;
        outer:
        while (true) {
            d = turnLeft(d);
            for (int i = 0; i < 4; i++) {
                if (isMovable(map, a, b, d)) {
                    map = move(map, a, b, d);
                    a = getTargetA(a, d);
                    b = getTargetB(b, d);
                    moveCnt++;
                    continue outer;
                }
                d = turnLeft(d);
            }
            d = turnRight(d);
            if (isBackMovable(map, a, b, d)) {
                a = getBackA(a, d);
                b = getBackB(b, d);
            } else {
                break;
            }
        }
        System.out.println(moveCnt);
    }
}
