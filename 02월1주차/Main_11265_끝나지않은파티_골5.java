/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_11265_끝나지않은파티_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 5.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11265_끝나지않은파티_골5 {
	static int N, M, party[][], A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 행렬크기
		M = Integer.parseInt(st.nextToken()); // 테케 수
		party = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 입력 끝

		// 경출도!
		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= N; ++j) {
				if (i == j)
					continue;
				for (int k = 1; k <= N; ++k) {
					if (i == j || j == k) {

						continue;
					}
					if (party[j][k] > party[j][i] + party[i][k]) {
						party[j][k] = party[j][i] + party[i][k];
					}
				}
			}
		} // 최소거리들로 만든 파티맵이 만들어졌으면... 이제 시작
		sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if (party[A][B] <= C) {
				sb.append("Enjoy other party").append("\n");
			} else {
				sb.append("Stay here").append("\n");
			}

		}
		System.out.println(sb.toString());
	}

}
