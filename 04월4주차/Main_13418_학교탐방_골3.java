/**
 * 
 */
package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @FileName : Main_13418_학교탐방_골3.java
 * 
 * @Project : NewAlgo
 * 
 * @Date : 2023. 4. 24.
 * 
 * @작성자 : hseol
 * 
 * @변경이력 :
 * 
 * @프로그램 설명 :
 * 
 */

public class Main_13418_학교탐방_골3 {
	public static int N, M;
	public static Queue<Node> ascQueue = new PriorityQueue<>();
	public static Queue<Node> descQueue = new PriorityQueue<>((v1, v2) -> v2.weight - v1.weight);
	public static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		int enter = 1-Integer.parseInt(br.readLine().split(" ")[2]);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = 1-Integer.parseInt(st.nextToken()); //오르막길 1, 내리막길 0
			ascQueue.offer(new Node(start, end, weight));
			descQueue.offer(new Node(start, end, weight));
		}
		for(int i =1;i<=N;i++) {
			parents[i]=i;
		}
		int cnt = 0;
		int piroMin = enter;
		while (cnt<N-1) {
			Node node = ascQueue.poll();
			if (union(node.start, node.end)) {
				cnt++;
				piroMin += node.weight;
			}
		}
		
		for(int i =1;i<=N;i++) {
			parents[i]=i;
		}
		cnt = 0;
		int piroMax = enter;
		while (cnt<N-1) {
			Node node = descQueue.poll();
			if (union(node.start, node.end)) {
				cnt++;
				piroMax += node.weight;
			}
		}

		System.out.println(piroMax*piroMax - piroMin*piroMin);
	}

	public static boolean union(int start, int end) {
		start = find(start);
		end = find(end);
		if(start==end)return false;
		
		parents[end]=start;
		return true;
	}

	public static int find(int v) {
		if (parents[v] == v) {
			return v;
		}

		return parents[v] = find(parents[v]);

	}

	public static class Node implements Comparable<Node> {
		int start;
		int end;
		int weight;

		public Node(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;

		}

		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}
