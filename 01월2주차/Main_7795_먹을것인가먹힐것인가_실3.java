package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7795_먹을것인가먹힐것인가_실3 {
	static int T, N, M, nn[], mm[], count, index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			nn = new int[N];
			mm = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nn[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				mm[i] = Integer.parseInt(st.nextToken());
			}
			// 입력 끝
			Arrays.sort(nn);
			Arrays.sort(mm);
			index = M - 1;
			count = 0;
			for (int i = N - 1; i >= 0; i--) {
				for (int j = index; j >= 0; j--) {
					if (nn[i] > mm[j]) {
						index = j;
						count = count + j + 1;
						break;

					}

				}

			}
			System.out.println(count);
		}
	}

}
