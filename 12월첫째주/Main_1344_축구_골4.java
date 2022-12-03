package 흑흑난몰라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1344_축구_골4 {

	static double[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double a, b;
		a = Double.parseDouble(br.readLine());
		b = Double.parseDouble(br.readLine());
		a /= 100;
		b /= 100;
		dp = new double[20][20][20];

		double ans = 0;
		dp[0][0][0] = 1.0;
		for (int i = 1; i <= 18; i++) {
			for (int j = 0; j <= i; j++) {
				for (int k = 0; k <= i; k++) {
					if (j > 0)
						dp[i][j][k] += dp[i - 1][j - 1][k] * a * (1 - b);
					if (k > 0)
						dp[i][j][k] += dp[i - 1][j][k - 1] * (1 - a) * b;
					if (j > 0 && k > 0)
						dp[i][j][k] += dp[i - 1][j - 1][k - 1] * a * b;
					dp[i][j][k] += dp[i - 1][j][k] * (1 - a) * (1 - b);
				}
			}
		}

		for (int i = 0; i <= 18; i++) {
			for (int j = 0; j <= 18; j++) {
				if (isPrime(i) || isPrime(j))
					ans += dp[18][i][j];
			}
		}

		System.out.println(ans);
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0)
				return false;
		return true;
	}

}
