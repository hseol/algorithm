/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1912_연속합_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 6.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1912_연속합_실2 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int answer;
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] sum = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝
		sum[0] = arr[0];

		if (N == 1) {
			System.out.println(sum[0]);
			return;
		}
		answer = arr[0];
		for (int i = 1; i < N; i++) {

			sum[i] = Math.max(sum[i - 1] + arr[i], arr[i]);
			answer = Math.max(answer, sum[i]);
		}

		System.out.println(answer);

	}

}
/* 처음에 생각했던 단순한 방법으로 생각하면 됐었다.. 하지만비교를 잘하자.. 그래도 접근법은 맞았음 흐어엉... */