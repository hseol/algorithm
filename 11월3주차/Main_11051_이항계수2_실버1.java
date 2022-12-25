package 혼자서연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11051_이항계수2_실버1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][]arr = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <=i; j++) {
				if (j == 0 || j == i)
					arr[i][j] = 1;
				else {
					arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j])%10007;
				}
			}
		}
		System.out.println(arr[N][K]);
		br.close();
	}

}
