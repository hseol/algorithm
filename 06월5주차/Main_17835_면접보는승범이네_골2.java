import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17835_면접보는승범이네_골2 {
	public static class Node {
		int num;
		long distance;

		public Node(int num, long distance) {
			this.num = num;
			this.distance = distance;
		}

	}

	static int N, M, K;
	static long dist[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->Long.compare(a.distance, b.distance));
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dist = new long[N + 1];
		// map = new long[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		Arrays.fill(dist, Long.MAX_VALUE);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			list.get(start).add(new Node(end, distance));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int exam = Integer.parseInt(st.nextToken());
			pq.offer(new Node(exam, 0));
			dist[exam] = 0;
		}

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if (dist[current.num] < current.distance)
				continue;
			for (Node next : list.get(current.num)) {
				if (dist[next.num] > current.distance + next.distance) {
					dist[next.num] = current.distance + next.distance;
					pq.offer(new Node(next.num, dist[next.num]));
				}
			}
		} // 면접장 번호랑 상관이 없는거...?
		int annum = 0;
		long result = 0;
		for (int i = 1; i <= N; i++) {
			if (result < dist[i]) {
				result = dist[i];
				annum = i;
			}
		}
		System.out.println(annum + "\n" + result);

	}

}
