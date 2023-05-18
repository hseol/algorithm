package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1647_도시분할계획_골4 {
	static int N, M, parent[];
	static PriorityQueue<Node> pq;
    static long result =0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pq = new PriorityQueue<>();
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.offer(new Node(start, end, cost));
		}
        mst();
		System.out.println(result);
	}

	public static void mst() {
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (find(node.start) == find(node.end))
				continue;
			if (N == 2)
				break;
			union(node.start, node.end);
			result += node.cost;
			N--;

		}
	}

	public static class Node implements Comparable<Node> {
		int start;
		int end;
		int cost;

		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return find(parent[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
		return true;
	}

}
