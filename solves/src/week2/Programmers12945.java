package week2;

public class Programmers12945 {
    public int solution(int n) {

        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {

            dp[i] = (dp[i - 2] + dp[i - 1]) % 1234567;
        }
        return dp[n];
    }
}
