package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11049_행렬곱셈순서_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 3. 21.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11049_행렬곱셈순서_골3 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][N];
		int[][] process = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			process[i][0] = Integer.parseInt(st.nextToken());
			process[i][1] = Integer.parseInt(st.nextToken());
		}
		for (int k = 1; k < N; k++) {
			for (int i = 0; i + k < N; i++) {
				dp[i][i + k] = Integer.MAX_VALUE;
				for (int j = i; j < i + k; j++)
					dp[i][i + k] = Math.min(dp[i][i + k],
							dp[i][j] + dp[j + 1][i + k] + process[i][0] * process[j][1] * process[i + k][1]);
			}
		}
		System.out.println(dp[0][N - 1]);
	}

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		ArrayList<Integer> list = new ArrayList<>();
//		int min = Integer.MAX_VALUE;
//		int answer = 0;
//		int point = 0;
//		N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N + 1];
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			arr[i] = Integer.parseInt(st.nextToken());
//			arr[i + 1] = Integer.parseInt(st.nextToken());
//		}
//		for (int i = 0; i <= N; i++) {
//			list.add(arr[i]);
//		}
//		while (list.size() >= 3) {
//			min = Integer.MAX_VALUE;
//			for (int i = 0; i < list.size() - 2; i++) {
//				int result = list.get(i) * list.get(i + 1) * list.get(i + 2);
//				if (min > result) {
//					min = result;
//					point = i + 1; // 가운데 값 기억하기
//				}
//			}
//			answer += min;
//			list.remove(point);
//		}
//		System.out.println(answer);
//
//	}

}
