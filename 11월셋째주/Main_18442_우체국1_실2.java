package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_18442_우체국1_실2 {
	static int V, P;
	static long L,min= Long.MAX_VALUE,sum,result;
	static long[] village, police, list;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		village = new long[V];
		visited = new boolean[V];
		police = new long[P];
		list = new long[P];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < V; i++) {
			village[i] = Long.parseLong(st.nextToken());
		} // 마을에 있는 좌표 생성띠~
		조합(0, 0);
		sb.append(min).append("\n");
		for (long i : list) {
			sb.append(i).append(" ");
		}
		System.out.print(sb.toString());
	}

	

	static void 조합(int cnt, int start) {
		if (cnt == P) {
			// System.out.println(Arrays.toString(police));
			최소거리();
			if (sum > min)
				return;
			else if (sum < min) {
				min = sum;
				for (int i = 0; i < P; i++) {
					list[i] = police[i];
				}
			}
			return;
			// System.out.println(min);

		}
		for (int j = start; j < V; j++) {
			police[cnt] = village[j];
			visited[j] = true;
			조합(cnt + 1, j + 1);
			visited[j] = false;
		}
	}


	static void 최소거리() {
		sum = 0;
		for (int i = 0; i < V; i++) { // 각 마을과 제일 가까운 경찰서와의 거리 구하기
			result = Long.MAX_VALUE;
			for (int j = 0; j < P; j++) {
				if (visited[i]) // 경찰서라면
					break;
				long sub = Math.abs(village[i] - police[j]);
				sub = Math.min(sub, L - sub);// 마을과 경찰서의 거리
				result = Math.min(result, sub);// 그 마을에 대해서 가장 가까운 경찰서와의 거리가 result
			}
			if (!visited[i]) {
				sum += result;
			}
		} // sum은 각마을에서 가장 가까운 경찰서와의 거리를 합한 거
	}
}