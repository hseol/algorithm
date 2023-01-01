package BruthForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1966_프린터큐_실3 {
	static int T, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		Queue<int[]> queue = new LinkedList<>();
		while (T-- > 0) {
			int cnt=0;
			queue.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int temp = Integer.parseInt(st.nextToken());
				queue.offer(new int[] {i, temp});

			}
			while (!queue.isEmpty()) {
				int[] number = queue.poll();
				boolean check = true;
				for (int[] q : queue) {
					if (number[1] < q[1]) {
						check = false;
					}
				}
				if (check) {
					cnt++;
					if (number[0] == M) {
						break;
					}
						

				} else {// 큐 어딘가에 나보다 큰 애가 있음
					queue.offer(number);
				}
			}
			System.out.println(cnt);
		}

	}

}
