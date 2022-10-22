package week1;

import java.util.Scanner;

public class Baekjoon2616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] train = new int[n + 1];
        int[] sum = new int[n + 1];

        for (int i = 1; i < n + 1; i++){
            train[i] = sc.nextInt();
            sum[i] = train[i] + sum[i - 1];
        }
        int limit = sc.nextInt();
        int[][] dp = new int[4][n + 1];

        for (int i = 1; i < 4; i++){
            for (int j = i * limit; j < n + 1; j++){
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - limit] + sum[j] - sum[j - limit]);
            }
        }
        System.out.println(dp[3][n]);
    }
}
