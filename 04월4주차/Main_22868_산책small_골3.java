/**
 * 
 */
package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_22868_산책small_골3 {
	static ArrayList<Integer>[] arr;
	static int N, M, one, visited[];
	static boolean check[];
	static int count = 0;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		check = new boolean[N + 1];
		visited = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[start].add(end);
			arr[end].add(start);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(arr[i]);
		} // 잘은 모르겠고 정렬을 해보자
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		// check[start] = true;
		BFS(start, end);
		Arrays.fill(check, false);
		int last = visited[end];
		while (last > 0) { // 존재하면
			check[last] = true;
			last = visited[last]; // 거꾸로 올라가면서 트루처리
		}
		check[start] = false;
		BFS(end, start);
		System.out.println(count);
	}

	public static void BFS(int start, int end) {
		Queue<Walk> queue = new LinkedList<>();

		queue.offer(new Walk(start, count));
		check[start] = true;

		while (!queue.isEmpty()) {
			Walk walk = queue.poll();
			if (walk.num == end) {
				count = walk.count;
				return;
			}
			for (int i : arr[walk.num]) {
				if (check[i])
					continue;
				check[i] = true;
				visited[i] = walk.num;
				queue.offer(new Walk(i, walk.count + 1));

			}

		}

	}

	public static class Walk {
		int num;
		int count;

		public Walk(int num, int count) {
			this.num = num;
			this.count = count;

		}
	}

}
