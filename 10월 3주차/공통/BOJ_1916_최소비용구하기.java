import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{

	static int N, M; // 도시 버스
	static int[][] adjList;
	static boolean visited[];
	static int dist[];

	static class Node {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}

	}

	static int startCity, endCity;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine()); // 정점
		int M = Integer.parseInt(br.readLine()); // 간선

		List<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Node>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			graph.get(start).add(new Node(end, cost));
		}

		st = new StringTokenizer(br.readLine());
		startCity = Integer.parseInt(st.nextToken());
		endCity = Integer.parseInt(st.nextToken());

		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[startCity] = 0;

		for (int i = 0; i < N; i++) {
			int nodeValue = Integer.MAX_VALUE;
			int nodeIdx = 0;

			for (int j = 1; j < N + 1; j++) {
				if (!visited[j] && dist[j] < nodeValue) {
					nodeValue = dist[j];
					nodeIdx = j;
				}
			}

			visited[nodeIdx] = true;

			for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
				Node node = graph.get(nodeIdx).get(j);

				if (dist[node.idx] > dist[nodeIdx] + node.cost) {
					dist[node.idx] = dist[nodeIdx] + node.cost;
				}
			}

		}
		System.out.println(dist[endCity]);
	}

}