/**
 * 
 */
package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_15652_N과M4_실3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 18.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_15652_N과M4_실3 {
	static int N, M;
	static int number[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[M];
		Combi(1, 0);
		System.out.println(sb.toString());
	}

	public static void Combi(int start, int cnt) {
		if (cnt == M) {
			for (int i : number) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			number[cnt] = i;
			Combi(i, cnt + 1);
		}
	}

}
