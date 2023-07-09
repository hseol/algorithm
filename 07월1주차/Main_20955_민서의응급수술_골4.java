import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20955_민서의응급수술_골4 {
	static int N, M;
	static int[] parents;
	static int count = 0;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		check = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (!union(x, y)) {
				count++; // 끊어줄 연산횟수
			}
			;
		} // 입력 끝

		for (int i = 1; i <= N; i++) {
			if (!check[find(i)]) {
				count++;
				check[find(i)] = true;
			}
		}
		count-=1;
		System.out.println(count);

	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (x < y) {
			parents[y] = x;
		} else {
			parents[x] = y;
		}
		return true;
	}

	public static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return find(parents[x]);
		}
	}

}
