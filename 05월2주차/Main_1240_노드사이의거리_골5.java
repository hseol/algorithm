/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_1240_노드사이의거리_골5.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 5. 12.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_1240_노드사이의거리_골5 {

	static int N, M;
	static long map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new long[N + 1][N + 1];
		int INF = Integer.MAX_VALUE;
		for(long[] l : map) {
			Arrays.fill(l, INF);
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			map[start][end] = dist;
			map[end][start] = dist;
		}
		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				if (k == i)
					continue;
				for (int j = 1; j <= N; j++) {
					if (k == j || i == j)
						continue;
					if ( map[i][j]>map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}//플워~
		while(M-- >0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			sb.append(map[start][end]).append("\n");
		}
		System.out.println(sb);
	}

}
