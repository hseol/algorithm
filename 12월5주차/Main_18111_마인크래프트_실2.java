package BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*거짓말 같은... 난이도.. 이게 왜 실2야 */
public class Main_18111_마인크래프트_실2 {
	static int N, M, map[][];
	static long B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		boolean flag;
		int mama = Integer.MIN_VALUE;
		int mimi = 0;
		int floor = 0; // 최대높이
		int result = Integer.MAX_VALUE; // 최소 시간
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				mama = Math.max(mama, map[i][j]);
				mimi = Math.min(mimi, map[i][j]);
			}
		} // 맵 입력하고 최대 최소값 찾기

		for (int k = mama; k >= mimi; k--) { // 시간 같을때 층이 높은거 골라달랬으니까 역순으로 탐색하겠음..
			int time = 0;
			flag = true;
			long block = B;
			for (int i = 0; i < N; i++) {

				for (int j = 0; j < M; j++) {
					if (map[i][j] == k) {
						continue;
					} else if (map[i][j] < k) {
						// 목표 높이가 더 높으면 블록 쌓아줘
						time = time + (k - map[i][j]);
						block -= (k - map[i][j]);

					} else {// 블록이 목표 높이보다 높으면
						// 블록제거
						time = time + (map[i][j] - k) * 2;
						block += (map[i][j] - k);
					}
				}

			}if(block<0) {
				continue;
			}
			if (result > time) {
				result = time;
				floor = k;
			}

		}
		System.out.println(result + " " + floor);

	}

}
