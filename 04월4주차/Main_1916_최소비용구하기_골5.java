package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1916_최소비용구하기_골5 {
	static int N, M;
	static ArrayList<Bus>[] arr;
	static long map[][];
	static long answer[];

//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		N = Integer.parseInt(br.readLine());
//		M = Integer.parseInt(br.readLine());
//		map = new long[N + 1][N + 1];
//		int INF = 1000000;
//		for (int i = 0; i <= N; i++) {
//			Arrays.fill(map[i], INF);
//		}
//		for(int i =0;i<=N;i++) {
//			map[i][i] =0;
//		}
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int start = Integer.parseInt(st.nextToken());
//			int end = Integer.parseInt(st.nextToken());
//			int cost = Integer.parseInt(st.nextToken());
//			map[start][end] = cost;
//
//		}
//
//		for (int k = 1; k <= N; ++k) {
//			for (int i = 1; i <= N; ++i) {
//				if (k == i)
//					continue;
//				for (int j = 1; j <= N; ++j) {
//					if (i == k || j == i)
//						continue;
//					if (map[i][j] > map[i][k] + map[k][j]) {
//						map[i][j] = map[i][k] + map[k][j];
//					}
//				}
//			}
//		}
//		for(int i =1;i<=N;i++) {
//			for(int j=1;j<=N;j++) {
//				System.out.print(map[i][j]+" ");
//			}System.out.println();
//		}
//		st = new StringTokenizer(br.readLine());
//		System.out.println(map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]);
//
//	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		answer = new long[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			answer[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			arr[start].add(new Bus(end, cost));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		Dijk(start);
		System.out.println(answer[end]);
	}

	public static void Dijk(int start) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		pq.add(new Bus(start, 0));
		answer[start] = 0;
		while (!pq.isEmpty()) {
			Bus bus = pq.poll();
			if (answer[bus.num] < bus.cost) {
				continue;
			}
			for (int i = 0; i < arr[bus.num].size(); i++) {
				Bus b = arr[bus.num].get(i);
				if (answer[b.num] > answer[bus.num] + arr[bus.num].get(i).cost) {
					answer[b.num] = answer[bus.num] + arr[bus.num].get(i).cost;
					pq.add(new Bus(b.num, answer[b.num]));
				}
			}
		}
	}

	public static class Bus implements Comparable<Bus> {
		int num;
		long cost;

		public Bus(int num, long cost) {
			this.num = num;
			this.cost = cost;
		}

		@Override
		public int compareTo(Bus o) {
			if (this.cost > o.cost) {
				return 1;
			} else if (this.cost == o.cost) {
				return 0;
			} else {
				return -1;
			}
		}
	}

}
