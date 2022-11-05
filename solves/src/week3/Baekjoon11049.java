package week3;

import java.util.Scanner;

public class Baekjoon11049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] matrix = new int[N][2];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < i + j; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + matrix[j][0] * matrix[k][1] * matrix[j + i][1]);
                }

            }
        }
        System.out.println(dp[0][N - 1]);
    }
}

