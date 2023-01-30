/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11722_가장긴감소하는부분수열_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 1. 30.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11722_가장긴감소하는부분수열_실2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		dp[1] = 1;
		int ans = 1;
		for (int i = 2; i <=N; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] < arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}

			}
			ans = Math.max(ans, dp[i]);

		}
		for(int i :dp) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println(ans);

	}

}
