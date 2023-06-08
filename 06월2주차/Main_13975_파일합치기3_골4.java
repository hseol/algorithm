package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13975_파일합치기3_골4 {
	static long x, y, sum, result;
	static int N;
	static StringBuilder sb;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new long[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			calcul();
		}
		System.out.println(sb);

	}

	public static void calcul() {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		result = 0;
		for (int i = 0; i < N; i++) {
			pq.offer(arr[i]);
		}
		while (pq.size() > 1) {
		 x = pq.poll();
			 y = pq.poll();
			 sum = x + y;
			result += sum;
			pq.offer(sum);
		}
		sb.append(result).append("\n");
	}

}
