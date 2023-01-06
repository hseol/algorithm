package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추_실2 {
	static int T, M, N, K, jirungE; // N 행,M 열,X 열,Y행
	static int[][] map;
	static boolean[][] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			jirungE = 0;
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			check = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = 1;
			} // 입력 끝

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
						dfs(i, j);
						jirungE++;
					}
				}
			}
			System.out.println(jirungE);

		}

	}

	public static void dfs(int r, int c) {
		int[] dr = { -1, 1, 0, 0 };// 상하좌우
		int[] dc = { 0, 0, -1, 1 };
		check[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 0)
				continue;
			if (check[nr][nc])
				continue;

			check[nr][nc] = true;
			dfs(nr, nc);

		}
		return;

		// 더이상 없으면 지렁이 수를 늘리고 빠져나온다
		// 다시 1을 발견하면 여길 들어와
	}

}
