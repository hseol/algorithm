/**
 * 
 */
package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11659_구간합구하기4_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 24.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11659_구간합구하기4_실3 {
	static int N, M;
	static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// BufferedWriter
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// Stringbuilder
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		sum[1] = Integer.parseInt(st.nextToken());
		for (int i = 2; i <= N; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			int result = sum[second] - sum[first-1];

			// sysout 프린트
			System.out.println(result);

			// Stringbuilder
			sb.append(result).append("\n");

			// BufferedWriter
			bw.write(result + "\n");

		}
		// Stringbuilder
		System.out.println(sb);

		// BufferedWriter
		bw.flush();
		bw.close();

	}

}
