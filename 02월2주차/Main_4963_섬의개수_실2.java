/**
 * 
 */
package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_4963_섬의개수_실2.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 2. 12.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */
public class Main_4963_섬의개수_실2 {
	static int N, M, map[][], count = 0;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		while (N != 0 && M != 0) {

			map = new int[N][M];
			visited = new boolean[N][M];
			count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력끝

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count).append("\n");
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
		}
		System.out.println(sb.toString());

	}

	public static void dfs(int r, int c) {
		int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
		visited[r][c] = true;
		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0 || visited[nr][nc]) {
				continue;
			}
			visited[nr][nc] = true;
			dfs(nr, nc);
		}
	}

}
