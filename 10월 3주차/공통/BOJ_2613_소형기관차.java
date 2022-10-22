import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//베꼈음
public class BOJ_2616 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] train = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[4][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            train[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + train[i];
        }

        int max = Integer.parseInt(br.readLine());

        for (int i = 1; i < 4; i++) {
            for (int j = i * max; j <= n; j++) {
                dp[i][j] = Math.max(
                        dp[i][j - 1],
                        dp[i - 1][j - max] + (sum[j] - sum[j - max])
                );
            }
        }

        System.out.println(dp[3][n]);
    }
}