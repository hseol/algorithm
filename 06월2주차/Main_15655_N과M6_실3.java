/**
 * 
 */
package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_15655_N과M6_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 6. 5.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_15655_N과M6_실3 {
	static int N, M;
	static int[] numbers;
	static int[] answer;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		answer = new int[M];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝
		Arrays.sort(numbers);
		Combi(0,0);
		System.out.println(sb);
	}

	public static void Combi(int start, int cnt) {
		if (cnt == M) {
			for (int i : answer) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = start; i < N; i++) {
			answer[cnt] = numbers[i];
			Combi(i + 1, cnt + 1);
		}
	}
}
