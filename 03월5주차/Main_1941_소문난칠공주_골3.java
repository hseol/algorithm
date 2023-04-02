/**
 * 
 */
package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @FileName : Main_1941_소문난칠공주_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 2.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */

public class Main_1941_소문난칠공주_골3 {
	static char[][] map;
	static int ans;
	static boolean[] visited;
	static int[] number = new int[7];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		comb(0, 0, 0);
		System.out.println(ans);
	}

	static void comb(int cnt, int start, int dasomCnt) {
		if (cnt - dasomCnt > 3)
			return;

		if (cnt == 7) {
			visited = new boolean[7];
			bfs(number[0] / 5, number[0] % 5);
			return;
		}

		for (int i = start; i < 25; i++) {
			int row = i / 5, col = i % 5;
			number[cnt] = i;
			comb(cnt + 1, i + 1, (map[row][col] == 'S') ? dasomCnt + 1 : dasomCnt);
		}

	}

	static void bfs(int i, int j) {
		int num = 1;
		visited[0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { i, j });
		while (!queue.isEmpty()) {
			int[] loca = queue.poll();
			int r = loca[0], c = loca[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d], nc = c + dc[d];
				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
					continue;
				int nxt = 5 * nr + nc;
				for (int k = 0; k < 7; k++) {
					if (!visited[k] && number[k] == nxt) {
						visited[k] = true;
						num++;
						queue.offer(new int[] { nr, nc });
					}
				}
			}
		}
		if (num == 7)
			ans++;
	}
}
