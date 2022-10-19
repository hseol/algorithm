package Oct3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음식물피하기_실1_1743 {
	static int N, M, K, r, c;
	static String[][] umssmap;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb;
		StringTokenizer st;
		result = 0;
int bigumss=0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		umssmap = new String[N][M];

		///////////////////// 맵그리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				umssmap[i][j] = ".";
			}
		}

		/////////////////////////// 음식물투척
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			umssmap[r][c] = "#";
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (umssmap[i][j].equals("#")) {
					BFS(i, j);
					bigumss = Math.max(result, bigumss);
				}
			}
		}

		//////////////////////////////////////// 출력하기
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(umssmap[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(bigumss);
	}

	public static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		boolean[][] checked = new boolean[N][M];
		queue.add(new int[] { r, c, 1 });
		checked[r][c] = true;

		while (!queue.isEmpty()) {
			int[] umss = queue.poll();
			int cr = umss[0];
			int cc = umss[1];
			for (int d = 0; d < 4; d++) {
				if (cr + dr[d] < 0 || cr + dr[d] >= N || cc + dc[d] < 0 || cc + dc[d] >= M
						|| checked[cr + dr[d]][cc + dc[d]] || umssmap[cr + dr[d]][cc + dc[d]].equals(".")) {
					continue;
				}
				checked[cr + dr[d]][cc + dc[d]] = true;
				queue.add(new int[] { cr + dr[d], cc + dc[d], umss[2] + 1 });
				result  = Math.max(result,(umss[2] + 1) );

			}
		}

	}
}
