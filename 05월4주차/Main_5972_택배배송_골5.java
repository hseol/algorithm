/**
 * 
 */
package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972_택배배송_골5 {
	static int N, M;
	static long costs[];
	static PriorityQueue<Node> pq;
	static boolean check[];
	static List<List<Node>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		list = new ArrayList<>();
		pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 개수
		M = Integer.parseInt(st.nextToken());// 올라올 입력값 개수\
		costs = new long[N + 1];
		check = new boolean[N + 1];
		Arrays.fill(costs, Integer.MAX_VALUE);
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(start).add(new Node(end, cost));
			list.get(end).add(new Node(start, cost));
		} // 입력 끝

		Dijk(1);
		System.out.println(costs[N]);
	}

	public static void Dijk(int index) {
		pq.offer(new Node(index, 0));
		costs[index] = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (node.cost > costs[node.number])
				continue;
			for (Node n : list.get(node.number)) {
				if (node.cost + n.cost < costs[n.number]) {
					costs[n.number] = node.cost + n.cost;
					pq.offer(new Node(n.number, costs[n.number]));
				}
			}
		}

	}

	public static class Node implements Comparable<Node> {
		int number;
		long cost;

		public Node(int number, long cost) {
			this.number = number;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			if (this.cost > o.cost) {
				return 1;
			} else if (this.cost == o.cost)
				return 0;
			else {
				return -1;
			}
		}
	}

}
