import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1956_운동_골4 {
	static long map[][], result;
	static int V, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken()); // 마을
		E = Integer.parseInt(st.nextToken()); // 입력값 수
		result = Integer.MAX_VALUE;
		map = new long[V][V];
		for (int i = 0; i < V; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int dis = Integer.parseInt(st.nextToken());
			map[start][end] = dis;
		}
		pw();
		System.out.println(cycle());

//		for (int i = 1; i <= V; ++i) {
//			for (int j = 1; j <= V; ++j) {
//				System.out.print(map[i][j]+" ");
//			}System.out.println();
//		}

	}

	public static void pw() {
		for (int k = 0; k < V; ++k) {
			for (int i = 0; i < V; ++i) {
				if (k == i)
					continue;
				for (int j = 0; j < V; ++j) {
					if (k == j)
						continue;
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
	}
	public static long cycle() {
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if(i==j) {
					result =Math.min(result, map[i][j]);
				}
			}
		}
		if(result==Integer.MAX_VALUE) {
			return -1;
		}else {
			return result;
		}
	}

}
