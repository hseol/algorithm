import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동_실1 {
	static int[] dr = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] dc = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[][] map;
	static int N, result, fr, fc;
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			check = new boolean[N][N];
			result = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int cr = Integer.parseInt(st.nextToken());
			int cc = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			fr = Integer.parseInt(st.nextToken());
			fc = Integer.parseInt(st.nextToken());
			BFS(cr, cc);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static void BFS(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });
		check[r][c] = true;
		while (!queue.isEmpty()) {
			int[] knight = queue.poll();
			// System.out.println("현재 나"+knight[0]+" "+knight[1]+" "+knight[2]+" 회 움직임");
			if (knight[0] == fr && knight[1] == fc) {
				result = Math.min(result, knight[2]);
			}
			for (int d = 0; d < 8; d++) {
				int nr = knight[0] + dr[d];
				int nc = knight[1] + dc[d];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc])
					continue;
				check[nr][nc] = true;
				queue.offer(new int[] { nr, nc, knight[2] + 1 });
			}

		}

	}

}
