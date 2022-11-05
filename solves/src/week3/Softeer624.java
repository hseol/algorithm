package week3;

import java.util.Scanner;

public class Softeer624 {

    static boolean[][] bulbGuide = {
            {true, true, true, false, true, true, true},
            {false, false, true, false, false, true, false},
            {true, false, true, true, true, false, true},
            {true, false, true, true, false, true, true},
            {false, true, true, true, false, true, false},
            {true, true, false, true, false, true, true},
            {true, true, false, true, true, true, true},
            {true, true, true, false, false, true, false},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int ret = 0;
            boolean[][] source = toBulb(sc.nextInt());
            boolean[][] target = toBulb(sc.nextInt());

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 7; j++)
                    if (source[i][j] != target[i][j]) ret++;
            }
            System.out.println(ret);
        }
    }

    public static boolean[][] toBulb(int num) {

        boolean[][] bulb = new boolean[5][7];
        String source = num + "";
        int length = source.length();

        for (int i = 0; i < length; i++) {
            int index = 5 - length + i;

            for (int j = 0; j < 7; j++)
                bulb[index][j] = bulbGuide[source.charAt(i) - '0'][j];
        }

        return bulb;
    }
}
