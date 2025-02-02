package Oct3week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_최소비용구하기_골5_1916 {
	static long[] dist;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					map[i][j] = 0;
					continue;
				}
				map[i][j] = Integer.MAX_VALUE - 1; // 왕 큰값
			}
		}

		for (int i = 0; i < m; i++) {
			String[] inputs = br.readLine().split(" ");
			int s = Integer.parseInt(inputs[0]);
			int e = Integer.parseInt(inputs[1]);
			int w = Integer.parseInt(inputs[2]);

			// 같은 경로 여러 번 들어올 경우 가장 작은 weight 값 저장
			if (map[s][e] == -1)
				map[s][e] = w;
			else if (map[s][e] > w)
				map[s][e] = w;

		}

		String[] inputs = br.readLine().split(" ");
		int start = Integer.parseInt(inputs[0]);
		int end = Integer.parseInt(inputs[1]);

		dist = new long[n + 1];
		visited = new boolean[n + 1];

		// Dijkstra

		for (int i = 1; i <= n; i++) {
			dist[i] = map[start][i];
		}

		visited[start] = true;

		for (int i = 0; i < n - 1; i++) {
			int cur = getMinIdx();
			visited[cur] = true;
			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					if (dist[cur] + map[cur][j] < dist[j]) {
						dist[j] = dist[cur] + map[cur][j];
					}
				}
			}
		}

		System.out.println(dist[end]);

	}

	public static int getMinIdx() {
		long min = Integer.MAX_VALUE;
		int idx = 0;

		for (int i = 1; i <= n; i++) {
			if (dist[i] < min && !visited[i]) {
				min = dist[i];
				idx = i;
			}
		}
		return idx;
	}

}
