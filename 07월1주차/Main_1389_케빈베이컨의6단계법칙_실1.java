import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙_실1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] arr = new long[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.MAX_VALUE;

				if (i == j) {
					arr[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start][end] = arr[end][start] = 1;
		}

		// 플워
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (k == i)
					continue;
				for (int j = 1; j <= N; j++) {
					if (k == j || i == j)
						continue;
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int result = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 1; i <= N; i++) {
			int total = 0;
			for (int j = 1; j <= N; j++) {
				total += arr[i][j];
			}

			if (result > total) {
				result = total;
				index = i;
			}
		}

		System.out.println(index);
	}

}
