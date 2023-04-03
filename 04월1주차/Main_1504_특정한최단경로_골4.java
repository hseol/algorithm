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
 * @FileName : Main_1504_특정한최단경로_골4.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 3.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1504_특정한최단경로_골4 {
	static int N, E, start, end, first, second;
	static long map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		map = new long[N + 1][N + 1];
		long INF = 200000000;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if (i == j) {
					map[i][j] = 0;
				}
				map[i][j] = INF;
			}
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			long dis = Integer.parseInt(st.nextToken());
			map[start][end] = dis;
			map[end][start] = dis;
		} // 맵
		st = new StringTokenizer(br.readLine());
		first = Integer.parseInt(st.nextToken());
		second = Integer.parseInt(st.nextToken());

		// 경출도~~
		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				if (i == k)
					continue;
				for (int j = 1; j <= N; ++j) {
					if (k == j || i == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		// 돌리기
//		for (int k = 1; k <= N; ++k) {
//			for (int i = 1; i <= N; ++i) {
//				System.out.print(map[k][i] + " ");
//			}
//			System.out.println();
//		}
		long result = 0;
		long result1 = map[1][first] + map[second][N] + map[first][second];
		long result2 = map[1][second] + map[first][N] + map[second][first];
		if (map[1][N] >= INF) {
			result = -1;
		} else if (result1 >= INF || result2 >= INF) {
			result = -1;
		} else {
			result = Math.min(result1, result2);
		}
		System.out.println(result);

	}

}
