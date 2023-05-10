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
 * @FileName : Main_11403_경로찾기_실1.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 9.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_11403_경로찾기_실1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		long map[][] = new long[N][N];
		int INF = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					map[i][j] = INF;
				}
			}
		} // 입력 끝

		for (int k = 0; k < N; ++k) {
			for (int i = 0; i < N; ++i) {
				if (k == i)
					continue;
				for (int j = 0; j < N; ++j) {
					if (k == i)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == INF) {
					sb.append(0).append(" ");
				} else {
					sb.append(1).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
