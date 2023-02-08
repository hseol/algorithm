
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림_실1 {
	static int N, M, count, pic;
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력끝
		pic = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					pic++;
					bfs(i,j);
				}
			}
		}
		System.out.println(pic);
		System.out.println(count);

	}

	public static void bfs(int r, int c) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int cnt = 0;
		Queue<int[]> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.offer(new int[] { r, c});
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();
			cnt++; //그 도형안에서 탐색할수있는 칸... 이 세어주는 위치가 잘못되었군.. 
			for (int d = 0; d < 4; d++) {
				int nr = loca[0] + dr[d];
				int nc = loca[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == 0)
					continue;
				visited[nr][nc] = true;
				queue.offer(new int[] { nr, nc });
			}
		}
		count = Math.max(count, cnt);
	}

}
