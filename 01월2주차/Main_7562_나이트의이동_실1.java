package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동_실1 {
	static int[] dr = { -2, -2, 2, 2, -1, 1, -1, 1 }; // 상좌 상우 하좌 하우 좌상 좌하 우상 우하
	static int[] dc = { -1, 1, -1, 1, -2, -2, 2, 2 };
	static int T, I, map[][], endr, endc, count, result;
	static boolean check[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			I = Integer.parseInt(br.readLine());
			count = 0;
			result = Integer.MAX_VALUE;
			map = new int[I][I];
			check = new boolean[I][I];
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endr = Integer.parseInt(st.nextToken());
			endc = Integer.parseInt(st.nextToken());

			bfs(r, c);
			System.out.println(result);
		}
	}

	static public void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });
		check[r][c] = true;
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();
			// 종료조건
			if (loca[0] == endr && loca[1] == endc) {
				result = Math.min(result, loca[2]);
			}
			// 빙글빙글 큐를 돌리기
			for (int d = 0; d < 8; d++) {
				int nr = loca[0] + dr[d];
				int nc = loca[1] + dc[d];

				if (nr < 0 || nc < 0 || nr >= I || nc >= I || check[nr][nc])
					continue;

				check[nr][nc] = true;
				queue.offer(new int[] { nr, nc, loca[2] + 1 });
			}
		}

	}

}
