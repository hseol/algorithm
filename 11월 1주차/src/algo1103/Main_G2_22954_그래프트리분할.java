package algo1103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G2_22954_그래프트리분할 {
	
	static List<Node>[] nodes;
	static List<Integer>[] vertexes;
	static List<Integer>[] edges;
	
	static boolean[] visited;
	static boolean[] isLeaf;
	
	static int size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nodes = new ArrayList[N+1];
		vertexes = new ArrayList[N+1];
		edges = new ArrayList[N+1];
		for(int i=0; i<=N; i++) {
			nodes[i] = new ArrayList<>();
			vertexes[i] = new ArrayList<>();
			edges[i] = new ArrayList<>();
		}
		
		visited = new boolean[N+1];
		isLeaf = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			nodes[u].add(new Node(v, i));
			nodes[v].add(new Node(u, i));
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			recur(i, size);
			size++;
		}
		
		System.out.print(prints(N));
	}

	private static String prints(int n) {
		if(size>2) return "-1";
		if(size<2) decomposition(n);
		
		if(vertexes[0].size() == vertexes[1].size()) return "-1";
		
		StringBuilder sb = new StringBuilder();
		sb.append(vertexes[0].size()).append(" ").append(vertexes[1].size()).append("\n");
		
		for(int i=0; i<2; i++) {
			Collections.sort(vertexes[i]);
			Collections.sort(edges[i]);
			
			for(int vertex : vertexes[i]) {
				sb.append(vertex + 1).append(" ");
			}
			
			sb.append("\n");
			
			for(int edge : edges[i]) {
				sb.append(edge + 1).append(" ");
			}
			
			sb.append("\n");
		}	
		
		return sb.toString();
	}

	private static void decomposition(int n) {
		int leaf = 0;
		int start = 0;
		
		for(int vertex : vertexes[0]) {
			if(isLeaf[vertex]) leaf = vertex;
			else start = vertex;
		}
		
		vertexes[0] = new ArrayList<>();
		edges[0] = new ArrayList<>();
		
		visited = new boolean[n];
		visited[leaf] = true;
		
		recur(start, 0);
		vertexes[1].add(leaf);
	}
	
	private static void recur(int cur, int idx) {
		vertexes[idx].add(cur);
		visited[cur] = true;
		
		boolean flag = true;
		
		for(Node next : nodes[cur]) {
			if(visited[next.to]) continue;
			edges[idx].add(next.idx);
			
			flag = false;
			recur(next.to, idx);
		}
		
		isLeaf[cur]=flag;
	}

	static class Node {
		int to;
		int idx;
		
		public Node(int to, int idx) {
			this.to=to;
			this.idx=idx;
		}
	}
}
