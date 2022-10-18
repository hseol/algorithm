package algo1018;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//51548KB 476ms
public class Main_G5_1916_최소비용구하기 {
	
	static List<Node>[] list;
	static int[] dp;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			list[i]=new ArrayList<>();
		}
		dp = new int[N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st = null;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int exp = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, exp));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		System.out.println(dp[end]);
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		pq.offer(new Node(start, 0));
		dp[start]=0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int to = cur.to;
			
			if(visited[to]) continue;
			
			visited[to]=true;
			for(Node next : list[to]) {
				if(dp[next.to]>=dp[to]+next.exp) {
					dp[next.to]=dp[to]+next.exp;
					pq.offer(new Node(next.to, dp[next.to]));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node> {
		int to;
		int exp;
		
		public Node (int to, int exp) {
			this.to=to;
			this.exp=exp;
		}

		@Override
		public int compareTo(Node o) {
			return this.exp-o.exp;
		}
	}
}
