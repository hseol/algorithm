/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11053_가장긴증가하는부분수열_실2.java
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
public class Main_11053_가장긴증가하는부분수열_실2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// ArrayList<Integer> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp[1] = 1;
		int ans = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = 1;
			for (int j = 1; j < i; j++) {
				if (arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
//		list.add(0);
//		for (int i = 1; i <= N; i++) {
////			if (i == N)
////				break;
//			// 왕큰 수가 나타났을때 내 앞 수가 나보단 작은데 내 뒷수보다 크면 나를 생략하고 넘어가는건 어떨까?
//			if (i<N&&(arr[i] > arr[i + 1]) && (list.get(list.size()-1) < arr[i + 1])) {
//				continue;
//			}
//			if (arr[i] > list.get(list.size()-1)) {
//				list.add(arr[i]);
//			}
//		}
//		System.out.println(list.size()-1);

	}

}

/*
 * 디피 문제지만 LIS 방식으로 풀어야하는 문제 ㅎㅎ... ㅅㅂ 내가 어케아냐
 */
