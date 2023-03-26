package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_15486_퇴사2_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 26.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_15486_퇴사2_골5 {
	static int N, T[], P[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		T = new int[N + 1];
		P = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		int max = 0;

		for (int i = 0; i <= N; i++) {
			max = Math.max(max, dp[i]);

			int end = i + T[i];
			if (end <= N) {
				dp[end] = Math.max(dp[end], max + P[i]);
			}

			for (int t : dp) {
				System.out.print(t + " ");
			}
			System.out.println();
		}

		System.out.println(max);
	}

}
