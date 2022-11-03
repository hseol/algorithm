package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3184_양_실1 {
	static int R, C, Resheap, Rewolf;
	static char[][] map;
	static boolean[][] checked;

//. 빈필드 , # 울타리 ,o 양, v 늑대 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		checked = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}

		} /////////////// 입력 완료

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!checked[i][j] && map[i][j] != '#') {// 방문안하고 울타리가 아니면
					checked[i][j] = true;
					BFS(i, j);
				}
			}

		}
		System.out.println(Resheap + " " + Rewolf);
	}

	static void BFS(int r, int c) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		int sheap = 0;
		int wolf = 0;
		while (!queue.isEmpty()) {
			int[] fight = queue.poll();
			
			int cr = fight[0];
			int cc = fight[1];
			
			if (map[cr][cc] == 'o') {
				sheap++;
			} else if (map[cr][cc] == 'v') {
				wolf++;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (nr < 0 || nr >= R ||nc < 0 || nc >= C
						|| map[nr][nc] == '#' || checked[nr][nc]) {
					continue;
				}
				checked[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		}
		if (sheap > wolf) {
			Resheap += sheap;

		} else {
			Rewolf += wolf;
		}
	}

}
